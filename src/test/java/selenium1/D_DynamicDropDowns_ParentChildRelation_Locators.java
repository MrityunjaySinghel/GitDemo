package selenium1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D_DynamicDropDowns_ParentChildRelation_Locators {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); //URL in the browser
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); //Some clients do not like indexing concept
		
		//This one is avoid indexing concept
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']  //a[@value='MAA']")).click();
		
		//Parent to Child traverse--->Child xpath will search only the scope of Parent xpath.
		
	}

}


