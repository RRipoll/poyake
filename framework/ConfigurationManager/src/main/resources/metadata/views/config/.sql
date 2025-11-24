create or alter view config.VCurrentConfigValues 
as 
	select 
		k.keyId, 
		iif(v.value is null, k.defaultValue, v.value) as value
	from 
		config.configKey k 
		left join config.ConfigValue v on v.configKeyId=k.configKeyId 
			and k.keyTypeId = (select keyTypeId from config.EnuConfigKeyType where shortCode ='SINGLEVALUE')
			and v.startDate <=getDate() and v.endDate >getDate() 
UNION 
	select 
		k.keyId, 
		iif(v.value is null, k.defaultValue, v.value) as value
	from config.ConfigKey k 
		join config.ConfigValueWithTimePKs pk on pk.configKeyId = k.configKeyId 
			and k.keyTypeId = (select keyTypeId from config.EnuConfigKeyType where shortCode ='VALUEWITHTIME')
		join config.ConfigValueWithTime v on v.ConfigValueWithTimeId = pk.configValueWithTimeId 
			and v.startDate <=getDate() and v.endDate >getDate() and v.effectiveStartDate <= getDate() and v.endDate > getDate()