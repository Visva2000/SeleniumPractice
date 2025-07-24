package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public DropDownPage(WebDriver driver, WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class=\" css-1hwfws3\"]//div[contains(text(),\"Select Option\")]")
	WebElement dropDownBtn;
	
//	@FindBy(xpath="//div[@class=\" css-yk16xz-control\"]//div//div[contains(text(),\"Group 2, option 2\")]")
//	WebElement value;
	
	@FindBy(xpath="//input[@id='react-select-2-input']")
	WebElement finalValue;
	
	
	
	public void DropDownSelect() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)",dropDownBtn);
		wait.until(ExpectedConditions.elementToBeClickable(dropDownBtn)).click();
//		wait.until(ExpectedConditions.elementToBeClickable(value)).click();
//		js.executeScript("arguments[0].setAttribute('value','Group 2, option 2')",finalValue);
		finalValue.sendKeys("Group 2, option 2",Keys.ENTER);
	}
}
