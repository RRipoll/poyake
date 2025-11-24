create view VFullCustomerInfo as
Select 
c.*
,a.street as theStreet
,a.city
,a.zipCode
,'PEPOTE' pepoteColumn
,dbo.F_timesTen(c.customerId) as twenty
from 
	crm.Customer c
	left join crm.Address a on c.customerId=a.customerId 
