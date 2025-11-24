create view acc.VUnallocatedCredit as 
select
	revisionId
	,fullAmount-allocated as unAllocated
	,fullAmount
	,ledgerItemId
	,customerId
from (
	select 
		l.revisionId
		,coalesce((select sum(abs(amount)) from acc.allocation where creditRevisionId =l.revisionId and endAnnotationId is null),0) as allocated
		,amount as fullAmount
		,l.ledgerItemId
		,ann.customerId 
	from 
		acc.ledger l 
		join acc.Annotation ann on l.annotationId =ann.annotationId 
	where 
		l.ledgerTypeId in (2,6)
		and not exists (select 1 from acc.Cancellation where cancelledRevisionId =l.revisionId) 
	) X where fullAmount>allocated