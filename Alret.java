package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alret {
	
	//Click Prompt box and Handel the alert

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();//to Have MDV setup Chrome
		ChromeDriver driver = new ChromeDriver();// Initiating Chrome Driver
		driver.get("https://leafground.com/pages/Alert.html");// Launch Browser
		driver.manage().window().maximize(); //Maximize browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //setting implicit wait
		
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		
		Alert alert = driver.switchTo().alert();
		
		String text = alert.getText();
		
		System.out.println(text);
				
		alert.accept();
		
		//String text2 = driver.findElement(By.xpath("//button[text()='Prompt Box']/following::p")).getText();
		String text2 = driver.findElement(By.id("result1")).getText();		
		System.out.println(text2);
		
	}

}
