create view audit.VinputUserMulti as
select 
iu.* ,
'' as usergroups
from 
audit.InputUser iu