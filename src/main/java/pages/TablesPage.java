package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Log;

import org.openqa.selenium.WebElement;

public class TablesPage {

	WebDriver driver;
	WebDriverWait wait;

	public TablesPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//table[@id='customers']")
	WebElement table1;

	public void tableheaderDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(table1));
		List<WebElement> rowheaders = driver.findElements(By.xpath("//table[@id='customers']//tr[1]//th"));
		for (int i = 1; i <= rowheaders.size(); i++) {
			WebElement header = driver.findElement(By.xpath("//table[@id='customers']//tr[1]//th[" + i + "]"));
			System.out.println(header.getText());
		}

	}

	public void tabledatas() {
		wait.until(ExpectedConditions.visibilityOf(table1));
		List<WebElement> datarows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		for (int i = 2; i <= datarows.size(); i++) {
			WebElement company = driver.findElement(By.xpath("//table[@id='customers']//tr[" + i + "]//td[1]"));
			wait.until(ExpectedConditions.visibilityOf(company));
			if (company.getText().equals("Microsoft")) {
				WebElement contact = driver.findElement(By.xpath("//table[@id='customers']//tr[" + i + "]//td[2]"));
				wait.until(ExpectedConditions.visibilityOf(contact));
				WebElement country = driver.findElement(By.xpath("//table[@id='customers']//tr[" + i + "]//td[3]"));
				wait.until(ExpectedConditions.visibilityOf(country));
				System.out.println("Company = " + company.getText());
				System.out.println("Contact = " + contact.getText());
				System.out.println("Country = " + country.getText());
			}
		}

	}

	public List<WebElement> alternateTableHeaderMethod() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='tsc_table_s13']")));
		List<WebElement> headerRow = driver.findElements(By.xpath("//table[@class='tsc_table_s13']//thead//tr//th"));

//		for(WebElement headValues : headerRow) {
//			Log.info(headValues.getText());
//		}

		return headerRow;
	}

	
	public void alternateTableDatas(String structure) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='tsc_table_s13']")));

		List<WebElement> struct = driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tbody//tr//th//span"));
		for (WebElement s : struct) {
			if (structure.equals(s.getText())) {
				List<WebElement> rowValues = driver
						.findElements(By.xpath("//table[@class='tsc_table_s13']//tbody//tr[th//span[contains(text(),'"
								+ structure + "')]]//td"));

				List<WebElement> headerData = alternateTableHeaderMethod();
				if (!headerData.isEmpty()) {
					Log.info("Structure = "+ structure);

					for (WebElement row : rowValues) {
						for (WebElement head : headerData) {
							if (head.getText().equals("Structure")) {
								continue;
							} else {
								Log.info(head.getText() + " = " + row.getText());
								headerData.remove(head);
								break;
							}

						}

					}
				}
				break;
			} 
//			else {
//				Log.info("Else condition is executed");
//			}
		}

	}
}
