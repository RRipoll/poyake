package com.etantolling.testrunner.test.core.dblog;

import com.etantolling.testrunner.test.core.dblog.modules.BackOffice;
import com.etantolling.testrunner.test.core.dblog.modules.Controller;
import com.etantolling.testrunner.test.core.dblog.modules.InputFiles;
import com.etantolling.testrunner.test.core.dblog.modules.Invoices;
import com.etantolling.testrunner.test.core.dblog.modules.LatitudeSync;
import com.etantolling.testrunner.test.core.dblog.modules.Mailer;
import com.etantolling.testrunner.test.core.dblog.modules.OutputFiles;
import com.etantolling.testrunner.test.core.dblog.modules.PaymentProcessor;
import com.etantolling.testrunner.test.core.dblog.modules.Reports;
import com.etantolling.testrunner.test.core.dblog.modules.TransactionProcessor;

public class Modules {
	public static BackOffice backOffice = new BackOffice();
	public static Controller controller = new Controller();
	public static InputFiles inputFiles = new InputFiles();
	public static Invoices invoices = new Invoices();
	public static LatitudeSync latitudeSync = new LatitudeSync();
	public static Mailer mailer = new Mailer();
	public static OutputFiles outputFiles = new OutputFiles();
	public static PaymentProcessor paymentProcessor = new PaymentProcessor();
	public static Reports reports = new Reports();
	public static TransactionProcessor transactionProcessor = new TransactionProcessor();
}
