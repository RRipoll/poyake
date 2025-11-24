package com.etantolling.testrunner.test.core.generatedmetadata.testrepository;

import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mtenumerations.MTEnuEVENTTYPE;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mtenumerations.MTTableSTEP;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables.MTTableADM_APP_INFO;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables.MTTableADM_SQL_LOG;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables.MTTableEVENT;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables.MTTableEVENTDEFFOLDER;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables.MTTableEVENTDEFINITION;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables.MTTableEVENTFILE;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables.MTTableEVENTTYPE;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables.MTTableFILEREF;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables.MTTableFILETYPE;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables.MTTableFOLDER;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables.MTTableINPUTUSER;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables.MTTableMTTABLEINFO;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables.MTTableTEST;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables.MTTableTESTRUN;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables.MTTableTESTRUNFILE;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables.MTTableTESTSCRIPT;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables.MTTableTESTSCRIPTITEM;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables.MTTableTE_RESETDB;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables.MTTableYESNO;
import com.etantolling.testrunner.test.core.metadata.MTBase;
import com.etantolling.testrunner.test.core.metadata.MTEnumeration;
import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

@SuppressWarnings("unused")
public class MT extends MTBase{
	public static final MTTableADM_APP_INFO ADM_APP_INFO = new MTTableADM_APP_INFO();
	public static final MTTableADM_SQL_LOG ADM_SQL_LOG = new MTTableADM_SQL_LOG();
	public static final MTTableEVENT EVENT = new MTTableEVENT();
	public static final MTTableEVENTDEFFOLDER EVENTDEFFOLDER = new MTTableEVENTDEFFOLDER();
	public static final MTTableEVENTDEFINITION EVENTDEFINITION = new MTTableEVENTDEFINITION();
	public static final MTTableEVENTFILE EVENTFILE = new MTTableEVENTFILE();
	public static final MTTableEVENTTYPE EVENTTYPE = new MTTableEVENTTYPE();
	public static final MTTableSTEP STEP = new MTTableSTEP();
	public static final MTTableFILEREF FILEREF = new MTTableFILEREF();
	public static final MTTableFILETYPE FILETYPE = new MTTableFILETYPE();
	public static final MTTableFOLDER FOLDER = new MTTableFOLDER();
	public static final MTTableINPUTUSER INPUTUSER = new MTTableINPUTUSER();
	public static final MTTableMTTABLEINFO MTTABLEINFO = new MTTableMTTABLEINFO();
	public static final MTTableTE_RESETDB TE_RESETDB = new MTTableTE_RESETDB();
	public static final MTTableTEST TEST = new MTTableTEST();
	public static final MTTableTESTRUN TESTRUN = new MTTableTESTRUN();
	public static final MTTableTESTRUNFILE TESTRUNFILE = new MTTableTESTRUNFILE();
	public static final MTTableTESTSCRIPT TESTSCRIPT = new MTTableTESTSCRIPT();
	public static final MTTableTESTSCRIPTITEM TESTSCRIPTITEM = new MTTableTESTSCRIPTITEM();
	
		public static final MTTableYESNO YESNO = new MTTableYESNO();
	static{
		enums.put("EVENTTYPE", new MTEnuEVENTTYPE());

		tables.put("ADM_APP_INFO",ADM_APP_INFO);
		tables.put("ADM_SQL_LOG",ADM_SQL_LOG);
		tables.put("EVENT",EVENT);
		tables.put("EVENTDEFFOLDER",EVENTDEFFOLDER);
		tables.put("EVENTDEFINITION",EVENTDEFINITION);
		tables.put("EVENTFILE",EVENTFILE);
		tables.put("EVENTTYPE",EVENTTYPE);
		tables.put("STEP",STEP);
		tables.put("FILEREF",FILEREF);
		tables.put("FILETYPE",FILETYPE);
		tables.put("FOLDER",FOLDER);
		tables.put("INPUTUSER",INPUTUSER);
		tables.put("MTTABLEINFO",MTTABLEINFO);
		tables.put("TE_RESETDB",TE_RESETDB);
		tables.put("TEST",TEST);
		tables.put("TESTRUN",TESTRUN);
		tables.put("TESTRUNFILE",TESTRUNFILE);
		tables.put("TESTSCRIPT",TESTSCRIPT);
		tables.put("TESTSCRIPTITEM",TESTSCRIPTITEM);
		
		tables.put("YESNO",YESNO);
	}
	public static MTTable getTable(String tableName){ return tables.get(tableName.toUpperCase());}	
	public static MTEnumeration getEnumeration(String tableName){return enums.get(tableName.toUpperCase());} 


	public static MTField getField(String fullyQualifiedFieldName){  
		String tableName = fullyQualifiedFieldName.substring(0, fullyQualifiedFieldName.indexOf("."));  
		String fieldName = fullyQualifiedFieldName.substring(fullyQualifiedFieldName.indexOf(".") + 1, fullyQualifiedFieldName.length());  
		if (null == getTable(tableName))  
		System.out.println("table " + tableName + " not found");   
		return getTable(tableName).getField(fieldName);  
	}  
}
