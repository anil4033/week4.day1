package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
	
	/*
	 * 
	 * 1) Open the chrome 
       2) Login to leaftaps 
       3) Click CRM/SFA link 
       4) Click Leads Link 
       5) Click Merge Leads Link 
       6) Click the icon following the from lead 
       7) Switch to new window 
       8) Enter the first name as Babu 
       9) Click Find Leads Button 
      10) Click on the first resulting lead 
      11) Move the control back to first window
	 */

	public static void main(String[] args) throws InterruptedException {
		//to call WDM for driver
		WebDriverManager.chromedriver().setup();
				
		//Launch browser		
		
		ChromeDriver driver = new ChromeDriver();
		
		//Load URL
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//Maximize browser
		
		driver.manage().window().maximize();		
		
		//Enter Username and Password
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click Login button
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		  //Click on CRMSFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		 // Click on Leads Button
		driver.findElement(By.linkText("Leads")).click();
		
		//Click Merge Leads Link 
		driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();
		
		//6) Click the icon following the from lead
		driver.findElement(By.xpath("//span[text()='From Lead']/following::td/a")).click();
		
		//7) Switch to new window 
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("how many handels" + windowHandles.size());
		
		//convert set to list to access though index to get second handle
		List<String> lstWindowHandels = new ArrayList<String>(windowHandles);
		String secondWinHan = lstWindowHandels.get(1);
		String firstwinHan = lstWindowHandels.get(0);
		System.out.println("Second window handle is "+ secondWinHan);
		
		//switch control to new window
		driver.switchTo().window(secondWinHan);
		
		//8) Enter the first name as Babu 
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Babu");
				
		//9) Click Find Leads Button 
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(1000);
		//10) Click on the first resulting lead 
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		//11) Move the control back to first window
		driver.switchTo().window(firstwinHan);
		
		String title = driver.getTitle();
		
		System.out.println(title);

	}

}
