package designpatterns.structural.facade;

import designpatterns.structural.facade.HelperFacade.DBTypes;
import designpatterns.structural.facade.HelperFacade.ReportType;

public class Demo {
	public static void main(String[] args) {
		// Without Facade Helper
		MySqlHelper mySqlHelper = new MySqlHelper();
		mySqlHelper.generateMySqlHtmlReport("e", mySqlHelper.getMySqlConnection());
		mySqlHelper.generateMySqlPdfReport("e", mySqlHelper.getMySqlConnection());
		// With Facade Helper
		HelperFacade.generateReport(DBTypes.MySql, ReportType.Pdf, "e");
	}
}
