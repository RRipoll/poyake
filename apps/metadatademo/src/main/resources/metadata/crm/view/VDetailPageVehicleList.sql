create view crm.VDetailPageVehicleList as
select 
	v.vehicleId
	,lp.lpNumber
	,lp.licencePlateJurisdictionId 
	,licensePlateTypeId
	,v.vehicleClassId 
	,cv.customerId
from 
	tolling.licensePlate lp
	join tolling.VehicleInfo  v on v.licensePlateId =lp.licensePlateId 
	join tolling.CustomerVehicle cv on cv.vehicleId=v.vehicleId