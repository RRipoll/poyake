--//POSGRESSQL
--create view multi.VStreet as
--select 
--s.*
--,(select json_agg(row_to_json(rl)) from multi.VhomeLink rl where rl.streetId=s.streetId) as homes
--from 
--multi.street s

--//SQLSERVER
--create view multi.VStreet as
--select 
--s.* ,
--(select * from multi.VhomeLink rl where rl.streetId=s.streetId for json  Path
--) as homes
--from 
--multi.street s

--//H2
create view multi.VStreet as
select 
s.* ,
--(select * from multi.VhomeLink rl where rl.streetId=s.streetId for json  Path) 
'' as homes
from 
multi.street s
