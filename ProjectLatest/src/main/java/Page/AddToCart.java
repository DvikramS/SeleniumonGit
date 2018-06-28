package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utility.CommonFunctions;
import BasePage.Base;

public class AddToCart {

	public static String women="//a[text()='Women']";
	public static String tshirts="//a[text()='T-shirts']";
	public static String image="//img[@alt='Faded Short Sleeve T-shirts']";
	public static String AddTocart="//a[@title='Add to cart']/span[text()='Add to cart']";
	public static String assertText=".//*[@id='layer_cart']/div[1]/div[1]/h2";
	public static String assertActualText;
	public static String actualtext="Product successfully added to your shopping cart";
	
	
	
	public static void VerifyAddToCart(){
		
		WebElement element=Base.dr.findElement(By.xpath(women));
		Actions ac=new Actions(Base.dr);
		ac.moveToElement(element).build().perform();
		//CommonFunctions.MouseHover(element);
		WebElement el=Base.dr.findElement(By.xpath(tshirts));
		JavascriptExecutor js=(JavascriptExecutor)Base.dr;
		js.executeScript("arguments[0].click()", el);
		
		
		WebElement element1=Base.dr.findElement(By.xpath(image));
		//CommonFunctions.MouseHover(element1);
		ac.moveToElement(element1).build().perform();
		Base.dr.findElement(By.xpath(AddTocart)).click();
		
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	assertActualText=Base.dr.findElement(By.xpath(assertText)).getText();
	
	}
	
	
	
	
	
	
}
