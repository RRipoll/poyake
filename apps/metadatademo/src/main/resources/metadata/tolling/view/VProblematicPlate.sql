create view tolling.VProblematicPlate as 
select 
	pp.problematicPlateId
	,lp.licencePlateJurisdictionId
	,lp.lpnumber
	,cv.customerId
	,pp.problematicPlateReasonId
	,pp.notes
from 
	tolling.ProblematicPlate pp 
	join tolling.LicensePlate  lp on pp.licensePlateId=lp.licensePlateId
	join tolling.VehicleInfo vi on vi.licensePlateId=lp.licensePlateId
	join tolling.customerVehicle cv on vi.vehicleId=cv.vehicleId
	
	
