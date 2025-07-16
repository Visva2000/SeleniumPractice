package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtility {

	public static String captureScreenshot(WebDriver driver, String testName) {
	    String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	    String destDir = System.getProperty("user.dir") + "/reports/screenshots";
	    File directory = new File(destDir);
	    if (!directory.exists()) directory.mkdirs(); // create dir if not exists

	    String destPath = destDir + "/" + testName + "_" + timestamp + ".png";

	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);
	    File dest = new File(destPath);

	    try {
	        FileUtils.copyFile(src, dest);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    // ✅ Return relative path to the report HTML location
	    return "./screenshots/" + testName + "_" + timestamp + ".png";
	}

}
