package selenium3;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class D_SSL_Check {

	public static void main(String[] args) {

		// Sets the behaviour of chrome browser
		ChromeOptions options = new ChromeOptions(); // with the hep of options object,we can able to access the methods
														// of ChromeOptions class

		// Sets the behaviour of firefox browser
//		FirefoxOptions options1 = new FirefoxOptions();
		// Sets the behaviour of edge browser
//		EdgeOptions options2 = new EdgeOptions();
//		options2.setAcceptInsecureCerts(true);
//		options1.setAcceptInsecureCerts(true);
		options.setAcceptInsecureCerts(true); // to accept the certificate and proceed to the actual website

		// Add the WebDriver proxy capability
		Proxy proxy = new Proxy(); // there is one special class in Java to handle all proxy related things
		proxy.setHttpProxy("ipaddress:8080");
		options.setCapability("proxy", proxy);// passing here proxy class object

		// Add a ChromeDriver specific capability -->just we modify the behavior of
		// existing driver
		options.addExtensions(new File(""));

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);

		WebDriver driver = new ChromeDriver(options); // invoking our browser-->//after passing object of ChromeOptions
														// class then only WebDriver get the knowledge how to invoke the
														// browser
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

	}

}
