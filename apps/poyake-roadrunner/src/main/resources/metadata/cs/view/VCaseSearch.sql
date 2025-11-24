create view cs.VCaseSearch as
select 
	c.csCaseId
	,c.subject
	,c.caseTypeId
	,c.caseStatusId
	,c.casePriorityId
	,c.startDate
	,c.inputUserId
	,c.manualReviewRequired
	,c.documentation
	,'' customers
from 
	cs.CSCase c 
where c.startDate<=getPostingDate() and c.endDate>getPostingDate()
	
