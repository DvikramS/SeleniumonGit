package Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utility.CommonFunctions;
import BasePage.Base;

public class LoginPage extends Base {

	public static String signin="//*[contains(text(),'Sign in')]";
	public static String email="//*[@name='email']";
	public static String pswd="//*[@id='passwd']";
	public static String login=".//*[@id='SubmitLogin']";
	public static String assertpath="//*[@class='account']/span";
	public static String assertexpected="dhirendra Vikram";
	public static String assertactualvalue;
	public static String address="//*[contains(@title,'Addresses')]";
	public static String addaddress="//*[contains(@title,'Add an address')]";
	public static String address1="//*[@id='address1']";
	public static String city="//*[@id='city']";
	public static String state="//*[@id='id_state']";
	public static String zip="//*[@id='postcode']";
	public static String country="//*[@id='id_country']";
	public static String phone="//*[@id='phone']";
	public static String mobile ="//*[@id='phone_mobile']";
	public static String alias="//*[@id='alias']";
	public static String save="//*[@id='submitAddress']";
	public static String assertadd="//*[contains(@class,'col-xs-12')]/ul[contains(@class,'item box')]/li/h3";
	public static String assertvaluee="NEW";
	public static List<WebElement>assertvaluea;
	
	public LoginPage(String browser, String AppURL){
		super(browser,AppURL);
	}
	public static void login(String Username, String ppassword){
	
		Base.dr.findElement(By.xpath(signin)).click();
		Base.dr.findElement(By.xpath(email)).sendKeys(Username);
		Base.dr.findElement(By.xpath(pswd)).sendKeys(ppassword);
		Base.dr.findElement(By.xpath(login)).click();
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertactualvalue=Base.dr.findElement(By.xpath(assertpath)).getText();
		
	}
	
	public static void addAddress(String add,String city1, String zip1, String phone1, String mobile1, String al ){
		Base.dr.findElement(By.xpath(address)).click();
		Base.dr.findElement(By.xpath(addaddress)).click();
		Base.dr.findElement(By.xpath(address1)).sendKeys(add);
		Base.dr.findElement(By.xpath(city)).sendKeys(city1);
		Select s1=new Select(Base.dr.findElement(By.xpath(state)));
		s1.selectByVisibleText("Iowa");
		Base.dr.findElement(By.xpath(zip)).sendKeys(zip1);
		Base.dr.findElement(By.xpath(phone)).sendKeys(phone1);
		Base.dr.findElement(By.xpath(mobile)).sendKeys(mobile1);
		Base.dr.findElement(By.xpath(alias)).clear();
		Base.dr.findElement(By.xpath(alias)).sendKeys(al);
		Base.dr.findElement(By.xpath(save)).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertvaluea=Base.dr.findElements(By.xpath(assertadd));
		
		
		
	}
	
	
}
