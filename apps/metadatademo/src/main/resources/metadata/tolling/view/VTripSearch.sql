create view tolling.VTripSearch as 
select 
	tripId 
	,fareAmount 
	,laneEntryDate 
	,laneExitDate
	,lp.licencePlateJurisdictionId 
	,lp.lpnumber 
	,lp.licensePlatetypeId 
	,passId
from 
	tolling.TripInfo ti 
	join tolling.LicensePlate lp on lp.licensePlateId =ti.licensePlateId 