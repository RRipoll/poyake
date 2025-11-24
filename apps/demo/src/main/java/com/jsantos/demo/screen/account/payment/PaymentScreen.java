package com.jsantos.demo.screen.account.payment;

import org.zkoss.zk.ui.Component;

import com.jsantos.gui.form.IFormSerializer;
import com.jsantos.gui.form.MTForm;
import com.jsantos.gui.form.controller.MTInsertScreenController;
import com.jsantos.gui.zkutil.ZulDataWirer;
import com.jsantos.ledger.LedgerInterface;
import com.jsantos.metadata.MT;
import com.jsantos.metadata.payment.PaymentDTO;
import com.jsantos.orm.dbstatement.IDetachedRecord;

public class PaymentScreen extends MTInsertScreenController {
	Integer customerId;

	public PaymentScreen(Component parent, Integer customerId) {
		super(parent, MT.PAYMENT);
		this.customerId = customerId;
		mtForm.setSerializer(new FormSerializer());
	}

	public class FormSerializer implements IFormSerializer {

		@Override
		public boolean serialize(MTForm form) {
			for (IDetachedRecord dr : form.getDrs().values())
				ZulDataWirer.readFormFieldValues(dr, form.getFormComponent());

			PaymentDTO payment = (PaymentDTO) mtForm.getDrs().get(MT.PAYMENT);
			LedgerInterface.insertPayment(customerId, payment);
			return true;
		}
	}

}
