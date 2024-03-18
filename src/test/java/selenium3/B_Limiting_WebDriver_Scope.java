package selenium3;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class B_Limiting_WebDriver_Scope {

	public static void main(String[] args) {

		// 1.Give me the count of links on the page
		// 2.count of footer section

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		System.out.println(driver.findElements(By.tagName("a")).size());

		WebElement footerDriver = driver.findElement(By.id("gf-BIG")); // limiting WebDriver Scope
		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		// 3-
		WebElement columndriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());

		// org.openqa.selenium.StaleElementReferenceException: stale element reference:
		// stale element not found
		// 4 --click on each link in the column and check if the pages are opening
		for (int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++) 
		{
			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			
		}

	}

}
