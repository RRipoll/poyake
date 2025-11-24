


--//POSGRESSQL
--create view multi.Vhome2 as
--select 
--h.* ,
--(select json_agg(row_to_json(rl)) from multi.roomLink rl where rl.homeId=h.homeId) as  room2s
--from 
--multi.home h


--//SQLSERVER
--create view multi.Vhome as
--select 
--h.* ,
--(select * from multi.roomLink rl where rl.homeId=h.homeId for json  Path) as  room2s
--from 
--multi.home h

--//H2
create view multi.Vhome2 as
select 
h.* ,
--(select json_agg(row_to_json(rl)) from multi.roomLink rl where rl.homeId=h.homeId) 
'' as  room2s
from 
multi.home h

