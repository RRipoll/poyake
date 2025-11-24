create view inv.VInvoiceableAccount as
select 
	customerId
	,balance
from 
	acc.vaccountBalance ab 
	where 
		balance<0
		and not exists (select invoiceId from inv.Invoice where customerId =ab.customerId and created >getPostingDate()- interval '1 MONTH')
