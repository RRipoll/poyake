create view acc.VAccountBalance as 
select a.customerId, sum(amount) as balance from acc.Ledger l  join acc.Annotation a on a.annotationId =l.annotationId group by a.customerId 
