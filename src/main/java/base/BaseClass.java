package base;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;
import utilities.Log;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriverWait wait;

	@BeforeClass
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) {
		if (driver == null) {
			Log.info("Execution Starts");
			switch (br.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			default:
				Log.info("Invalid Browser");
			}
			driver.manage().window().maximize();
			if(ConfigReader.getConfigData("url")==null) {
				Log.info("No URL in Config File");
			}
			else {
				driver.get(ConfigReader.getConfigData("url"));
			}
//			driver.get("https://tutorialsninja.com/demo/");
//			driver.get("https://the-internet.herokuapp.com/iframe");
//			driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		}

	}

	@AfterSuite
	public void teardown() {
		if(driver!=null) {
			Log.info("Execution Completed");
			driver.quit();
		}
	}
}
