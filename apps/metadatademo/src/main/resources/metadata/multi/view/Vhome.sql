create view multi.Vhome as
select 
h.* ,
(select json_agg(row_to_json(rl)) from multi.VroomLink rl where rl.homeId=h.homeId) as rooms
from 
multi.home h
