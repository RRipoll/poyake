create view crm.VDetailPageCaseList as 
SELECT 
	c.csCaseId
	,c.subject
	,c.caseTypeId
	,c.caseStatusId
	,c.casePriorityId
	,c.manualReviewRequired
	,cu.customerId 
from 
	cs.cscase c
	join cs.CustomerCase cc on cc.csCaseId=c.csCaseId 
	join crm.HCustomer  cu on cc.customerId=cc.customerId
	
	