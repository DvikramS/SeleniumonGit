package Test;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BasePage.Base;
import Page.PrintingPage;
import Utility.UtilityFunctions;

public class PrintingTestCase {

	ExtentTest logger3;
	//ExtentReports extent;
	
	
	@Test(enabled=true)
	public void Printtest(){
		//logger3=LoginTest.extent.createTest("Printtest");
		if(!UtilityFunctions.IsExecutable("Printtest", Base.xl))
			throw new SkipException("skipped");
		PrintingPage.testing();
		//logger3.log(Status.PASS, "passed");
	}
	
	/*@AfterMethod
	public void setup(ITestResult r){
		if(r.getStatus()==ITestResult.FAILURE){
			logger3.log(Status.FAIL, "failed");
		}
		LoginTest.extent.flush();
	}*/
}
