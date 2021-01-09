package Com.reports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


import Com.Utils.Readpropertyfile;
import Com.constants.Constants;

public class ExtentReport {

	public static ExtentReports report=null;
//	public static ExtentTest logger=null;
	public static String extentreportpath="";
	

	//To avoid external initialization
	private ExtentReport() {
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy_ hh_mm_ss");
		Date date = new Date();
		String currentDate = formatter.format(date);
		if(Readpropertyfile.get("OverrideResults").equalsIgnoreCase("yes")) 
		{
			if(Readpropertyfile.get("ResultPath").equals("")) 
			{
				extentreportpath=Constants.PROJECTPATH+"\\ExtentReports\\Test Report.html";
				
			}
			else {
				extentreportpath=Readpropertyfile.get("ResultPath")+"\\ExtentReports\\Test Report.html";
			}
		}
		else 
		{
			if(Readpropertyfile.get("ResultPath").equals("")) 
			{
				extentreportpath=Constants.PROJECTPATH+"\\ExtentReports\\Test Report_"+currentDate+".html";
			}
			
			else
			{
				extentreportpath=Readpropertyfile.get("ResultPath")+"\\ExtentReports\\Test Report_"+currentDate+".html";
				
			}

		}
		report=new ExtentReports(extentreportpath);
		report.loadConfig(new File(Constants.PROJECTPATH));
	}

	public static void initialize()
	{
		ExtentReport report=new ExtentReport();
	}

}
