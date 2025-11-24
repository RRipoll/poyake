create view acc.VTransactionHistory as
select
	ann.postingDate 
	,l.ledgerItemId
	,l.transactionTypeId
	,l.amount
	,l.balance
	,t.tripId
	,p.paymentId 
	,ann.customerId 
from 
	acc.Ledger l 
	join acc.Annotation ann on ann.annotationId =l.annotationId 
	left join tolling.Trip t on t.ledgerItemId=l.ledgerItemId
	left join payment.Payment p on p.ledgerInfoId=l.ledgerInfoId
