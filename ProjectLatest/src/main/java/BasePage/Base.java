package BasePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utility.ExcelUtility;

public class Base {

	public static Properties ps;
	public static FileInputStream fis;
	public static boolean isBrowserClosed=true;
	public static WebDriver dr;
	public static ExcelUtility xl;
	public static ExtentHtmlReporter reporter;
	public static String s="";
	static{
	 ps=new Properties();
	 reporter=new ExtentHtmlReporter("C:\\Users\\Dhirendrasingh\\Desktop\\Paission\\Selenium\\Project\\Reports\\extentreporting.html");

	 
	 try {
		fis=new FileInputStream(".\\src\\main\\java\\Config\\config.properties");
		ps.load(fis);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 xl=new ExcelUtility(".\\TestDate.xlsx");
		
	}
	
	
	
	public Base(String Broswer, String URL){
		if(isBrowserClosed ||dr==null){
			if(Broswer.equalsIgnoreCase("chrome")){
			System.setProperty("google.chrome.driver", ".\\chromedriver.exe");
			ChromeOptions co=new ChromeOptions();
			co.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			dr=new ChromeDriver();
			dr.manage().window().maximize();
			dr.navigate().to(URL);
			
			}
			if(Broswer.equalsIgnoreCase("FireFox")){
				System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
				dr=new FirefoxDriver();
				dr.manage().window().maximize();
				dr.navigate().to(URL);
			}
			if(Broswer.equalsIgnoreCase("IE")){
				System.setProperty("webdriver.ie.driver", ".\\IEDriverServer.exe");
				InternetExplorerOptions io=new InternetExplorerOptions();
				io.setCapability("nativeEvents", false);
				dr= new InternetExplorerDriver(io);
				dr.manage().window().maximize();
				dr.navigate().to(URL);
			}
			isBrowserClosed=false;
		}
	}
	/*public static void main(String[] args) {
		Base b=new Base(ps.getProperty("Browser"),ps.getProperty("URL"));
	}*/
	
	
	
	
	
	
}
