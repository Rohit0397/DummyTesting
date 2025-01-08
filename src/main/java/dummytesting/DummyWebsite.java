package dummytesting;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DummyWebsite {
    public String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    String driverPath = "C:\\Users\\26324\\Downloads\\chromedriver-win64\\chromedriver.exe";
    public WebDriver driver ; 
    
    @SuppressWarnings("deprecation")
	@BeforeTest
    public void launchBrowser() throws InterruptedException {
        System.out.println("launching chrome browser"); 
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver= new ChromeDriver();
        driver.get(baseUrl);
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
    }
     
  @Test(priority=0)
  public void registrationProcess() throws InterruptedException {
      
      WebElement register = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a"));
      register.click();
      
      WebElement firstName = driver.findElement(By.xpath("//*[@id=\"customer.firstName\"]"));
      firstName.sendKeys("Rohit");
      
      WebElement lastName = driver.findElement(By.xpath("//*[@id=\"customer.lastName\"]"));
      lastName.sendKeys("Kumar");
      
      WebElement address = driver.findElement(By.xpath("//*[@id=\"customer.address.street\"]"));
      address.sendKeys("Lanka");
      
      WebElement city = driver.findElement(By.xpath("//*[@id=\"customer.address.city\"]"));
      city.sendKeys("Varanasi");
      
      WebElement state = driver.findElement(By.xpath("//*[@id=\"customer.address.state\"]"));
      state.sendKeys("Uttar Pradesh");
      
      WebElement zipCode = driver.findElement(By.xpath("//*[@id=\"customer.address.zipCode\"]"));
      zipCode.sendKeys("221010");
      
      WebElement phoneNumber = driver.findElement(By.xpath("//*[@id=\"customer.phoneNumber\"]"));
      phoneNumber.sendKeys("9098899909");
      
      WebElement ssNumber = driver.findElement(By.xpath("//*[@id=\"customer.ssn\"]"));
      ssNumber.sendKeys("AAA-GG-SSSS");
      
      WebElement userName = driver.findElement(By.xpath("//*[@id=\"customer.username\"]"));
      userName.sendKeys("Rohit1197");
      
      WebElement password = driver.findElement(By.xpath("//*[@id=\"customer.password\"]"));
      password.sendKeys("12345678");
      
      WebElement confirmPassword = driver.findElement(By.xpath("//*[@id=\"repeatedPassword\"]"));
      confirmPassword.sendKeys("12345678");
      
      WebElement submit = driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"));
      submit.click();
      
      WebElement logout = driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a"));
      logout.click();
  }
  @Test(priority=1)
	  public void takeScreenshot(WebDriver driver, String fileName) throws IOException {
	      // Convert WebDriver instance to TakesScreenshot
	      TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
	
	      // Capture the screenshot and store it in a temporary file
	      File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);
	
	      // Define the destination file location
	      File destinationFile = new File("C:/Users/26324/Desktop/Cashpor Documents/Testing Documents/screenshot1.png");
	
	      // Copy the screenshot to the destination file
	      FileUtils.copyFile(screenshot, destinationFile);
	
	      System.out.println("Screenshot saved to: " + destinationFile.getAbsolutePath());
  }
  
  @Test(priority=2)
  public void loginProcess() {
	  
	  WebElement userName1 = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input"));
	  userName1.sendKeys("Rohit1197");
      
      WebElement password1 = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input"));
      password1.sendKeys("12345678");
      
      WebElement login = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input"));
      login.click();
	  
  }
}