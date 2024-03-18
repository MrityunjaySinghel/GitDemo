package selenium3;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F_BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//broken link
		//Step 1 - is to get all urls tied up to the links using Selenium
		//Java method will call URL'S and gets you the status code -->
		//Selenium alone can not help us to identify the broken link,we need to rely on some java method.do not hit the url,Actually call the java method and this method tell us what is the status code. 
		//Using Selenium  first land on the page then where we have to verify broken links,we do scan all the links by using Selenium,each link we will call getAttribute() method.pull up this url.-->mix of Selenium and java method.
		//if status code >400 then that url is not working -->link which tied to url is broken
		
		//URL is working or not
		//a[href*="soapui"]
		/*		String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
				System.out.println(url);     */
		
		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		//java method
		HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection(); //by using openConnection() method,open the connection then send url to network.then get the response
		conn.setRequestMethod("HEAD"); //call the Head request method
		conn.connect();
		int respCode = conn.getResponseCode(); //getResponseCode() --->get the status  code from an HTTP response message.
		System.out.println(respCode);
	}

}
