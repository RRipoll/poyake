package com.etantolling.testrunner.test.zkweb.datagrid3.filter.items;

import org.apache.commons.lang3.StringUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Textbox;

import java.text.MessageFormat;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CustomerIdExtended extends Textbox implements IFilter,EventListener<Event> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String outputFullFormat = "{0,number,00}-{1,number,0000000000}";
	private String outputPartialFormat = "{0,number,0000000000}";
	private static Pattern inputFullFormat = Pattern.compile("(\\d{2})-?(\\d{10})");
	private static Pattern inputPartialFormat = Pattern.compile("\\d{1,10}");

	public Integer getCustomerId(){
		String val = super.getValue();
		return getCustomerId(val,this);
		
	}
	
	 static public  Integer getCustomerId(String val,Component comp){
		
		Matcher matcher = inputFullFormat.matcher(val);
		if(matcher.matches()){
			return Integer.valueOf(matcher.group(2));
		}

		matcher = inputPartialFormat.matcher(val);
		if(matcher.matches()){
			if(Long.valueOf(val).compareTo(new Integer(Integer.MAX_VALUE).longValue()) > 0){
				throw new WrongValueException(comp,"The Account # maximum size is " + Integer.MAX_VALUE);
			}
			return Integer.valueOf(val);
		}

		if(val != null && val.length() > 0){
			throw new  WrongValueException(comp,"The Account # should be in the following formats: ##-########## or ##########");
		}

		return null;
	}

	public CustomerIdExtended() {
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
			throw new WrongValueException(this,"The Account # should be in the following formats: ##-##########, ############ or ##########");
		}

		return null;
	}
	
	
	

	public void setValue(Integer accountId, Integer customerId) throws WrongValueException {
		super.setValue(MessageFormat.format(accountId != null ? outputFullFormat : outputPartialFormat, accountId, customerId));
	}

	@Override
	public String buildWhereClause(String componentId, Hashtable<String, Object> parameters) {
		if(StringUtils.isEmpty(this.getValue()))
			return "";

		Integer customerId = getCustomerId();
		if(null==customerId)
			throw new WrongValueException(this,"A valid value is required");

		String retValue="";

		String fieldName= (String) this.getAttribute("field");

		retValue+=" and  "+  fieldName+ "=   "+ customerId +" ";

		Integer accountTypeId = getAccountTypeId();

        fieldName= (String) this.getAttribute("accountTyleField");
        if(fieldName != null && accountTypeId != null){
			retValue+=" and  "+  fieldName+ "=   "+ accountTypeId +" ";
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
        if(getAccountTypeId() == null) return MessageFormat.format(outputPartialFormat, getCustomerId());
        else return MessageFormat.format(outputFullFormat , getAccountTypeId(), getCustomerId());
    }

	@Override
	public void onEvent(Event event) throws Exception {
		getCustomerId();
		
	}
	
}
