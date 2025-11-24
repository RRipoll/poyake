create view multi.VHomeLink as
select 
rl.*,
h.name
from 
multi.homeLink rl
join multi.home h on rl.homeId=h.homeId