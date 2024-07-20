package DropDown_Menu;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropD_Menu {

	public static void main(String[] args) throws InterruptedException {
		 
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
	 
		WebElement link = driver.findElement(By.linkText("Create a new account"));
		Helper.highLightElement(driver, link);
		link.click();
	 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		
		WebElement Fullname = driver.findElement(By.cssSelector("input[name*='name']"));
		Helper.highLightElement(driver, Fullname);
		Fullname.sendKeys("Kamal");
		
		WebElement log = driver.findElement(By.cssSelector("input[name*='login']"));
		Helper.highLightElement(driver, log);
	    log.sendKeys("kamal1234");
	    
		WebElement CA = driver.findElement(By.cssSelector("input[name*='btnchkavail']"));
		Helper.highLightElement(driver, CA);
		CA.click();
		
		WebElement Btn = driver.findElement(By.cssSelector("input[id = 'radio_login']:nth-of-type(1)"));
		Btn.click();
		Helper.highLightElement(driver, driver.findElement(By.cssSelector("#recommend_text td:nth-of-type(2)")));
		
		WebElement PW = driver.findElement(By.cssSelector("input[name*='passwd']"));	
		Helper.highLightElement(driver, PW);
		PW.sendKeys("Kamal@1234");
		
//		driver.findElement(By.cssSelector("input[name*='confirm_passwd']")).sendKeys("Kamal@1234");
	 
		WebElement cb = driver.findElement(By.cssSelector("input[type = 'checkbox']"));
		cb.click();
		Helper.highLightElement(driver, driver.findElement(By.cssSelector("#altid_msg font:nth-of-type(1)")));
		
		
		WebElement Day = driver.findElement(By.cssSelector("select[name*='DOB_Day']"));
		Select menuItem = new Select(Day);
		Helper.highLightElement(driver, Day);
		menuItem.selectByVisibleText("20");
		
		WebElement Month = driver.findElement(By.cssSelector("select[name*='DOB_Month']"));
		Select menuItem1 = new Select(Month);
		Helper.highLightElement(driver, Month);
		menuItem1.selectByVisibleText("JUN");
		
		WebElement Year = driver.findElement(By.cssSelector("select[name*='DOB_Year']"));
		Select menuItem2 = new Select(Year);
		Helper.highLightElement(driver, Year);
		menuItem2.selectByVisibleText("2001");
		//Thread.sleep(3000);
		
		//Thread.sleep(3000);
		
		
		/*List<WebElement> countries=driver.findElements(By.cssSelector("select[name*='Country']"));*/
		Select dropdown = new Select(driver.findElement(By.id("country")));
		List<WebElement> countries=dropdown.getOptions();
		
		WebElement click_button = driver.findElement(By.id("country"));
		click_button.click();
		
		System.out.println("All the countries name!!");
		for(WebElement country : countries) {
			System.out.println(country.getText());
		}
		
		System.out.println("Total number of countries=> "+countries.size());
		
		//Select menuItem3 = new Select(driver.findElement(By.id("country")));
		//menuItem3.selectByVisibleText("India");
		dropdown.selectByVisibleText("India");
		Helper.highLightElement(driver, click_button);
		click_button.click();
		
		System.out.println("name of country selected=> "+/*menuItem3*/dropdown.getFirstSelectedOption().getText());
	    if(/*menuItem3*/dropdown.getFirstSelectedOption().getText().equalsIgnoreCase("India")) {
	    	System.out.println("Country selection is correct");
	    }else {
	       System.out.println("Country selection is incorrect");
	    }
	   // driver.close();
	}
}
