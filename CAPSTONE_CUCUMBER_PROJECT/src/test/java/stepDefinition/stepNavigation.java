package stepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepNavigation {
	
	WebDriver driver;
    WebDriverWait wait;
    private static final String Programs_section_xpath = "//*[@id=\"menu-item-264\"]/a/span[1]";
    private static final String HOME_xpath = "//*[@id=\"menu-item-207\"]/a/span";
    
	@Given("User is on the Home page")
	public void user_is_on_the_home_page() {
			driver = new ChromeDriver();
	   	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.get("https://westfloridaahec.org/");
	}
	@When("User clicked on health program and navigated different health programs")
	public void user_clicked_on_health_program_and_navigated_different_health_programs() {
		WebElement programsLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Programs_section_xpath)));
	    programsLink.click();
	    List<WebElement> dropdownOptions = driver.findElements(By.xpath("//*[@id='menu-item-264']/ul/li/a"));   
	    for (WebElement options : dropdownOptions) {
	    	String optionText=options.getText();
	        System.out.println("Navigating to: " +  optionText+" health program");
	        wait.until(ExpectedConditions.elementToBeClickable(options));
	        options.click();
	        try {
	        	 WebElement txt1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/section/div/div/div/div/h1")));
	 	         System.out.println("Extracting Header messeage Of selected program page : "+txt1.getText());
			} catch (Exception e) {
				 WebElement txt1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"post-1479\"]/div/div[1]/div/div/div/div/h2")));
	 	         System.out.println("Extracting Header messeage Of selected program page : "+txt1.getText());
			}
	       
	        driver.navigate().back();
	        programsLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Programs_section_xpath)));
	        programsLink.click();
	       
	        
		}
	}
	@Then("User able to navigate successfully")
	public void user_able_to_navigate_successfully() {
		
		WebElement home =wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HOME_xpath)));
		home.click();
		String act_url ="https://westfloridaahec.org/";
		String expect_url =driver.getCurrentUrl();
		org.junit.Assert.assertEquals(expect_url, act_url);
		driver.quit();
	}
	
	
}
