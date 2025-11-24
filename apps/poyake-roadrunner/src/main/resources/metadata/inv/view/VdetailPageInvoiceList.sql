create view inv.VdetailPageInvoiceList as
select 
i.invoiceid
, i.created
, id.amountDue
, i.customerId
, fg.location
from inv.Invoice i 
JOIN inv.InvoiceDocument id on id.invoiceId=i.invoiceId
left join common.storageFile fg on fg.filegroupid=id.fileGroupId 
