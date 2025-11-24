package com.jsantos.metadata.plugin.ui.customdialogs;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.datatools.connectivity.IConnectionProfile;
import org.eclipse.datatools.connectivity.internal.InternalProfileManager;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.jsantos.metadata.plugin.dbmanager.dbresetter.ConnectionPreferences;
import com.jsantos.metadata.plugin.ui.internal.PluginActivator;
import com.jsantos.metadata.plugin.ui.util.MetaDslUtil;

public class DBConnectionPreferencesDialog extends Dialog {
	public static String DBRESET = "DBRESET";
	public static String REVERSE_ENGINEER = "REVERSE_ENGINEER";

	Composite container;
	Combo comboConnectionProfile;
	Combo comboProject;
	Button buttonUseProfile;
	Button buttonProvideDetails;
	Button buttonInitializeWithDefaults;
	Text jdbcUrl;
	Text jdbcUser;
	Text jdbcPassword;
	String sProject;
	RadioSelectionListener radioSelectionListener = new RadioSelectionListener();
	ConnectionPreferences prefs;
	String usage;
	Text folder;
	String sFolder;
	
    public DBConnectionPreferencesDialog(Shell parentShell, String usage) {
        super(parentShell);
        this.usage = usage;
    }
    
    protected boolean isResizable() {
        return true;
    }

    
    
    @Override
    protected Control createDialogArea(Composite parent) {
        container = (Composite) super.createDialogArea(parent);
        
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 3;
        container.setLayout(gridLayout);
        

		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
        
        new Label(container, SWT.PUSH).setText("Project: ");
        comboProject = new Combo(container, SWT.PUSH);
        comboProject.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		comboProject.addSelectionListener(new ProjectSelectionListener());
       int nIndex = 0;
		for(IProject project:ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			try {
				if (project.isOpen() && null !=project.getNature("org.eclipse.xtext.ui.shared.xtextNature")) {
					comboProject.add(project.getName());
				    if (null != PluginActivator.getInstance().getPreferenceStore().getString("com.jsantos.metadsl.resetdbdialog.project"))
				    	if (project.getName().equalsIgnoreCase(PluginActivator.getInstance().getPreferenceStore().getString("com.jsantos.metadsl.resetdbdialog.project"))) {
				    		comboProject.select(nIndex);
				    	}
				    nIndex++;
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		if (1==nIndex)
			comboProject.select(0);
        
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
        
		buttonUseProfile = new Button(container, SWT.RADIO);
		buttonUseProfile.setText("Use Data Tools Connection Profile");
		buttonUseProfile.addSelectionListener(radioSelectionListener);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

        
        
		new Label(container, SWT.NONE);
        new Label(container, SWT.PUSH).setText("Connection Profile: ");
        comboConnectionProfile = new Combo(container, SWT.PUSH);
        comboConnectionProfile.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		for(IConnectionProfile profile:InternalProfileManager.getInstance().getProfiles(true)) { 
	        comboConnectionProfile.add(profile.getName());
		}

		buttonProvideDetails = new Button(container, SWT.RADIO);
		buttonProvideDetails.setText("Provide jdbc details");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
        
		new Label(container, SWT.NONE);
		new Label(container, SWT.PUSH).setText("Jdbc Url:");
		jdbcUrl = new Text(container, SWT.BORDER);
		jdbcUrl.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		
		new Label(container, SWT.NONE);
		new Label(container, SWT.PUSH).setText("Jdbc User Name:");
		jdbcUser = new Text(container, SWT.BORDER); 
		jdbcUser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		new Label(container, SWT.NONE);
		new Label(container, SWT.PUSH).setText("Jdbc Password:");
		jdbcPassword = new Text(container, SWT.BORDER); 
		jdbcPassword.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	
		if (REVERSE_ENGINEER.equals(usage)) {
			new Label(container, SWT.NONE);
			new Label(container, SWT.NONE);
			new Label(container, SWT.NONE);

			Label label = new Label(container, SWT.NONE);
	        label.setText("Folder inside project: ");
			folder = new Text(container, SWT.BORDER);
			folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
			folder.setText("/src/main/resources/metadata/");
			sFolder = folder.getText();
			folder.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent e) {
					sFolder = folder.getText();
				}
			});
			new Label(container, SWT.NONE);
		}

		if (-1 !=comboProject.getSelectionIndex()) {
			sProject = comboProject.getItem(comboProject.getSelectionIndex());
			initializeFromPreferencesStorage(sProject);
		}

		
		new Label(container, SWT.NONE);
		buttonInitializeWithDefaults = new Button(container, SWT.BORDER);
		buttonInitializeWithDefaults.setText("Initialize with default test database settings");
		buttonInitializeWithDefaults.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		buttonInitializeWithDefaults.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event e) {
		          switch (e.type) {
		          case SWT.Selection:
		  			buttonUseProfile.setSelection(false);
					buttonProvideDetails.setSelection(true);
					jdbcUrl.setText("jdbc:h2:~/testdbn6;AUTO_SERVER=TRUE;");
					jdbcUser.setText("sa");
					jdbcPassword.setText("sa");
		            break;
		          }
		        }
		      });
		
		enableDisable();
		return container;
    }

    
    
    
    void initializeFromPreferencesStorage(String sProject) {
		prefs = MetaDslUtil.readConnectionPreferences(sProject);
		if (null != prefs && !prefs.isEmpty()) {
			buttonUseProfile.setSelection(prefs.isUseEclipse());
			buttonProvideDetails.setSelection(!prefs.isUseEclipse());
			jdbcUrl.setText(prefs.getUrl());
			jdbcUser.setText(prefs.getUser());
			jdbcPassword.setText(prefs.getPassword());

			if (prefs.isUseEclipse()) {
				if (StringUtils.isNotBlank(prefs.getEclipseConnectionProfile())) {
					for (String sProfile:comboConnectionProfile.getItems()) {
						if (sProfile.equalsIgnoreCase(prefs.getEclipseConnectionProfile()))
				        		comboConnectionProfile.select(comboConnectionProfile.indexOf(sProfile));
					}
				}
				if (1==comboConnectionProfile.getItemCount())
					comboConnectionProfile.select(0);
			}
		}
		else {
			buttonUseProfile.setSelection(false);
			buttonProvideDetails.setSelection(true);
	    	jdbcUrl.setEnabled(true);
	    	jdbcUser.setEnabled(true);
	    	jdbcPassword.setEnabled(true);
	    	comboConnectionProfile.setEnabled(false);
		}
    }
    
    Boolean hasDefaultConnection(String sProject) {
    	if ("poyake-demo".equals(sProject))
    		return true;
    	if ("h2test".equals(sProject))
    		return true;
    	if ("ormsimple".equals(sProject))
    		return true;
    	
    	return false;
    }
    
    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("Connection Profile Selection");
    }

    @Override
    protected Point getInitialSize() {
        return new Point(800, 400);
    }

	@Override
	protected void okPressed() {
		if (-1 !=comboProject.getSelectionIndex())
			sProject = comboProject.getItem(comboProject.getSelectionIndex());
		
		/*
			if (-1 !=comboConnectionProfile.getSelectionIndex())
				sConnectionProfile =  comboConnectionProfile.getItem(comboConnectionProfile.getSelectionIndex());
		*/
			
		if (StringUtils.isNotBlank(sProject)) {
			PluginActivator.getInstance().getPreferenceStore().setValue("com.jsantos.metadsl.resetdbdialog.project", sProject);
			//PluginActivator.getInstance().getPreferenceStore().setValue("com.jsantos.metadsl.resetdbdialog.connectionprofile", sConnectionProfile);
			readConnectionPreferences();
			MetaDslUtil.saveConnectionPreferences(sProject, prefs);
			super.okPressed();
		}
		else {
			MessageDialog.openInformation(getParentShell(),"com.jsantos.metadata.plugin.ui","No Project Selected, Please select a project");

		}
	}
    
