package sql;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class DBCreationPath {

	
	public   File getFileFromURL() {
	    URL url = this.getClass().getClassLoader().getResource("DB_Creation_Script.sql");
	    File file = null;
	    try {
	        file = new File(url.toURI());
	    } catch (URISyntaxException e) {
	        file = new File(url.getPath());
	    } finally {
	        return file;
	    }
	}
	
}
