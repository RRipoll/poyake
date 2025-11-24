create view permission.Vpermission as
select 
ug.inputuserId,
iug.inputUserGroupId,
ugr.rolId,
ep.permissionTypeId,
ep.permissionValueId,
ep.shortCode,
ep.description,
ep.permissionId
from 
audit.usergroup ug 
join audit.InputUserGroup iug on iug.inputUserGroupId=ug.inputUserGroupId
join permission.UserGroupRol ugr on ugr.inputUserGroupId=ug.inputUserGroupId
join permission.RolPermission rp on rp.rolId=ugr.rolId
join permission.Permission ep on ep.permissionId=rp.permissionId
join permission.EnuPermissionType ept on ept.permissionTypeId=ep.permissionTypeId
join permission.EnuPermissionValue epv on epv.permissionValueId=epv.permissionValueId

