package com.etantolling.testrunner.testrunner2.file;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Messagebox;

import com.etantolling.testrunner.test.core.config.AppInfo;
import com.etantolling.testrunner.test.zkweb.IPanel;

public class FileUploader extends GenericForwardComposer<Component> implements EventListener,IPanel{
	
	private static final Logger log = LoggerFactory.getLogger(FileUploader.class);
	Component comp;
	Combobox comboboxLocation; 
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		this.comp = comp;
		comp.getFellow("UPLOAD").addEventListener(Events.ON_UPLOAD, this);
		comboboxLocation= (Combobox)comp.getFellow("supported_locations");
		String[] locations = AppInfo.get(AppInfo.INCOMING_DOCUMENTS_SUPPORTED_LOCATIONS).split(",");
		for (String location:locations){
			Comboitem comboitem = new Comboitem(location);
			comboitem.setParent(comboboxLocation);
			comboitem.setValue(location);;
		}
			
	}
	
	@Override
	public void onEvent(Event event) throws Exception {
		if(event.getTarget().equals(comp.getFellow("UPLOAD"))){
			log.info(event.toString());
			if(event.getName().equals(Events.ON_UPLOAD)){
				Media media = ((UploadEvent)event).getMedia();
				String directory="/nasshare/"+ AppInfo.get(AppInfo.KEY_DATABASE_ID) + "/input/documents/"; // comboboxLocation.getSelectedItem().getValue();
				File folder = new File(directory);
				folder.mkdirs();
				
				File file = new File(folder,media.getName());
				InputStream inputStream;
				try{
		        	 inputStream= media.getStreamData();
				}catch (Exception e){
					inputStream=new ByteArrayInputStream(media.getStringData().getBytes("UTF-8"));
				}
		        OutputStream out=new FileOutputStream(file);
		        IOUtils.copy(inputStream, out);
		        inputStream.close();
		        out.close();
				
		        Messagebox.show("File upload successfully");
			}
		}
	}
	
	@Override
	public Component getPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void layout() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setId(Object Id) {
		// TODO Auto-generated method stub
		
	}


}
