package selenium3;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class E_Miscellaneous {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
// 	driver.manage().deleteCookieNamed("");
		
		//click on any link
				//login page --verify login url
		
		driver.get("https://www.google.com");
		
		//output the screenshot as a file that we are storing into object called src.
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//driver object converted into TakesScreenshot interface
		FileUtils.copyFile(src, new File("C:\\Users\\Computer\\Desktop\\postoffice\\Rahul\\logo.png")); //copy the file from source object and writing to our local destination
		//local machine creates a file
	}

}
