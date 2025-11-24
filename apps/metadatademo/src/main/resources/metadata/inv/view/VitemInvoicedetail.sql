create view inv.VitemInvoiceDetail as
select 
	laneExitDate
	,t.tripId
	,ti.passId
	,lp.lpnumber 
	,ti.fareAmount 
	,cv.customerId
	,iit.invoiceId
from 
	inv.InvoiceLedgerItem iit
	join tolling.Trip t on iit.ledgerItemId=t.ledgerItemId
	join tolling.TripInfo ti on ti.tripid=t.tripid
	join tolling.LicensePlate lp on lp.licensePlateId =ti.licensePlateId 
	left join tolling.VehicleInfo vi on vi.licensePlateId=ti.licensePlateId 
	left join tolling.CustomerVehicle cv on cv.vehicleId=vi.vehicleId