//	public String getConnectionProfile() {
//		return sConnectionProfile;
//	}

	public ConnectionPreferences getConnectionPreferences() {
		return prefs;
	}

	void readConnectionPreferences() {
		prefs = new ConnectionPreferences();
		prefs.setUseEclipse(buttonUseProfile.getSelection());
		if (prefs.isUseEclipse() && -1 !=comboConnectionProfile.getSelectionIndex())
			prefs.setEclipseConnectionProfile(comboConnectionProfile.getItem(comboConnectionProfile.getSelectionIndex()));
		prefs.setUrl(jdbcUrl.getText());
		prefs.setUser(jdbcUser.getText());
		prefs.setPassword(jdbcPassword.getText());
	}
	
	
	public String getProject() {
		return sProject;
	}

	public String getFolder() {
		return sFolder;
	}
	
	void enableDisable() {
		if (buttonUseProfile.getSelection()) {
	    	jdbcUrl.setEnabled(false);
	    	jdbcUser.setEnabled(false);
	    	jdbcPassword.setEnabled(false);
	    	buttonInitializeWithDefaults.setEnabled(false);
	    	comboConnectionProfile.setEnabled(true);
		}
		else {
	    	jdbcUrl.setEnabled(true);
	    	jdbcUser.setEnabled(true);
	    	jdbcPassword.setEnabled(true);
	    	buttonInitializeWithDefaults.setEnabled(true);
	    	comboConnectionProfile.setEnabled(false);
		}
		
	}
	
	class RadioSelectionListener implements SelectionListener{

		@Override
		public void widgetSelected(SelectionEvent e) {
			enableDisable();
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class ProjectSelectionListener implements SelectionListener{

		@Override
		public void widgetSelected(SelectionEvent e) {
			if (-1 !=comboProject.getSelectionIndex()) {
				sProject = comboProject.getItem(comboProject.getSelectionIndex());
				initializeFromPreferencesStorage(sProject);
			}
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}