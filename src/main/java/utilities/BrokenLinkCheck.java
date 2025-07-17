package utilities;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BrokenLinkCheck {

	WebDriver driver;
	WebDriverWait wait;

	public BrokenLinkCheck(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	public void linkCheck(String pageURL) {
		driver.get(pageURL);
		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement link : links) {
			wait.until(ExpectedConditions.elementToBeClickable(link));
			String url = link.getAttribute("href");
			if (url == null || url.isEmpty()) {
				Log.info("Empty Link");
				continue;

			} 
			else {
				try {
					URL linkUrl = new URL(url);
					HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
					connection.setConnectTimeout(3000);
					connection.connect();

					if (connection.getResponseCode() >= 400) {
						Log.info(url + " Connection Failed, Code = " + connection.getResponseCode());
					} else {
						Log.info(url + " Connection Success, Code = " + connection.getResponseCode());
					}
				} catch (Exception e) {
					Log.info("Error Message : " + e.getMessage());
				}
			}

		}
	}

}
