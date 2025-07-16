package practise1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practise1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
		String title =  driver.getTitle();
		System.out.println(title);
	}

}
