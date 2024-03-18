package selenium3;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class H_NewWindow_Invoking_MultipleWindow2_With_ScreenShots {

	public static void main(String[] args) throws IOException {
	
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
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);
		
		File file = name.getScreenshotAs(OutputType.FILE);  //element capture only not entire page
		FileUtils.copyFile(file, new File("C:\\Users\\Computer\\Desktop\\postoffice\\Rahul\\logo.png"));
		
		
		//Get Height and Width
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		driver.quit();
		
	}

}
