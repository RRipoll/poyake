create view crm.VCustomerSearch as
select 
	c.customerId
	,c.customerTypeId
	,coalesce(p.firstName || ' ','') || p.lastNameOrCompanyName as fullName
	,a.address1 || ' ' || coalesce(' ' || a.address2,'') || ' ' || a.city as mailingAddress
	,p.firstName
	,p.lastNameOrCompanyName
	,pn.number 
	,e.address
	,(
		select url 
		from common.StorageFile sf 
		join common.FileGroup fg on fg.fileGroupId=sf.fileGroupId
		join inv.InvoiceDocument id on id.filegroupid=fg.fileGroupId
		join inv.Invoice i on i.invoiceId=id.invoiceId and i.customerId=c.customerId
		order by i.created desc limit 1
	) lastInvoice
	,(
		select invoiceid from inv.invoice i
		where  i.customerId=c.customerId
		order by i.created desc limit 1
	) lastInvoiceId
from 
	crm.HCustomer c 
	join crm.HPersonOrCompany  p on p.personOrCompanyId=c.mainContactPersonOrCompanyId and current_timestamp >=p.startDate and p.endDate>current_timestamp and current_timestamp>=c.startDate and c.endDate>current_timestamp 
	left join crm.HPostalAddress a on a.postalAddressId=c.mailingPostalAddressId and current_timestamp>=a.startDate and a.endDate>current_timestamp
	left join crm.HPhoneNumber pn on pn.phoneNumberId = p.phoneNumberId 
	left join crm.HEmailAddress e on e.emailAddressId =p.emailAddressId 
	
	 