create view eva.VIntervenantSearch as 
select 
	i.intervenantId 
	,c.lastName 
	,c.firstName 
	,c.companyName 
	,c.cellPhone 
	,i.intervenantCategoryId 
	,'Permission' as permission
	,a.city 
	,a.postalCode 
	,i.active
FROM 
eva.Intervenant i 
join crm.Contact  c on i.contactId=c.contactId
join crm.PostalAddress a on c.postalAddressId = a.postalAddressId