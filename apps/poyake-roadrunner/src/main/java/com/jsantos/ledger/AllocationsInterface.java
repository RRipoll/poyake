package com.jsantos.ledger;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;

import com.jsantos.metadata.MTroadRunnerData;
import com.jsantos.metadata.acc.AllocationDTO;
import com.jsantos.metadata.acc.AnnotationDTO;
import com.jsantos.metadata.acc.LedgerDTO;
import com.jsantos.metadata.acc.VUnallocatedCreditDTO;
import com.jsantos.orm.dbstatement.DBQuery;

public class AllocationsInterface {
	
	public static void allocateAvailableMoneyToNewDebit(LedgerDTO debit, Integer customerId, AnnotationDTO annotation) {
		DBQuery query = new DBQuery(MTroadRunnerData.VUNALLOCATEDCREDIT, "customerId=" + customerId);
		BigDecimal toBeAllocated = debit.getAmount();
		query.execute(new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				VUnallocatedCreditDTO ucDTO = new VUnallocatedCreditDTO(rs);
				if (ucDTO.getUnAllocated().compareTo(toBeAllocated)>=0) {
					AllocationDTO allocation = new AllocationDTO();
					allocation.setCreditRevisionId(ucDTO.getRevisionId());
					allocation.setDebitRevisionId(debit.getRevisionId());
					allocation.setStartAnnotationId(annotation.getAnnotationId());
					allocation.setAmount(toBeAllocated);
					allocation.insert();
					return;
				}
				else {
					AllocationDTO allocation = new AllocationDTO();
					allocation.setCreditRevisionId(ucDTO.getRevisionId());
					allocation.setDebitRevisionId(debit.getRevisionId());
					allocation.setStartAnnotationId(annotation.getAnnotationId());
					allocation.setAmount(ucDTO.getUnAllocated());
					allocation.insert();
					toBeAllocated.subtract(ucDTO.getUnAllocated());
				}
			}
		});
	}
	
}
