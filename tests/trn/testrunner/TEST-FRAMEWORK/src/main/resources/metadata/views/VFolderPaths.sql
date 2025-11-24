CREATE  VIEW pub.FOLDERPATHS AS 
  select 
  f.parentfolderid
  ,f.FolderId
  , f.description
  ,f.deleted
  ,pub.GetFolderPath(f.folderId) as FolderPath 
  from pub.folder f


