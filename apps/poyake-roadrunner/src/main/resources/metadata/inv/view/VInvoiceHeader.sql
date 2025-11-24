create view inv.VinvoiceHeader as 
select 
coalesce(p.firstName || ' ', '') || p.lastNameOrCompanyName as recipientName
,a.address1
,a.address2
,a.city
,a.postalCode
,esp.shortCode state
,i.created noticeDate
,i.created dueDate
,i.customerId 
,i.invoiceId 
,lp.lpnumber
,id.amountDue totalDue
from inv.Invoice i 
JOIN inv.InvoiceDocument id on id.invoiceId=i.invoiceId
--left join common.storageFile fg on fg.filegroupid=id.fileGroupId 
left join crm.HCustomer c on i.customerId=c.customerId
	left join crm.HPersonOrCompany  p on p.personOrCompanyId=c.mainContactPersonOrCompanyId and current_timestamp>=p.startDate and p.endDate>current_timestamp and current_timestamp>=c.startDate and c.endDate>current_timestamp 
	left join crm.HPostalAddress a on a.postalAddressId=c.mailingPostalAddressId and current_timestamp>=a.startDate and a.endDate>current_timestamp
	left join crm.HPhoneNumber pn on pn.phoneNumberId = p.phoneNumberId 
	left join crm.HEmailAddress e on e.emailAddressId =p.emailAddressId 
	left join crm.EnuStateProvince esp on esp.stateProvinceId=a.stateProvinceId
	left join tolling.CustomerVehicle cv on cv.customerId=i.customerId
	left join tolling.VehicleInfo vi on cv.vehicleId=vi.vehicleId
	left join tolling.LicensePlate lp on vi.licensePlateId =lp.licensePlateId
