package selenium2;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//how to add items into Array
//how to split -->All are interview questions
public class BaseClass {
	 
	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		int j=0;
		
		String[] itemsNeeded = {"Cucumber","Brocolli","Beetroot","Mushroom"};  //here less memory declared array
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		Thread.sleep(2000L);
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0;i<products.size();i++)
		{
			//Brocolli - 1 Kg
			//Brocolli,  1 Kg
			
			
			String[] name = products.get(i).getText().split("-");
			String fromattedName= name[0].trim();
			
			//format it to get actual vegatable name
			//check whether name you extracted is present in array or not
			//Here run time convert into arraylist,In this way we can save the memory----convert array into arraylist for easy search,Array take less memory,ArrayList is used for complicated scenario.
		
			List<String> itemNeededList = Arrays.asList(itemsNeeded);
			
			
			if(itemNeededList.contains(fromattedName))
			{
				j++;	
				//CLICK on Add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==itemsNeeded.length) //we use length() method to get the size of Array but we use size() method to get the size of ArrayList 
				{
						break;
				}
			}
		}
		
		
	}
}
