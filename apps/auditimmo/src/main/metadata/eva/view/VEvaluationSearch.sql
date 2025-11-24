create view eva.VEvaluationSearch as 
select 
	e.evaluationId
	,e.folderId
	,e.evaluationStatusId
	,cApplicant.firstName + ' ' + cApplicant.lastName as applicant
	,cEvaluator.firstName + ' ' + cEvaluator.lastName as evaluator
	,e.startDate 
	,p.city 
	,e.endDate 
from 
eva.Evaluation e 
join eva.Intervenant intEvaluator on intEvaluator.intervenantId =e.evaluatorId 
join eva.Intervenant intApplicant on intApplicant.intervenantId =e.applicantId 
join crm.Contact  cEvaluator on cEvaluator.contactId =intEvaluator .contactId 
join crm.Contact  cApplicant on cApplicant.contactId =intApplicant .contactId 
join eva.Folder  f on f.folderId = e.folderId 
join crm.PostalAddress  p on f.postalAddressId =p.postalAddressId 