package com.jsantos.ledger;

import java.math.BigDecimal;

import org.springframework.jdbc.core.JdbcTemplate;

import com.jsantos.metadata.acc.AnnotationDTO;
import com.jsantos.metadata.acc.EnuAnnotationType;
import com.jsantos.metadata.acc.EnuLedgerType;
import com.jsantos.metadata.acc.EnuTransactionType;
import com.jsantos.metadata.acc.LedgerDTO;
import com.jsantos.metadata.acc.LedgerInfoDTO;
import com.jsantos.metadata.acc.LedgerItemDTO;
import com.jsantos.metadata.payment.PaymentDTO;
import com.jsantos.orm.MainDb;

public class LedgerInterface {

	public static LedgerDTO addDebit(Integer customerId, Integer transactionTypeId, BigDecimal amount) {
		amount = amount.abs();
		amount = amount.negate();
		LedgerInfoDTO ledgerInfo = new LedgerInfoDTO().insert();
		LedgerItemDTO ledgerItem = new LedgerItemDTO().insert();
		AnnotationDTO annotation = new AnnotationDTO();
		annotation.setCustomerId(customerId);
		annotation.setAnnotationTypeId(EnuAnnotationType.NEWDEBIT);
		annotation.insert();
		LedgerDTO ledger = new LedgerDTO();
		ledger.setAmount(amount);
		ledger.setAnnotationId((Integer)annotation.getPk());
		ledger.setLedgerInfoId((Integer)ledgerInfo.getPk());
		ledger.setLedgerItemId((Integer)ledgerItem.getPk());
		ledger.setLedgerTypeId(EnuLedgerType.DEBIT);
		ledger.setTransactionTypeId(transactionTypeId);
		ledger.setBalance(getBalance(customerId).add(amount));
		ledger.insert();
		AllocationsInterface.allocateAvailableMoneyToNewDebit(ledger, customerId, annotation);
		return ledger;
		
	}
	
	public static BigDecimal getBalance(Integer customerId) {
		String sql = "select sum(amount) as balance from acc.Ledger l join acc.Annotation ann on ann.annotationId =l.annotationId and customerId =" + customerId;
		BigDecimal balance = new JdbcTemplate(MainDb.getMainDataSource()).queryForObject(sql, BigDecimal.class);
		if (null == balance) return BigDecimal.ZERO;
		return balance;
	}
	
	
	public static LedgerDTO addCredit(Integer customerId, Integer transactionTypeId, BigDecimal amount) {
		amount = amount.abs();
		LedgerInfoDTO ledgerInfo = new LedgerInfoDTO().insert();
		LedgerItemDTO ledgerItem = new LedgerItemDTO().insert();
		AnnotationDTO annotation = new AnnotationDTO();
		annotation.setCustomerId(customerId);
		annotation.setAnnotationTypeId(EnuAnnotationType.NEWCREDIT);
		annotation.insert();
		LedgerDTO ledger = new LedgerDTO();
		ledger.setAmount(amount);
		ledger.setAnnotationId((Integer)annotation.getPk());
		ledger.setLedgerInfoId((Integer)ledgerInfo.getPk());
		ledger.setLedgerItemId((Integer)ledgerItem.getPk());
		ledger.setLedgerTypeId(EnuLedgerType.CREDIT);
		ledger.setTransactionTypeId(transactionTypeId);
		ledger.setBalance(getBalance(customerId).add(amount));
		ledger.insert();
		return ledger;
	}
	
	public static void insertPayment(Integer customerId, PaymentDTO payment) {
		LedgerDTO ledger = addCredit(customerId, EnuTransactionType.PAYMENT, payment.getAmount());
		payment.setLedgerInfoId(ledger.getLedgerInfoId());
		payment.insert();
	}
}
