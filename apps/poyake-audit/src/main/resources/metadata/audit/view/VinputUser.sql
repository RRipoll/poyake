create view audit.VinputUser as
select 
iu.* 
,ug.inputUserGroupId
from 
audit.InputUser iu
join audit.UserGroup ug on ug.userId=iu.inputUserId
