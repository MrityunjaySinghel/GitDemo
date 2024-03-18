package selenium2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class D_ActionClassDemo {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		Actions action = new Actions(driver); //driver now will get capabilities of Action class method
		//moves to specific element
		action.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).build().perform();
		
	}

}
