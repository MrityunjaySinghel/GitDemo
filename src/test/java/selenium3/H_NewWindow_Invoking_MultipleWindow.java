package selenium3;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class H_NewWindow_Invoking_MultipleWindow {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.TAB);
	//driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowId= it.next();
		String childWindowId = it.next();
		driver.switchTo().window(childWindowId);
		driver.get("https://courses.rahulshettyacademy.com/courses/");
		
//		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/courses']")).get(1).getText();
		String courseName = driver.findElement(By.xpath("//div[@title='Java SDET Automation Package - 6 Courses Bundle']")).getText();
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);
		driver.quit();
		
	}

}
