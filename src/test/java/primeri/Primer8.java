package primeri;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Primer8 {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://www.calculator.net");
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of Links in the Page is " + links.size());
		for (int i = 0; i < links.size(); ++i) {
			System.out.println("Name of Link# " + i + "-" + links.get(i).getText());
		}
		driver.close();
	}
}
