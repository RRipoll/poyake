package com.etantolling.testrunner.test.zkweb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.A;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Vbox;

import com.etantolling.testrunner.test.core.config.EnvironmentHelper;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;

public class EventFileUtils {

	static public Component  loadExistingImages(Integer eventId,EventListener<Event> el) throws SQLException{
		Connection conn = MainDb.getConnection();
		Hlayout parent= new Hlayout();
		try{
			Statement st = conn.createStatement();
			String versionDate=EnvironmentHelper.getVersionDate();
			String sql = "select ef.filerefid, name, azureurl, eventfileid from fileref fr join eventfile ef on ef.startdate<="+versionDate+" and ef.enddate>="+versionDate+" and fr.filerefid=ef.filerefid and eventid=" + eventId;
			ResultSet rs = st.executeQuery(sql);
			Vbox vbox= new Vbox();
			vbox.setParent(parent);
			while (rs.next()){
		        Div newFileDiv = new Div();
		        newFileDiv.setStyle("float:left;text-weight:bold;padding:0px 0px 0px 4px;cursor:pointer");
		        newFileDiv.setParent(vbox);
		        //Button deleteFileButton = new Button();
		        A newFileLabel = new A(rs.getString("name"));
		        
		        newFileLabel.setAttribute("FILEREFID", rs.getInt("filerefid"));
		        newFileLabel.setAttribute("NAME", rs.getString("name"));
		        newFileLabel.setAttribute("AZUREURL", rs.getString("azureurl"));
		        newFileLabel.setAttribute("EVENTFILEID", rs.getInt("eventfileid"));
		        //newFileLabel.addEventListener(Events.ON_CLICK, el);
		        newFileLabel.setParent(newFileDiv);
		        newFileLabel.setHref(rs.getString("AZUREURL"));
		        newFileLabel.setParent(newFileDiv);		
		        newFileLabel.setTarget("_blank");
			}
			rs.close();
			st.close();
		}
		finally{
			conn.close();
		}
		return parent;
	}
}