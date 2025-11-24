create view eva.VFolderSearch as 
select 
	f.folderId 
	,f.created 
	,f.folderName 
	,contApplicant.firstName + ' ' + contApplicant.lastName applicant
	,contEvaluator.firstName + ' ' + contEvaluator.lastName  evaluator
	,a.address1 
	,a.city 
from 
eva.Folder f 
join eva.Building b on f.buildingId =b.buildingId 
join crm.PostalAddress a on f.postalAddressId =a.postalAddressId 
left join
	(
	select 
		f.folderId 
		,max(e.evaluationId) evaluationId
	FROM 
		eva.Evaluation e 
		join eva.Folder f on f.folderId =e.folderId
	group by
		f.folderId 
)X on X.folderId=f.folderId
left join eva.Evaluation e on e.evaluationId=X.evaluationId
left join eva.Intervenant intEvaluator on intEvaluator.intervenantId =e.evaluatorId
left join crm.Contact contEvaluator on contEvaluator.contactId =intEvaluator.contactId 
left join eva.Intervenant intApplicant on intApplicant.intervenantId =e.applicantId
left join crm.Contact contApplicant on contApplicant.contactId =intApplicant.contactId 
		