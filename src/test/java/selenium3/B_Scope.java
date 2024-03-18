package selenium3;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//our tests are independent of link name

public class B_Scope {

	public static void main(String[] args) throws Exception {
		
		//1.Give me the count of links on the page
		//here all are soft coding not hard coding if tomorrow nos of link increases or decreases(dynamic),it will be worked,no need change the code
			
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/"); //Currently the scope of driver is on entire page,the driver is accessing to each and every objects.
		
		System.out.println(driver.findElements(By.tagName("a")).size());//26 //6 links only present out of footer section
		
		
		//1.Give me the count of links present on footer section
		//I am creating the subset and mini driver of the main driver only for the footer section,mini driver scope is only for footer section out of all entire page
		WebElement footerDriver =driver.findElement(By.id("gf-BIG"));//limiting WebDriver Scope       
		
		//I am creating the subset and mini driver of the main driver
		System.out.println(footerDriver.findElements(By.tagName("a")).size()); //20 links are present on footer section
		
		//3--
		WebElement columndriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size()); //limiting WebDriver Scope      
		
		
		//4 --click on each link in the column and check if the pages are opening
		for(int i=1;i<columndriver.findElements(By.tagName("a")).size(); i++)
		{
			String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			Thread.sleep(5000L);
			
		}//opens all the tabs
			//5--getting  the title of the child tabs
			Set<String>abc = driver.getWindowHandles();
			Iterator<String >it = abc.iterator(); //Iterator is storing all the window handles
			
			//once while loop false then it will come out of the loop.--while loop continue executing the loop until the condition will be false
			//hasNext() method tell us whether the index is present or not
			while(it.hasNext()) //is another window present in iterator or not , check the index is present or not
			{
				driver.switchTo().window(it.next()); //it.next() method--means actually move to next index.
				System.out.println(driver.getTitle());
			}
			
		}
		
	}


