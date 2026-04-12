package genericUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static ExtentReports getReportObject() {
		String path=System.getProperty("user.dir")+"//reports//index.html";
		ExtentReports er=new ExtentReports(); 
		ExtentSparkReporter esp=new ExtentSparkReporter(path);
		esp.config().setReportName("Love Beauty and Planet Automation");
		esp.config().setDocumentTitle("Test result");
		
		er.attachReporter(esp);
		er.setSystemInfo("Tester", "Shravan");
		return er;
		
	}
}
