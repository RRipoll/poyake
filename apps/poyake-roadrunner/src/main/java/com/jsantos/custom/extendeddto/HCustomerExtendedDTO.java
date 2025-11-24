package com.jsantos.custom.extendeddto;

import com.jsantos.metadata.crm.HCustomerDTO;

public class HCustomerExtendedDTO extends HCustomerDTO{

	@Override
	public HCustomerDTO insert() {
		System.out.println("INserting a customer with the3 extended version");
		return super.insert();
	}
	
}
