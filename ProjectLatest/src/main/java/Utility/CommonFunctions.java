package Utility;


import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


















import BasePage.Base;

public class CommonFunctions {
	
	public static void implicitWait(){
		Base.dr.manage().timeouts().implicitlyWait(Integer.parseInt(Base.ps.getProperty("ImplicitWaitTime")), TimeUnit.SECONDS);
	}
	public static void ExplicitWait(WebElement element){
		
		WebDriverWait wt=new WebDriverWait(Base.dr,30);
		wt.until(ExpectedConditions.visibilityOf(element));
		
	}
	public static void enterDataWithoutcmd(String pass){
		JavascriptExecutor js=(JavascriptExecutor)Base.dr;
		js.executeScript("document.getElementById('pass').value='text'");
	}
	
	public static void SelectDropdown(WebElement element){
		Select s=new Select(element);
		s.selectByIndex(0);
		
	}
	public static String Screenshots(String filename){
		TakesScreenshot ts=(TakesScreenshot)Base.dr;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\ScreenShots\\"+filename+".jpg");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
		
		
	}
	public static void MouseHover(WebElement element){
		Actions ac=new Actions(Base.dr);
		ac.moveToElement(element);
	}
	public static void switchtoAlert(){
		Alert al=Base.dr.switchTo().alert();
		al.accept();
		al.dismiss();
		al.getText();
		Base.dr.switchTo().defaultContent();
		
	}
	public static void clickOnHiddenElement(){
		JavascriptExecutor js=(JavascriptExecutor)Base.dr;
		js.executeScript("document.getElementById('id').click()");
	}
	public static void BrokenLinks(){
		java.util.List<WebElement> l=Base.dr.findElements(By.tagName("a"));
		for(int i=0;i<l.size();i++){
		try {
			URL url=new URL(l.get(i).getAttribute("href"));
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			con.setConnectTimeout(30);
			con.connect();
			if(con.getResponseCode()!=200){
				System.out.println(l.get(i).getAttribute("href"));
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}
	public static void switchToFrame(){
		Base.dr.switchTo().frame(0);
		Base.dr.switchTo().defaultContent();
	}
	
	public Connection DBCon(){
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 con =DriverManager.getConnection("","","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	public static void scrolltoView(WebElement element){
		JavascriptExecutor js=(JavascriptExecutor) Base.dr;
		js.executeScript("arguments[0].scrollIntoView().click()",element);
	}
	public static void DoubleClick(WebElement element){
		Actions ac=new Actions(Base.dr);
		ac.doubleClick(element).build().perform();
	}
	
	
	
	
	
	

	

}
