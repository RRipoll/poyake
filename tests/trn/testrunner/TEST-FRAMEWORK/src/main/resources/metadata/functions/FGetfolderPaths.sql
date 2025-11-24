
CREATE FUNCTION pub.GetFolderPath ( @pCurrentNodeID    INT )
RETURNS VARCHAR(1000)
AS
BEGIN

DECLARE @vCurrentNodeName     VARCHAR(50)
DECLARE @vParentID            INT

IF @pCurrentNodeID IS NULL OR @pCurrentNodeID = 0
    RETURN NULL

SELECT @vCurrentNodeName = [DESCRIPTION], @vParentID = [PARENTFOLDERID]
FROM [FOLDER]
WHERE [FOLDERID] = @pCurrentNodeID

RETURN ISNULL(pub.GetFolderPath ( @vParentID ) + '/', '') + @vCurrentNodeName

END