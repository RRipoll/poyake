package com.jsantos.custom.extendeddto;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jayway.jsonpath.JsonPath;
import com.jsantos.common.util.ListValues;
import com.jsantos.metadata.testrunner.StoreValuesEventDTO;
import com.jsantos.metadata.testrunner.StoreValuesTestDTO;

public class StoreValuesTestExtDTO extends StoreValuesTestDTO{

	public StoreValuesTestExtDTO(){
		super();
		ListValues<StoreValuesEventDTO> values= new ListValues<StoreValuesEventDTO>();
		this.setStoreValuesEvents(values);
	}
	
	 public void addStoreValuesEvent(StoreValuesEventDTO storevalue) {
		 ((ListValues<StoreValuesEventDTO>)this.getStoreValuesEvents()).add(storevalue);
	 }
	 
	 
		public String findValue(String path) {
			if(null!=path) {
				ListValues<StoreValuesEventDTO> values=((ListValues<StoreValuesEventDTO>)this.getStoreValuesEvents());
				
				for (int i = values.size(); i > 0; i--) {
					StoreValuesEventDTO value=values.get(i-1);
					try {
						Object result=JsonPath.read(value.getData(), path);
						if(null!=result) return result.toString();
					} catch (Exception e) {
					//	e.printStackTrace();
					}
				}
			}
			return null;
		}
		
		public String replacePathValues(String json) throws ParseException {
			
			//(["]@.[^"]*["])*
			final String regex1 ="\\$.[^\"\\]\\}?,:]*";//"\\$.[\\S]*";// "([\"]@.[^\"]*[\"])*";
			final Pattern pattern1 = Pattern.compile(regex1);

			if (null != json) {
				boolean goaway=true;
				//while(goaway) {
					Matcher matcher = pattern1.matcher(json);
						int count = 0;
				        while(matcher.find()) {
								String label = matcher.group(0);
								String result=findValue(label);
								if(null!=result) {
									json=json.replace("{"+label+"}",result );
									json=json.replace(label,result );
								}
//					}else goaway=false;
				}
			}
			return json;
		}
	 
}
