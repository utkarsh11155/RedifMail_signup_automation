package DropDown_Menu;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {

	public static void highLightElement(WebDriver driver, WebElement element)
	{
	JavascriptExecutor js=(JavascriptExecutor)driver; 

	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 5px solid green;');", element);

	try 
{
	Thread.sleep(1000);
	} 
	catch (InterruptedException e) {

System.out.println(e.getMessage());
} 

	

	}

	}


