create view eva.VResultCalculation as
select 
	d.evaluationId 
	,d.level
	,s.evaluationSectionTypeId 
from 
	eva.EvaluationSubsectionDetail d
	join eva.EnuEvaluationSubsection ss on d.evaluationSubsectionId =ss.evaluationSubsectionId 
	join eva.EnuEvaluationSection s on s.evaluationSectionId =ss.evaluationSectionId 