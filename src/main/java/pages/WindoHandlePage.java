package pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Log;

public class WindoHandlePage{
	WebDriver driver;
	WebDriverWait wait;
	
	public WindoHandlePage(WebDriver driver, WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//button[contains(text(),\"New Tab\")]")
	WebElement  NewTabBtn;
	
	@FindBy(xpath="//h1")
	WebElement text;
	public void windowSwitch() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true)",NewTabBtn);
		String mainWindow = driver.getWindowHandle();
		wait.until(ExpectedConditions.elementToBeClickable(NewTabBtn)).click();
		Set<String> windows = driver.getWindowHandles();
		for(String window : windows) {
			if(!window.equals(mainWindow)) {
				
				driver.switchTo().window(window);
				wait.until(ExpectedConditions.visibilityOf(text));
				Log.info(text.getText());
//				driver.close();
				driver.switchTo().window(mainWindow);
				
			}
		}
	}
}
