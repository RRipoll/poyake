package com.etantolling.testrunner.test.zkweb.datagrid3.filter.items;

import java.text.MessageFormat;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Textbox;


public class TransponderSerialNumberExtended extends Textbox implements IFilter,EventListener<Event> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String outputFullFormat = "{0,number,000}-{1,number,00000000}";
	private String outputPartialFormat = "{0,number,00000000}";
	private Pattern inputFullFormat = Pattern.compile("(\\d{3})-?(\\d{8})");
	private Pattern inputPartialFormat = Pattern.compile("\\d{1,8}");

	public String getTransponderNumber(){
		String val = super.getValue();

		Matcher matcher = inputFullFormat.matcher(val);
		if(matcher.matches()){
			return matcher.group(2);
		}

		matcher = inputPartialFormat.matcher(val);
		if(matcher.matches()){
			if(Long.valueOf(val).compareTo(new Integer(Integer.MAX_VALUE).longValue()) > 0){
				throw new WrongValueException(this,"The Transponder # maximum size is " + Integer.MAX_VALUE);
			}
			return val;
		}

		if(val != null && val.length() > 0){
			throw new  WrongValueException(this,"The Transponder # should be in the following formats: ###-##########, ########### or ########");
		}

		return null;
	}

	public TransponderSerialNumberExtended() {
		super();
		this.addEventListener(Events.ON_BLUR, this);
	}

	public Integer getAccountTypeId(){
		String val = super.getValue();

		Matcher matcher = inputFullFormat.matcher(val);
		if(matcher.matches()){
			return Integer.valueOf(matcher.group(1));
		}

		if(val != null && val.contains("-")){
			throw new WrongValueException(this,"The Transponder # should be in the following formats: ###-##########, ########### or ########");
		}

		return null;
	}

	public void setValue(Integer accountId, Integer transponderNumber) throws WrongValueException {
		super.setValue(MessageFormat.format(accountId != null ? outputFullFormat : outputPartialFormat, accountId, transponderNumber));
	}

	@Override
	public String buildWhereClause(String componentId, Hashtable<String, Object> parameters) {
		if(StringUtils.isEmpty(this.getValue()))
			return "";

		String transponderNumber = getTransponderNumber();
		if(null==transponderNumber)
			throw new WrongValueException(this,"A valid value is required");

		String retValue="";

		String fieldName= (String) this.getAttribute("field");
		String whereAttribute = (String)this.getAttribute("where");
		if(whereAttribute.trim().equalsIgnoreCase("ge")) whereAttribute = " >= ";
		if(whereAttribute.trim().equalsIgnoreCase("le")) whereAttribute = " <= ";
        if(whereAttribute.equalsIgnoreCase("in")){
        	retValue+=" and  "+  fieldName+" in(select tma.customerId from tagdevice td join tagaccount ta on td.tagDeviceId=ta.tagDeviceId and ta.endDate='01-jan-2099' join TransitModeAccount tma on tma.accountId=ta.accountid and transitModeId=1 and td.serialnumber ='"+transponderNumber+"') ";
        }else{
		  retValue+=" and  "+  fieldName+ whereAttribute+"'"+ transponderNumber +"' ";
        }

		return retValue;
	}

	@Override
	public void setSelectedValue(Object selectedValue) {
	;
		
	}

	public boolean isValidCustomer(){
		String val = super.getValue();
		return inputFullFormat.matcher(val).matches() || inputPartialFormat.matcher(val).matches();
	}

    public String getFormatedValue(){
        if(getAccountTypeId() == null) return MessageFormat.format(outputPartialFormat, getTransponderNumber());
        else return MessageFormat.format(outputFullFormat , getAccountTypeId(), getTransponderNumber());
    }

	@Override
	public void onEvent(Event event) throws Exception {
		getTransponderNumber();
		
	}
	
}
