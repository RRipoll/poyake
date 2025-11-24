Select 
c.*
,a.street as theStreet
,a.city
,a.zipCode
,'PEPOTE' pepoteColumn
,getDate() as currentDate
,dbo.F_timesTen(2) as twenty
from 
	crm.Customer c
	left join crm.Address a on c.customerId=a.customerId and c.customerId=a.customerId