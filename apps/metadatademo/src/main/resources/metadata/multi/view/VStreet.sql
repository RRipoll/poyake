create view multi.VStreet as
select 
s.*
,(select json_agg(row_to_json(rl)) from multi.VhomeLink rl where rl.streetId=s.streetId) as homes
from 
multi.street s