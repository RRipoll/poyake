create view audit.VUserMultiGroup as
select 
iu.* 
,'' userGroups
from 
audit.InputUser iu
