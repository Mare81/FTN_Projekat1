package primeri;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Primer4 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		// Puts an Implicit wait, Will wait for 10 seconds
		// before throwing exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Launch website
		driver.navigate().to("http://www.calculator.net/mortgage-calculator.html");
		driver.manage().window().maximize();
		// Click on check box
		driver.findElement(By.id("caddoptional")).click();
		System.out.println("The Output of the IsSelected " + driver.findElement(By.id("caddoptional")).isSelected());
		System.out.println("The Output of the IsEnabled " + driver.findElement(By.id("caddoptional")).isEnabled());
		System.out.println("The Output of the IsDisplayed " + driver.findElement(By.id("caddoptional")).isDisplayed());
		driver.close();
	}
}
