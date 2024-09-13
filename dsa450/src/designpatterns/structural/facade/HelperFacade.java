package designpatterns.structural.facade;

import java.sql.Connection;

public class HelperFacade {
	public static void generateReport(DBTypes dbtypes, ReportType reportType, String tableName) {
		switch (dbtypes) {
		case MySql:
			MySqlHelper sqlHelper = new MySqlHelper();
			Connection con = sqlHelper.getMySqlConnection();
			switch (reportType) {
			case Pdf:
				sqlHelper.generateMySqlPdfReport(tableName, con);
				break;
			case Html:
				sqlHelper.generateMySqlHtmlReport(tableName, con);
				break;
			}
			break;
		case Oracle:
			OracleHelper oracleHelper = new OracleHelper();
			Connection conn = oracleHelper.getOracleConnection();
			switch (reportType) {
			case Pdf:
				oracleHelper.generateOraclePdfReport();
				break;
			case Html:
				oracleHelper.generateOracleHtmlReport();
				break;
			}
			break;
		}
	}

	public static enum DBTypes {
		MySql, Oracle;
	}

	public static enum ReportType {
		Pdf, Html;
	}
}
