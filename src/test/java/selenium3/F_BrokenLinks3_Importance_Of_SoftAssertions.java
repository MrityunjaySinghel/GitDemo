package selenium3;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class F_BrokenLinks3_Importance_Of_SoftAssertions {

	public static void main(String[] args) throws MalformedURLException, IOException {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li']  a"));

		//Soft Assertions-->is a class,from TestNG package
		SoftAssert a = new SoftAssert();
		
		for(WebElement link : links)
		{
			
			String url = link.getAttribute("href");
			
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			
			//Assertions-Hard Assert
	//		Assert.assertTrue(respCode<400, "The link with Text" + link.getText()+"  is broken with code" +respCode);
			////Soft Assertions-->if see the greater than 403,then it will store the failure but not immediately stop the execution.
			a.assertTrue(respCode<403, "The link with Text" + link.getText()+"  is broken with code" +respCode);//now this is called Soft Assertion
			
		}
		//whatever you failure you store then apply assertAll then fail.--Report this at the end -complete execution
		a.assertAll();//that line fail the script,it will not store any failure then pass our scripts.This way we can avoid the stop of execution by soft Assert.
			
	}

}
