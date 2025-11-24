 CREATE  VIEW pub.EVENTFOLDERPATHS  AS 
  select 
e.parentfolderid
,e.eventdeffolderId
, e.description
, e.deleted 
,pub.GetEventFolderPath(e.eventdeffolderId) as FolderPath 
from pub.eventdeffolder e