
--//POSGRESSQL
--create view multi.Vhome as
--select 
--h.* ,
--(select json_agg(row_to_json(rl)) from multi.VroomLink rl where rl.homeId=h.homeId) as rooms
--from 
--multi.home h


--//SQLSERVER
--create view multi.Vhome as
--select 
--h.* ,
--(select * from multi.VroomLink rl where rl.homeId=h.homeId for json  Path) as rooms
--from 
--multi.home h

--//H2
create view multi.Vhome as
select 
h.* ,
--(select json_agg(row_to_json(rl)) from multi.VroomLink rl where rl.homeId=h.homeId) 
'' as rooms
from 
multi.home h
