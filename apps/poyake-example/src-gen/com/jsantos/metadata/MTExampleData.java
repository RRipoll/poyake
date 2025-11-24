package com.jsantos.metadata;

import com.jsantos.orm.mt.MTBase; 
import com.jsantos.metadata.example.*;
import com.jsantos.metadata.audit.*;
import com.jsantos.metadata.config.*;
import com.jsantos.metadata.label.*;

public class MTExampleData extends MTBase{ 
	static boolean initialized = false;

	public static MTTableAUTHOR AUTHOR;
	public static MTTableBOOK BOOK;
	public static MTTableBOOKAUTHOR BOOKAUTHOR;
	public static MTTableGENRE GENRE;
	public static MTTableVBOOK VBOOK;
	public static MTTableINPUTSOURCE INPUTSOURCE;
	public static MTTableINPUTUSER INPUTUSER;
	public static MTTableINPUTUSERGROUP INPUTUSERGROUP;
	public static MTTableUSERGROUP USERGROUP;
	public static MTTableVUSERMULTIGROUP VUSERMULTIGROUP;
	public static MTTableVINPUTUSER VINPUTUSER;
	public static MTTableVINPUTUSERMULTI VINPUTUSERMULTI;
	public static MTTableVUSERGROUP VUSERGROUP;
	public static MTTableAPPDATATYPE APPDATATYPE;
	public static MTTableAPPINFO APPINFO;
	public static MTTableAPPINFOTREE APPINFOTREE;
	public static MTTablePOSTINGDATE POSTINGDATE;
	public static MTTableDATAGRIDSETTING DATAGRIDSETTING;
	public static MTTableENULOCALE ENULOCALE;
	public static MTTableMTLABEL MTLABEL;

	public static void init(){
		if (initialized) return;
		initialized = true;

		MTExampleData.init();
		MTCommonData.init();
		MTAuditData.init();
		MTDataGridSettingData.init();
		MTLabelData.init();
		AUTHOR = new MTTableAUTHOR();
		BOOK = new MTTableBOOK();
		BOOKAUTHOR = new MTTableBOOKAUTHOR();
		GENRE = new MTTableGENRE();
		VBOOK = new MTTableVBOOK();
		INPUTSOURCE = new MTTableINPUTSOURCE();
		INPUTUSER = new MTTableINPUTUSER();
		INPUTUSERGROUP = new MTTableINPUTUSERGROUP();
		USERGROUP = new MTTableUSERGROUP();
		VUSERMULTIGROUP = new MTTableVUSERMULTIGROUP();
		VINPUTUSER = new MTTableVINPUTUSER();
		VINPUTUSERMULTI = new MTTableVINPUTUSERMULTI();
		VUSERGROUP = new MTTableVUSERGROUP();
		APPDATATYPE = new MTTableAPPDATATYPE();
		APPINFO = new MTTableAPPINFO();
		APPINFOTREE = new MTTableAPPINFOTREE();
		POSTINGDATE = new MTTablePOSTINGDATE();
		DATAGRIDSETTING = new MTTableDATAGRIDSETTING();
		ENULOCALE = new MTTableENULOCALE();
		MTLABEL = new MTTableMTLABEL();

		tables.put("AUTHOR", AUTHOR);
		tables.put("BOOK", BOOK);
		tables.put("BOOKAUTHOR", BOOKAUTHOR);
		tables.put("GENRE", GENRE);
		tables.put("VBOOK", VBOOK);
		tables.put("INPUTSOURCE", INPUTSOURCE);
		tables.put("INPUTUSER", INPUTUSER);
		tables.put("INPUTUSERGROUP", INPUTUSERGROUP);
		tables.put("USERGROUP", USERGROUP);
		tables.put("VUSERMULTIGROUP", VUSERMULTIGROUP);
		tables.put("VINPUTUSER", VINPUTUSER);
		tables.put("VINPUTUSERMULTI", VINPUTUSERMULTI);
		tables.put("VUSERGROUP", VUSERGROUP);
		tables.put("APPDATATYPE", APPDATATYPE);
		tables.put("APPINFO", APPINFO);
		tables.put("APPINFOTREE", APPINFOTREE);
		tables.put("POSTINGDATE", POSTINGDATE);
		tables.put("DATAGRIDSETTING", DATAGRIDSETTING);
		tables.put("ENULOCALE", ENULOCALE);
		tables.put("MTLABEL", MTLABEL);

		MTTableBOOK.AUTHORID.setForeignKey(AUTHOR);
		MTTableBOOK.GENREID.setForeignKey(GENRE);
		MTTableBOOKAUTHOR.BOOKID.setForeignKey(BOOK);
		MTTableBOOKAUTHOR.AUTHORID.setForeignKey(AUTHOR);
		MTTableVBOOK.AUTHORID.setForeignKey(AUTHOR);
		MTTableVBOOK.OTHERAUTHOR.setMultiRefTo(BOOKAUTHOR);
		MTTableINPUTUSER.INPUTSOURCEID.setForeignKey(INPUTSOURCE);
		MTTableUSERGROUP.INPUTUSERGROUPID.setForeignKey(INPUTUSERGROUP);
		MTTableUSERGROUP.USERID.setForeignKey(INPUTUSER);
		MTTableUSERGROUP.INPUTUSERID.setForeignKey(INPUTUSER);
		MTTableUSERGROUP.INPUTSOURCEID.setForeignKey(INPUTSOURCE);
		MTTableVUSERMULTIGROUP.INPUTSOURCEID.setForeignKey(INPUTSOURCE);
		MTTableVUSERMULTIGROUP.USERGROUPS.setMultiRefTo(USERGROUP);
		MTTableVINPUTUSER.INPUTUSERGROUPID.setForeignKey(INPUTUSERGROUP);
		MTTableVINPUTUSERMULTI.INPUTSOURCEID.setForeignKey(INPUTSOURCE);
		MTTableVINPUTUSERMULTI.USERGROUPS.setMultiRefTo(USERGROUP);
		MTTableVUSERGROUP.INPUTUSERGROUPID.setForeignKey(INPUTUSERGROUP);
		MTTableVUSERGROUP.USERID.setForeignKey(INPUTUSER);
		MTTableVUSERGROUP.INPUTUSERID.setForeignKey(INPUTUSER);
		MTTableVUSERGROUP.INPUTSOURCEID.setForeignKey(INPUTSOURCE);
		MTTableAPPINFO.TYPE.setForeignKey(APPDATATYPE);
		MTTableAPPINFO.INPUTUSERGROUPID.setForeignKey(INPUTUSERGROUP);
		MTTableAPPINFOTREE.PARENTAPPINFOTREEID.setForeignKey(APPINFOTREE);
		MTTableAPPINFOTREE.APPINFOID.setForeignKey(APPINFO);
		MTTableDATAGRIDSETTING.INPUTUSERGROUPID.setForeignKey(INPUTUSERGROUP);
		MTTableDATAGRIDSETTING.INPUTUSERID.setForeignKey(INPUTUSER);
		MTTableDATAGRIDSETTING.INPUTSOURCEID.setForeignKey(INPUTSOURCE);

		MTTableBOOK.TITLE.overrideLabel("SHORTLABEL","en_EN","the Title"); 
	}
} 

