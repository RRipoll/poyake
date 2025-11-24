create view audit.VuserGroup as
select 
ug.* 
,iu.loginname
,iu.fullName
,eiug.shortCode groupName 
,eiug.description groupDescription
from 
audit.UserGroup ug
join audit.InputUser iu on ug.userId=iu.inputUserId
join audit.InputUserGroup eiug on eiug.inputUserGroupId=ug.inputUserGroupId