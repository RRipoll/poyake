CREATE  VIEW testrunner.TestTree AS
SELECT
    t.*,
    testrunner.GETFOLDERPATH(f.FOLDERUuid) AS FOLDERPATH
FROM testrunner.test t  
left join  testrunner.folder f on t.testUuid=f.testUuid; 

