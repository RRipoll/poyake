package com.jsantos.rest.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsantos.common.util.FileDownload;
import com.jsantos.common.util.MTMapValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.factory.DTOFactory;
import com.jsantos.factory.file.FileFactory;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.MTrecorder;
import com.jsantos.metadata.recorder.RecorderMasterDTO;
import com.jsantos.orm.dbstatement.DetachedQueryResult;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.dbstatement.Sequence;
import com.jsantos.orm.exceptions.ApiException;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTHelper;
import com.jsantos.orm.mt.MTTable;

import nonapi.io.github.classgraph.json.JSONSerializer;

@RestController
@RequestMapping("/rest/api/recorder")
//@Slf4j

public class RecordController {
	
	Integer inputUserGroupId=1;
	//Locale locale=Locale.ENGLISH;
	
	@GetMapping("/set")
	public MapValues<Object> set() throws ApiException {
		RecorderMasterDTO dr= new RecorderMasterDTO(); 
		dr.setSession(UUID.randomUUID().toString());
		dr.insert();
		MapValues<Object> value= new MapValues<Object>();
		value.put("RecorderMasterId",  dr.getPk());
		return value;		
	}
	
	@GetMapping("/get/{uuid}")
	public MapValues<Object> get(@PathVariable Integer uuid) throws Exception {
		
		DetachedQueryResult rsq= new DetachedQueryResult(MTrecorder.RECORDERDATA, " and postingDate >= (select postingDate from recorder.recorderMaster where recordermasterid="+uuid+")");
		rsq.setPageSize(1000);
		ArrayList<MapValues<Object>> resuls=rsq.getPlainPage(0);
		String json=JSONSerializer.serializeObject(resuls);
		
		String fileName="recorder_"+uuid;
		Path path = Paths.get(fileName);
	    byte[] strToBytes = json.getBytes();
	    Files.write(path, strToBytes);
	    
		String urlAzure = FileFactory.getProvider().storeFile(fileName, path.toFile(),inputUserGroupId
				);
		MapValues<Object> returnMapValues= new MapValues<Object>();
		returnMapValues.put("urlFile",urlAzure );
		return returnMapValues;		
	}
	
	@PutMapping("/process-URLfile")
	public MapValues<Object> processURL(@RequestParam String fileURL) throws Exception {
		
		String fileName="recorder.txt";
		FileDownload.downloadUrl(fileURL, fileName);
			return process(new File(fileName));  
			}  
	
	public MapValues<Object> process(@RequestParam File fileURL) throws Exception {
		Integer inserted=0;
		Integer updated=0;
		Integer deleted=0;
		MapValues<Object> retValue= new MapValues<Object>();
		
			{  
			try{  
				JSONArray jsonarray = new JSONArray(FileUtils.readFileToString(fileURL));
				for (int i = 0; i < jsonarray.length(); i++) {
				    JSONObject jsonobject = jsonarray.getJSONObject(i);
				    String tableName = jsonobject.getString("tableName");
				    Integer recorderTypeId = jsonobject.getInt("recorderTypeId");
				    String data = jsonobject.getString("data");
				    
				    ObjectMapper mapper = new ObjectMapper();
				    MapValues<Object> mapValues=mapper.readValue(data, MapValues.class);
				    MTMapValues<Object> mtMapValues= MTHelper.getValues(mapValues, tableName);
				    IDetachedRecord dto=DTOFactory.get(MTBase.getTable(tableName));
				    dto.setValues(mtMapValues);
				    
				    if(recorderTypeId==1) {
				    	MTTable table=dto.getTable();
				    	if(null!=dto.getPk() && null!=table.getPrimaryKey() ) {
				    		for (MTField field : table.getPrimaryKeys()) {
				    			if(null==field.getForeignKey() && field.getDataType().equals(MTDataTypes.INT)   && (null!=field.getSequence() || !field.getSequence().equals("null")))
				    				while (((Integer)Sequence.nextForTable(field.getTable()))<Integer.parseInt(dto.getPk().toString()));
							}
				    	}
				    	dto.insert();
				    	inserted++;
				    }
				    else if(recorderTypeId==2) {
				    	dto.update();
				    	updated++;
				    }
				    else if(recorderTypeId==3) {
				    	dto.delete();
				    	deleted++;
				    }
				}
				retValue.put("inserted",inserted );
				retValue.put("updated", updated);
				retValue.put("deleted",deleted );
				retValue.put("total",deleted+updated+inserted );
				}  
				catch(IOException e)  
					{  
					e.printStackTrace();  
					}  
				}
			return retValue;  
			}  
		
	
}

