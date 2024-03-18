package selenium1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C_UpdateDropdown {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); //URL in the browser
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		int i=1;
		while(i<5)
		{
				driver.findElement(By.id("hrefIncAdt")).click(); //4times
				i++;
		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("btnclosepaxoption")).click();
		
/*		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		for(int j=1;j<5;j++)   //wraped in one place instead of writing pieces like while loop.
		{
			driver.findElement(By.id("hrefIncAdt")).click(); //4times
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		*/
	}
	
}
