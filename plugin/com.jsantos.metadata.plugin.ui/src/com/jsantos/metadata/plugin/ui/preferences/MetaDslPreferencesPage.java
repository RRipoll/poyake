package com.jsantos.metadata.plugin.ui.preferences;

import org.eclipse.datatools.connectivity.IConnectionProfile;
import org.eclipse.datatools.connectivity.internal.InternalProfileManager;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.jsantos.metadata.plugin.ui.internal.PluginActivator;

public class MetaDslPreferencesPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	RadioGroupFieldEditor provideDetails;
	StringFieldEditor jdbcUrl;
	StringFieldEditor jdbcUser;
	StringFieldEditor jdbcPassword;
	ComboFieldEditor connectionProfile;
	
	public MetaDslPreferencesPage() {
		super(FieldEditorPreferencePage.GRID);

		//		// Set the preference store for the preference page.
		//IPreferenceStore store = MetaDslUiModule.getDefault().getPreferenceStore();
		
		setPreferenceStore(PluginActivator.getInstance().getPreferenceStore());
	}	

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createFieldEditors() {
		// Initialize all field editors.

		//addField (new StringFieldEditor("Java Base Package", "Java Base Package", getFieldEditorParent()));
		//addField (new StringFieldEditor("Database Connection Profile", "Database Connection Profile", getFieldEditorParent()));

		// create the connection profile combo from existing DTP profiles
		System.out.println(InternalProfileManager.getInstance());
		IConnectionProfile[] profiles = InternalProfileManager.getInstance().getProfiles(true);
		String[][] sProfiles = new String[profiles.length+1][2];
		int profileCount = 1;
		sProfiles[0][0] = "";
		sProfiles[0][1] = "";
		for(IConnectionProfile profile:profiles) {
			sProfiles[profileCount][0] = profile.getName();
			sProfiles[profileCount][1] = profile.getName();
			profileCount++;
		}
		
		provideDetails = new RadioGroupFieldEditor("provide details",
	            "You can provide the connection details or you can use an existing Data Tools Connection Profile", 2,
	            new String[][] { { "Provide Connection details", "Provide Connection details" },{ "Use Data Tools Connection Profile", "Use Data Tools Connection Profile" }
	                 }, getFieldEditorParent()); 
		addField(provideDetails);		

		connectionProfile = new ComboFieldEditor("Database Connection Profile", "Connection:", sProfiles, getFieldEditorParent()); 
		addField (connectionProfile);
		
		jdbcUrl = new StringFieldEditor("jdbc url", "jdbc url:", getFieldEditorParent());
		addField (jdbcUrl);
		jdbcUser = new StringFieldEditor("jdbc username", "jdbc username:", getFieldEditorParent()); 
		addField (jdbcUser);
		jdbcPassword = new StringFieldEditor("jdbc password", "jdbc password:", getFieldEditorParent()); 
		addField (jdbcPassword);
		
		//enableDisable();
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent event) {
	    super.propertyChange(event);
	    enableDisable();
	}
	
	void enableDisable() {
	    if (provideDetails.getSelectionValue().equals("Provide Connection details")) {
	    	jdbcUrl.setEnabled(true, getFieldEditorParent());
	    	jdbcUser.setEnabled(true, getFieldEditorParent());
	    	jdbcPassword.setEnabled(true, getFieldEditorParent());
	    	connectionProfile.setEnabled(false, getFieldEditorParent());
	    }
	    else {
	    	jdbcUrl.setEnabled(false, getFieldEditorParent());
	    	jdbcUser.setEnabled(false, getFieldEditorParent());
	    	jdbcPassword.setEnabled(false, getFieldEditorParent());
	    	connectionProfile.setEnabled(true, getFieldEditorParent());
	    }
		
	}

}