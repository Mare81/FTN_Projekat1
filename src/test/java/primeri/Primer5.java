          package primeri;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Primer5 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		// Puts an Implicit wait, Will wait for 10 seconds
		// before throwing exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Launch website
		driver.navigate().to("http://www.calculator.net/interest-calculator.html");
		driver.manage().window().maximize();
		// Selecting an item from Drop Down list Box
		Select dropdown = new Select(driver.findElement(By.id("ccompound")));
		dropdown.selectByVisibleText("continuously");
		// you can also use dropdown.selectByIndex(1) to
		// select second element as index starts with 0.
		// You can also use dropdown.selectByValue("annually");
		System.out.println("The Output of the IsSelected " + driver.findElement(By.id("ccompound")).isSelected());
		System.out.println("The Output of the IsEnabled " + driver.findElement(By.id("ccompound")).isEnabled());
		System.out.println("The Output of the IsDisplayed " + driver.findElement(By.id("ccompound")).isDisplayed());
		driver.close();
	}
}
