package Test;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import BasePage.Base;
import Page.AddToCart;
import Page.LoginPage;
import Utility.CommonFunctions;
import Utility.UtilityFunctions;

public class AddCartTest {

	//public static ExtentTest logger3;
	
	@Test(enabled=true)
	public void VerifyCart(){
		//logger3=LoginTest.extent.createTest("VerifyCart");
		if(!UtilityFunctions.IsExecutable("VerifyCart", Base.xl))
			throw new SkipException("skipped");
		//Base.dr.navigate().to(Base.ps.getProperty("URL"));
		//LoginPage.login(Base.ps.getProperty("UserName"),Base.ps.getProperty("Password"));
		AddToCart.VerifyAddToCart();
		System.out.println(AddToCart.assertActualText);
		Assert.assertTrue(AddToCart.assertActualText.contains(AddToCart.actualtext), "Passed");
		//logger3.log(Status.PASS, "passed");
		
		
		
	}
	/*@AfterTest
	public void onfail(ITestResult r) throws IOException{
		if(r.getStatus()==ITestResult.FAILURE){
			String f=CommonFunctions.Screenshots("VerifyCart");
			logger3.fail(r.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(f).build());
		LoginTest.extent.flush();
		}
		
		
	}*/
	
	
}
