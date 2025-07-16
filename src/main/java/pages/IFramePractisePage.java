package pages;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonClasses;
public class IFramePractisePage {

	WebDriver driver;
	WebDriverWait wait;
	CommonClasses classes;
	public IFramePractisePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		classes = new CommonClasses(driver, wait);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//p[contains(text(),'content goes')]")
	WebElement text;
	
	@FindBy(xpath = "//div[@role='alert']//button")
	WebElement closeBtn;
	
	public void FramesSwitch() throws InterruptedException {
		//mce_0_ifr
		wait.until(ExpectedConditions.visibilityOf(closeBtn)).click();
		//Thread.sleep(Duration.ofSeconds(20));
//		closeBtn.click();
		classes.iFrames("mce_0_ifr",text);
	}
	
}
