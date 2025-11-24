package com.jsantos.demo.jobs;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.jsantos.common.util.MapValues;
import com.jsantos.gui.filegroup.FileUIUtil;
import com.jsantos.metadata.MTroadRunnerData;
import com.jsantos.metadata.acc.VUnpaidDebitDTO;
import com.jsantos.metadata.common.EnuTemplateType;
import com.jsantos.metadata.inv.InvoiceDTO;
import com.jsantos.metadata.inv.InvoiceDocumentDTO;
import com.jsantos.metadata.inv.InvoiceLedgerItemDTO;
import com.jsantos.metadata.inv.VInvoiceableAccountDTO;
import com.jsantos.orm.DBTransaction;
import com.jsantos.orm.dbstatement.DetachedQueryResult;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.template.FileExportService;
import com.jsantos.template.TemplateData;

import freemarker.cache.FileTemplateLoader;

public class Escalation {
	
	public void runEscalation() {
		DetachedQueryResult dqr = new DetachedQueryResult(MTroadRunnerData.VINVOICEABLEACCOUNT);
		dqr.setPageSize(1000);
		ArrayList<VInvoiceableAccountDTO> accounts = (ArrayList<VInvoiceableAccountDTO>) dqr.getPage(0, VInvoiceableAccountDTO.class).getRawData();
		
		
		for (VInvoiceableAccountDTO account:accounts) {
			new DBTransaction() {
				@Override
				protected void exec() {
					InvoiceDTO invoiceDTO = new InvoiceDTO();
					invoiceDTO.setCustomerId(account.getCustomerId());
					invoiceDTO.insert();
					
					DetachedQueryResult dqr = new DetachedQueryResult(MTroadRunnerData.VUNPAIDDEBIT, " and customerId=" + account.getCustomerId());
					dqr.setPageSize(null);
					ArrayList<VUnpaidDebitDTO> unpaidDebits = (ArrayList<VUnpaidDebitDTO>) dqr.getPage(0, VUnpaidDebitDTO.class).getRawData();
					for (VUnpaidDebitDTO debit:unpaidDebits) {
						InvoiceLedgerItemDTO invoiceLedgerItemDTO = new InvoiceLedgerItemDTO();
						invoiceLedgerItemDTO.setInvoiceId(invoiceDTO.getInvoiceId());
						invoiceLedgerItemDTO.setLedgerItemId(debit.getLedgerItemId());
						invoiceLedgerItemDTO.insert();
					}
					
					InvoiceDocumentDTO invoiceDocumentDTO = new InvoiceDocumentDTO();
					invoiceDocumentDTO.setAmountDue(account.getBalance().abs());
					invoiceDocumentDTO.setInvoiceId(invoiceDTO.getInvoiceId());
					
					invoiceDocumentDTO.insert();
					
					createPdf(invoiceDocumentDTO);
					
				}
			}.exec();
		}
	}
	
	
	public void createPdf(InvoiceDocumentDTO invoiceDocumentDTO) {
		try {
			MapValues<Object> data= new MapValues<Object>();
			
			DetachedRecord dr = new DetachedRecord(MTroadRunnerData.VINVOICEHEADER, new MapValues<Object>().add("invoiceId", invoiceDocumentDTO.getInvoiceId()));
	        data.put("invoiceHeader", dr.getOriginalValues().getPlainValues());
			
	        DetachedQueryResult dqr = new DetachedQueryResult(MTroadRunnerData.VITEMINVOICEDETAIL, " and invoiceId=" + invoiceDocumentDTO.getInvoiceId());
			dqr.setPageSize(null);
			ArrayList<MapValues<Object>> details = dqr.getPlainPage(0);
	        
			if(details.isEmpty())
				return;
	        
	        data.put("itemInvoiceDetails", details); 
	        
			FileExportService fes= new FileExportService(new FileTemplateLoader());
			TemplateData templateData= new TemplateData();
			templateData.setTemplateTypeId(EnuTemplateType.INV);
			templateData.setData(data);
			File file=fes.generatePDF(templateData);
			LinkedHashMap<File, String> newFiles = new LinkedHashMap<File, String>();
			newFiles.put(file, MTroadRunnerData.INVOICEDOCUMENT.getTableName()+"_"+invoiceDocumentDTO.getInvoiceId());
			invoiceDocumentDTO.set(MTroadRunnerData.INVOICEDOCUMENT.FILEGROUPID, FileUIUtil.insertFileGroup(newFiles, MTroadRunnerData.INVOICEDOCUMENT.getTableName()));
			invoiceDocumentDTO.insertOrUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage()+ "InvoiceId="+invoiceDocumentDTO.getInvoiceId());
		}
	}
}
