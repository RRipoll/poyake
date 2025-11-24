create or alter view cfg.VCurrentConfigValues 
as 
	select
		configKeyId
		,fullPath
		,value
	from (
			select 
				k.configKeyId,
				k.fullPath, 
				iif(v.value is null, k.defaultValue, v.value) as value
			from 
				cfg.configKey k 
				left join cfg.ConfigValue v on v.configKeyId=k.configKeyId 
					and v.startDate <=getDate() and v.endDate >getDate() 
			where 
				k.configKeyTypeId = (select configKeyTypeId from cfg.EnuConfigKeyType where shortCode ='SINGLEVALUE')
				
		UNION 
			select 
				k.configKeyId,
				k.fullPath, 
				iif(X.maxRevisionId is null, k.defaultValue, (select value from cfg.ConfigValue where revisionId=X.maxRevisionId)) as value
			from 
				cfg.configKey k
				left join (
					select 
						max(revisionId) maxRevisionId
						,configKeyId
					from 
						cfg.ConfigValue v 
					where 
						v.startDate <=getDate() and v.endDate >getDate() 
					group BY 
						configKeyId
				) X on X.configKeyId = k.configKeyId 
			where 
				k.configKeyTypeId = (select configKeyTypeId from cfg.EnuConfigKeyType where shortCode ='VALUEWITHTIME')
	) X			
			
