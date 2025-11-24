create view permission.VRolLink as
select 
rp.*,
r.shortCode,
r.description,
'' as userGroups
from 
permission.RolPermission rp
join permission.Rol r on rp.rolId=r.rolId