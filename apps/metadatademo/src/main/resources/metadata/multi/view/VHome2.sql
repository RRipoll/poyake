create view multi.Vhome2 as
select 
h.* ,
(select json_agg(row_to_json(rl)) from multi.roomLink rl where rl.homeId=h.homeId) as  room2s
from 
multi.home h