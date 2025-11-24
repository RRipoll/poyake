create view payment.VPaymentMethods as 
select 
	pm.paymentMethodId
	,pt.paymentTypeClassId
	,pm.paymentTypeId 
	,case 
		when ptc.shortCode='CREDITCARD' then pm.ccNumber 
		when ptc.shortCode='DIRECTDEBIT' then pm.accountNumber 
		when ptc.shortCode='CHECK' then pm.checkNumber 
		else null
	end as number
	,cpm.customerId 
from 
	payment.PaymentMethod pm 
	join payment.EnuPaymentType pt on pt.paymentTypeId =pm.paymentTypeId 
	join payment.enuPaymentTypeClass ptc on pt.paymentTypeClassId=ptc.paymentTypeClassId
	join crm.customerPaymentMethod cpm on cpm.paymentMethodId=pm.paymentMethodId