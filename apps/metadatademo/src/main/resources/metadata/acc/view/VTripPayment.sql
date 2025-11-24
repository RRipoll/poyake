create view acc.VTripPayment as 
select
	t.tripId
	,p.paymentId
	,p.amount paymentAmount
	,a.amount allocatedAmount
	,p.postingDate 
from 
	acc.Allocation a
	join acc.VCurrentLedger l on a.creditRevisionId =l.revisionId
	join payment.Payment p on p.ledgerInfoId =l.ledgerInfoId 
	join acc.VCurrentLedger lTrip on lTrip.revisionId=a.debitRevisionId 
	join tolling.Trip t on t.ledgerItemId =lTrip.ledgerItemId
