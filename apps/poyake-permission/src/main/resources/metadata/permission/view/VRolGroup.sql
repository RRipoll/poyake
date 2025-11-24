create view audit.VrolGroup as
select 
r.* 
,'' userGroups
from 
permission.rol r