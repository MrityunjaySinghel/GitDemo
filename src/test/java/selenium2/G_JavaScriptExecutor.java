package selenium2;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class G_JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// by default selenium does not provide any scrolling technique.we will get by
		// using javascript because all the browser made by javascript
		JavascriptExecutor js = (JavascriptExecutor) driver;// Here casting the driver into JavascriptExecutor

		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

		int sum = 0;
		for (int i = 0; i < values.size(); i++) {
			// System.out.println(Integer.parseInt(values.get(i).getText()));//convert
			// String values to Integer.then print
			sum = sum + Integer.parseInt(values.get(i).getText());
		}
		System.out.println(sum);
		driver.findElement(By.cssSelector(".totalAmount")).getText();
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());

		Assert.assertEquals(sum, total);
	}

}
