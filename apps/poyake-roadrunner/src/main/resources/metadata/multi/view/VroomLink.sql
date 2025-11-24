create view multi.VroomLink as
select 
rl.*,
enu.shortCode,
enu.description
from 
multi.roomLink rl
join multi.enuRoomType enu on rl.roomTypeId=enu.roomTypeId