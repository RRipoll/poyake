create view acc.VCurrentLedger as
select 
	l.revisionId
	,l.ledgerItemId 
	,l.ledgerInfoId 
	,l.transactionTypeId 
	,l.ledgerTypeId 
	,l.annotationId 
	,l.amount 
	,l.balance 
from 
	acc.Ledger l
where
	l.ledgerTypeId in (1,2)
	and l.revisionId not in (select revisionId from acc.Cancellation c )
