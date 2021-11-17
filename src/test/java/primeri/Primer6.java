package primeri;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Primer6 {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/droppable/#default");
		driver.manage().window().maximize();

		Actions act = new Actions(driver);

		// Script for dragging an element and dropping it in another place
		WebElement iFrame = driver.findElement(By.tagName("iframe"));
		System.out.println(iFrame.getSize());
		driver.switchTo().frame(iFrame);
		//select source element
		WebElement From = driver.findElement(By.id("draggable"));
		System.out.println(From.getLocation());
		//select destination element
		WebElement To = driver.findElement(By.id("droppable"));
		//print current location
		System.out.println(To.getLocation());
		Thread.sleep(3000);
		//do drag and drop
		act.dragAndDrop(From, To).build().perform();
		Thread.sleep(3000);
		driver.close();
	}
}
