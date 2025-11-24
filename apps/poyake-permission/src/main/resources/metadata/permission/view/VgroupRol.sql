create view permission.VgroupRol as
select 
ug.* 
,''rols
from 
audit.InputUserGroup ug

