package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame {

	public static void main(String[] args) {
		
		/*1_ Open Chrome 
          2_ Load https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm 
          3_ Click TryIt (not: this is inside frame) 
          4_ Click Cancel on the alert 
          5_ Print the resulting text
          
          https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm
*/
		WebDriverManager.chromedriver().setup();//to Have MDV setup Chrome
		ChromeDriver driver = new ChromeDriver();// Initiating Chrome Driver
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");// Launch Browser
		driver.manage().window().maximize(); //Maximize browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //setting implicit wait

		//going inside frame
		//driver.switchTo().frame("iframeResult");
		driver.switchTo().frame(2);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		Alert alert = driver.switchTo().alert();
		
		alert.dismiss();	
			
		String text = driver.findElement(By.xpath("//p[text()='You pressed Cancel!']")).getText();
		
		System.out.println(text);
		
	}

}
