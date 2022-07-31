package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actiondrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();//to Have MDV setup Chrome
		ChromeDriver driver = new ChromeDriver();// Initiating Chrome Driver
		driver.get("https://jqueryui.com/droppable/");// Launch Browser
		driver.manage().window().maximize(); //Maximize browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //setting implicit wait
		
		driver.switchTo().frame(0);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		
		String text = drop.getText();
		
		System.out.println(text);
		
		Actions builder = new Actions(driver);		
					
		builder.dragAndDrop(drag, drop).perform();
		
     	
		String text1 = drop.getText();
		
		System.out.println(text1);
	}
	

}
