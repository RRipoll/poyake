package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.flatfileconversion;



import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Html;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vbox;

public class FileTranslatorView {
   public Combobox filetype;
   public Button upload = new Button("Upload File");
   public Label uploadfile = new Label();
   public Button runFile = new Button("Run File");
   public Hbox hboxbutton;
   public Textbox textBox = new Textbox();
   
   @SuppressWarnings({ "rawtypes", "unchecked" })
public FileTranslatorView(Component comp, EventListener eventListener){
	   Html html = new Html("<br/>");
	   html.setParent(comp);
	   Vbox vbox = new Vbox();
		vbox.setParent(comp);
	   hboxbutton = new Hbox();
	   hboxbutton.setParent(vbox);
	   filetype = (Combobox)comp.getFellow("FILETYPE");
	   
	   upload.setParent(hboxbutton);	
	   upload.setUpload("true");
	   upload.addEventListener(Events.ON_UPLOAD,eventListener);
	   
	   uploadfile.setParent(hboxbutton);
	   
	   
	   runFile.setParent(hboxbutton);
	   runFile.addEventListener(Events.ON_CLICK,eventListener);
	   
	
		Hbox hbox1 = new Hbox();
		hbox1.setParent(comp);
        
		textBox.setParent(hbox1);
		textBox.setVisible(false);
		textBox.setCols(220);
		textBox.setRows(30);	
   }
}
