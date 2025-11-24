create view crm.VCustomerHistory as
select 
	thisRecord.startDate
	,'Phone Number' as objectType
	, case 
		when prevRecord.revisionId  is null then 'Created'
		when nextRecord.revisionId is null  and thisRecord.endDate<CURRENT_TIMESTAMP then 'Deleted'
		else 'Modified'
	 end as action
	,thisRecord.inputUserId 
	,thisRecord.phoneNumberId as id
	,thisRecord.revisionId
	,prevRecord.revisionId as prevRevisionId
	,'HPHONENUMBER' mtTable
	,c.customerId 
FROM 
	crm.HPhoneNumber thisRecord
	join crm.HPersonOrCompany p on p.phoneNumberId =thisRecord.phoneNumberId 
	join crm.HCustomer c on c.mainContactPersonOrCompanyId =p.personOrCompanyId 
	left join crm.HPhoneNumber prevRecord on prevRecord.endDate =thisRecord.startDate 
	left join crm.HPhoneNumber  nextRecord on nextRecord.startDate=thisRecord.endDate

union

select 
	thisRecord.startDate
	,'Email Address' as objectType
	, case 
		when prevRecord.revisionId  is null then 'Created'
		when nextRecord.revisionId is null  and thisRecord.endDate<CURRENT_TIMESTAMP then 'Deleted'
		else 'Modified'
	 end as Action
	,thisRecord.inputUserId 
	,thisRecord.emailAddressId as id
	,thisRecord.revisionId
	,prevRecord.revisionId as prevRevisionId
	,'HEMAILADDRESS' mtTable
	,c.customerId 
FROM 
	crm.HEmailAddress thisRecord
	join crm.HPersonOrCompany p on p.emailAddressId =thisRecord.emailAddressId 
	join crm.HCustomer c on c.mainContactPersonOrCompanyId =p.personOrCompanyId 
	left join crm.HEmailAddress prevRecord on prevRecord.endDate =thisRecord.startDate 
	left join crm.HEmailAddress  nextRecord on nextRecord.startDate=thisRecord.endDate 
	
union

select 
	thisRecord.startDate
	,'Postal Address' as objectType
	, case 
		when prevRecord.revisionId  is null then 'Created'
		when nextRecord.revisionId is null  and thisRecord.endDate<CURRENT_TIMESTAMP then 'Deleted'
		else 'Modified'
	 end as Action
	,thisRecord.inputUserId 
	,thisRecord.postalAddressId as id
	,thisRecord.revisionId
	,prevRecord.revisionId as prevRevisionId
	,'HPostalAddress' mtTable
	,c.customerId 
FROM 
	crm.HPostalAddress thisRecord
	join crm.HCustomer c on c.mailingPostalAddressId =thisRecord.postalAddressId 
	left join crm.HPostalAddress prevRecord on prevRecord.endDate =thisRecord.startDate 
	left join crm.HPostalAddress  nextRecord on nextRecord.startDate=thisRecord.endDate 
