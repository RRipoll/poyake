create view tolling.VFindVehicle as 
select 
	vi.vehicleId
	,j.shortCode
	,lp.lpnumber
	,vi.make 
	,vi.model 
	,vi.modelYear 
	,vi.color 
	,vi.axles 
	,vi.vehicleClassId 
	,cv.customerId
	,lp.licensePlateId
	
from 
	tolling.VehicleInfo vi
	join tolling.LicensePlate lp on vi.licensePlateId =lp.licensePlateId
	join tolling.EnuLicensePlateJurisdiction j on j.licensePlateJurisdictionId =lp.licencePlateJurisdictionId 
	join tolling.CustomerVehicle cv on cv.vehicleId=vi.vehicleId 
