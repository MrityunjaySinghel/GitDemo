package selenium1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class G_ValidatingUI_Element_isEnabled_Or_isDisabled {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");	
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		//.ui-state-default.ui-state-highlight
		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		
		
		//Count the nos. of Check boxes
				System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
				
				driver.findElement(By.id("divpaxinfo")).click();
				Thread.sleep(1000);
				
				System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
				
				for(int j=1;j<5;j++)   //wraped in one place instead of writing pieces like while loop.
				{
					driver.findElement(By.id("hrefIncAdt")).click(); //4times
				}
				driver.findElement(By.id("btnclosepaxoption")).click();
				Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
				System.out.println(driver.findElement(By.id("divpaxinfo")).getText());	
	}

}
