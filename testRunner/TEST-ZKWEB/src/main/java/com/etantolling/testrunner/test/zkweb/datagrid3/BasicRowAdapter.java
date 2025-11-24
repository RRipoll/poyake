package com.etantolling.testrunner.test.zkweb.datagrid3;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.LinkedHashMap;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Detail;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Html;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.impl.InputElement;

import com.etantolling.testrunner.test.core.db.DetachedRow;
import com.etantolling.testrunner.test.core.utils.DataFormatter;
import com.etantolling.testrunner.test.zkweb.datagrid3.RenderedObjects.BasicEditableCell;


public class BasicRowAdapter {
	
	//private static final Logger log = LoggerFactory.getLogger(BasicRowAdapter.class);
	
	protected LinkedHashMap<String, Object> row;
	protected DataGridModel dgModel;

	protected LinkedHashMap<LinkedHashMap<String, Object>, LinkedHashMap<String, Component>> linkObjectDiv=new LinkedHashMap<LinkedHashMap<String, Object>, LinkedHashMap<String, Component>>();
	protected LinkedHashMap<LinkedHashMap<String, Object>, DetachedRow> detachedRowMap=new LinkedHashMap<LinkedHashMap<String, Object>, DetachedRow>();
	
	
	
	
	public LinkedHashMap<LinkedHashMap<String, Object>, DetachedRow> getDetachedRowMap() {
		return detachedRowMap;
	}

	public BasicRowAdapter() {
	}

	public void setRow(DataGridModel dgModel, LinkedHashMap<String, Object> row) {
		this.row = row;
		this.dgModel = dgModel;
	}

	public String getRowId() throws SQLException {
		return row.get(row.keySet().toArray()[0])+"";
	}
	public LinkedHashMap<String, Object> getRow() throws SQLException {
		return row;
	}

	public void renderCell(HtmlBasedComponent div, String columnName, EventListener<Event> eventListener) throws SQLException {
		  renderCell( div,  columnName,  eventListener,true);
	}
	
	public void renderCell(HtmlBasedComponent div, String columnName, EventListener<Event> eventListener,boolean isEditable) throws SQLException {
		
		if(linkObjectDiv.containsKey(row)){
			LinkedHashMap<String, Component> r= linkObjectDiv.get(row);
			r.put(columnName, div);
		}else{
			LinkedHashMap<String, Component> r= new LinkedHashMap<String, Component>();
			r.put(columnName, div);
			linkObjectDiv.put(row, r);
		}
		
		div.setSclass("fieldValue");
		
		String css="text-weight:bold;padding:0px 0px 0px 4px;vertical-align:middle;";
		String alignCss="float:left;";
		
		if(null!=dgModel.getColumnAlign().get(columnName)){
			String align=dgModel.getColumnAlign().get(columnName);
			css+="float:"+align+";";
		}else {css+=alignCss;}
		
		if(dgModel.getColumnDetail().size()>0 && !(div instanceof Detail)){
			css+="background-color:#cee2ef;";
		}
		
		div.setStyle(css);
		
		if (!dgModel.dgQuery.columnNames.contains(columnName)){
			throw new RuntimeException("Column name '" + columnName + "' does not exist in query ");
		}
		
		if(isEditable && dgModel.getColumnEditable().containsKey(columnName)){
			Component comp=formatEditor(row.get(columnName),dgModel.getColumnFormat().get(columnName));
			BasicEditableCell cell= new BasicEditableCell(columnName,row,detachedRowMap,div,(InputElement) comp);
			comp.setParent(div);
		}else {
			String value=DataFormatter.formatValue(row.get(columnName),dgModel.getColumnFormat().get(columnName));
			if(detachedRowMap.containsKey(row)){
				if(detachedRowMap.get(row).getUpdates().containsKey(columnName)){
					Object editValue=detachedRowMap.get(row).getUpdates().get(columnName);
					String newValue=DataFormatter.formatValue(editValue,dgModel.getColumnFormat().get(columnName));
					value=""+newValue+""+"{"+value+"}";
				}
			}
			Html html = new Html(value);
			html.setParent(div);
		}
	}

	static public Component formatEditor(Object theValue, String dataType) {
		
		if (null != theValue) {
			if(null!=dataType){
				if(dataType.equals("phone")){
					;//return MiscUtility.formatUSPhoneNumber((String) theValue);
				}else if(dataType.equals("date")  || dataType.equals("time") || dataType.equals("datetime") ){
                    Component comp= new Datebox((Date) theValue);
					return comp;
					//return formatDate(theValue, dataType);
				}else if(dataType.equals("currency") && (theValue instanceof BigDecimal || theValue instanceof Integer  || theValue instanceof Long )){
                    Component comp= new Decimalbox(new BigDecimal(theValue.toString()));
					return comp;
					//return NumberFormat.getCurrencyInstance(Locale.US).format(theValue);
				}else if(dataType.equals("string")){
					Component comp= new Textbox(theValue.toString());
					return comp;
					//return theValue.toString();
					}
			
			}else if (theValue instanceof BigDecimal) { // by default we only display two decimal digits
                Component comp= new Decimalbox(new BigDecimal(theValue.toString()));
				return comp;
				
				//BigDecimal bigDecimal = ((BigDecimal) theValue).setScale(2, BigDecimal.ROUND_DOWN);
				//return bigDecimal.toString();
			}else if (theValue instanceof Integer) {
                Component comp= new Intbox((Integer)theValue);
				return comp;
				//BigDecimal bigDecimal = ((BigDecimal) theValue).setScale(2, BigDecimal.ROUND_DOWN);
				//return bigDecimal.toString();
			}
			else if (theValue instanceof Date) {
	                Component comp= new Datebox((Date)theValue);
					return comp;
			}else if (theValue instanceof Time) {
				//Date date= new Date(((Time)theValue).getTime());
				 Component comp= new Datebox((Date)theValue);
					return comp;
				//return dFormatDateTime.format(date);
			}
			else{
				Component comp= new Textbox(theValue.toString());
				return comp;
			}
		}
		return null;
	}

	public void formatTd(int nCol, Hbox hbox) {
	}

	public LinkedHashMap<LinkedHashMap<String, Object>, LinkedHashMap<String, Component>> getLinkObjectDiv() {
		return linkObjectDiv;
	}
	
	public void reset(){
		
	}
}