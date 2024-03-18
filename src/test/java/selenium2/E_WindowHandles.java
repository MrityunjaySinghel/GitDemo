package selenium2;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//new window and new tab are treated only new window in Selenium

public class E_WindowHandles {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.cssSelector(".blinkingText")).click(); 
		//Return a set of window handles which can be used to iterate over all open windows of thisWebDriver instance by passing them to switchTo().Options.window() 
		Set<String> windows=driver.getWindowHandles();  //[parentid,childid] -->get all window id which is opened in the Automation in the Set data structure
		Iterator<String> it = windows.iterator();
		String parentId = it.next(); //get the next index in the Set
		String childId=it.next();
		driver.switchTo().window(childId); //driver will get to know this is child window
		
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
	}

}
