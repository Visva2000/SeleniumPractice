package utilities;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CommonClasses {

	WebDriver driver;
	WebDriverWait wait;
	Alert alert;
	public CommonClasses(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void SimpleAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
		 alert = driver.switchTo().alert();
//		 wait.until(ExpectedConditions.text)
		 System.out.println(alert.getText());
		 alert.accept();
	}
	
//	//RegisterPageclass
//	@FindBy(xpath="")
//	WebElement windowbutton;
//	public void pagewithWindow() {
//		
//		String mainWindow = driver.getWindowHandle();
//		windowbutton.click();
//		classes.windows(mainWindow); // classes is the object name for CommonClasses class
//		
//	}
	
	
	public void windows(String mainWindow) {
		
		Set<String> handles = driver.getWindowHandles();
//		List<String> handlesList = new ArrayList<>(handles);
//		driver.switchTo().window(handlesList[1]);
		for(String handle:handles) {
			driver.switchTo().window(handle);
			if(driver.getTitle().equals("Expected Title")) {
				// Operations to be done
				driver.close();
				break;
				
			}
			else {
				driver.close();
			}
			
			
		}
		driver.switchTo().window(mainWindow);
		
	}
	
	public void iFrames(String framename, WebElement text  ) throws InterruptedException {
		
		driver.switchTo().frame(framename);
		wait.until(ExpectedConditions.visibilityOf(text));
		System.out.println(text.getText());
		driver.switchTo().defaultContent(); // switching back to main frame
	}
}
