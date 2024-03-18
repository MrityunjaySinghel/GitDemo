package selenium1;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//ctr+shift +f
public class J_Code_Formatting_Debugging {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.get("http://facebook.com");
		driver.findElement(By.xpath("id('email')")).sendKeys("gdhf");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://google.com");

		int a = 5;
		getScreenshot(driver);
		
		System.out.println(a);
		
	}	
		public static void getScreenshot(WebDriver driver) throws Exception
		{
			driver.get("http://google.com");
		
		File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\Computer\\Desktop\\postoffice\\Rahul\\screenshot.png"));
	
	}
			
	}

