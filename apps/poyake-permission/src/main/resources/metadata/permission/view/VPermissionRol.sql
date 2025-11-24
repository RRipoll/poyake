create view permission.VPermissionRol as
select 
p.*,
'' as rols
from 
permission.Permission p
