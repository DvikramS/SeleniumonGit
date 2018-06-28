package Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Page.LoginPage;
import Utility.CommonFunctions;
import Utility.UtilityFunctions;
import BasePage.Base;

public class LoginTest {
	
//ExtentTest logger;
//ExtentTest logger2;
public static ExtentReports extent;
	//dataProvider="getDataForVerifyLogin"
@BeforeSuite
	public void initilize(){
			extent=new ExtentReports();
		 extent.attachReporter(Base.reporter);
	}

	@Test(dataProvider="getDataForVerifyLogin", enabled=true)
	public void VerifyLogin(Hashtable<String,String> hs){
		//logger=extent.createTest("VerifyLogin");
		Base.s= hs.get("UserName")+ hs.get("Password");
		
		if(!UtilityFunctions.IsExecutable("VerifyLogin", Base.xl))
			throw new SkipException("Skipped");

	
		new LoginPage(Base.ps.getProperty("Browser"),Base.ps.getProperty("URL"));
		LoginPage.login(hs.get("UserName"), hs.get("Password"));
		Assert.assertTrue(LoginPage.assertexpected.contains(LoginPage.assertactualvalue),"Passed");
		//logger.log(Status.PASS, "Passed" + hs.get("UserName")+ hs.get("Password"));
		
			
		
	}
/*@AfterTest
	public void resut(ITestResult r) throws IOException{
		if(r.getStatus()==ITestResult.FAILURE){
			logger.log(Status.FAIL, "Failed");
			String temp=CommonFunctions.Screenshots("VerifyLogin");
			
			logger.fail(r.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		extent.flush();
	}
*/	@DataProvider
	public Object[][] getDataForVerifyLogin(){
		
		Object obj[][]=UtilityFunctions.getData("VerifyLogin", Base.xl);
		return obj;
		
					}
	
	
	@Test(dataProvider="getDataForVeriyAddAddress")
	public void VeriyAddAddress(String add,String city1, String zip1, String phone1, String mobile1, String al ){
		//logger2=extent.createTest("VeriyAddAddress");
		Base.s=add+city1;
		if(!UtilityFunctions.IsExecutable("VeriyAddAddress", Base.xl))
			throw new SkipException("Skipped");
		LoginPage.addAddress(add,city1,zip1,phone1,mobile1,al);
		String s="";
		for(int i=0;i<LoginPage.assertvaluea.size();i++){
			if(LoginPage.assertvaluea.get(i).getText().equals(LoginPage.assertvaluee)){
				s=LoginPage.assertvaluea.get(i).getText();
				break;
			}
			System.out.println(s);
		}
		Assert.assertTrue(s.equalsIgnoreCase(LoginPage.assertvaluee), "Passed");
		//logger2.log(Status.PASS, "Passed");
	}
	
	@DataProvider
	public Object[][] getDataForVeriyAddAddress(){
		Object[][] ob=new Object[1][6];
		ob[0][0]="test";
		ob[0][1]="tes1";
		ob[0][2]="12345";
		ob[0][3]="8585977960";
		ob[0][4]="8585977960";
		ob[0][5]="New";
		return ob;
	}
/*	@AfterTest
	public void resut1(ITestResult r){
		if(r.getStatus()==ITestResult.FAILURE){
			logger2.log(Status.FAIL, "Failed");
		}
		extent.flush();
	}
*/	@AfterSuite
	public void close(){
		Base.dr.quit();
	}
}
