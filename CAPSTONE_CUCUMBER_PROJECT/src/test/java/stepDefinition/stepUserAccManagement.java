package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class stepUserAccManagement {
	
	WebDriver driver;
	WebDriverWait wait;
	static String name_ver;
	static String password1;
	
	private static final String Myaccount_section_xpath = "//*[@id=\"menu-main-menu\"]/li[8]/a/span[1]";
	
	@Given("User is on the registration page")
	public void user_is_on_the_registration_page() {
		
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://westfloridaahec.org/");
		WebElement accLink = driver.findElement(By.xpath(Myaccount_section_xpath));
	 	accLink.click();
	}
	@When("User enters {string}, {string}, and {string}")
	public void user_enters_and(String email, String name, String password) {
		WebElement username_regirster = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("reg_username")));
		username_regirster.sendKeys(name);
		WebElement email_regirster = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='email']")));
		email_regirster.sendKeys(email);
		WebElement password_regirster = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"reg_password\"]")));
		password_regirster.sendKeys(password);
		name_ver=name;
		password1=password;
	}
	@When("User clicks the Register button")
	public void user_clicks_the_Register_button() {
		WebElement register = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[4]/button")));
		register.click();
	}
	@Then("A confirmation message should be displayed and logged in")
	public void a_confirmation_message_should_be_displayed_and_logged_in() {
		WebElement verifey_register = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"post-381\"]/div/div/div[1]/div[1]/span[1]")));
		Assert.assertEquals(verifey_register.getText(),"Hello "+name_ver );
	       
	}
	@Then("User should logout")
	public void user_should_logut() {
		WebElement register_logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"post-381\"]/div/div/nav/ul/li[7]/a")));
		register_logout.click();
		  
	}
	
	//---------------------------------------------------------------------
	
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.get("https://westfloridaahec.org/");
		WebElement accLink = driver.findElement(By.xpath(Myaccount_section_xpath));
	 	accLink.click();
	}
	@When("User enters {string} and {string}")
	public void user_enters_and(String name, String pass) {
		WebElement username_login = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"username\"]")));
		username_login.sendKeys(name);
		WebElement password_login = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password\"]")));
		password_login.sendKeys(pass);
	
	}
	@When("User clicks the Login button")
	public void user_clicks_the_login_button() {
		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")));
		login.click();
	}
	@Then("User should be redirected to their profile page")
	public void user_should_be_redirected_to_their_profile_page() {
		WebElement verifey_login = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"post-381\"]/div/div/div[1]/div[1]/span[1]")));
		Assert.assertEquals(verifey_login.getText(),"Hello "+name_ver );
	}
	
	@Then("An error message should be displayed")
	public void an_error_message_should_be_displayed() {
	    
		WebElement error_login = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"post-381\"]/div/div/div[1]/div")));
		Assert.assertEquals(true, error_login.isDisplayed());
	}
	
	@Then("User should be redirected to their profile page and update password and logout")
	public void user_should_be_redirected_to_their_profile_page_and_update_password_and_logout() {
		WebElement Account_details = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"post-381\"]/div/div/nav/ul/li[6]/a")));
		Account_details.click();
		WebElement password_login_current = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password_current\"]")));
		password_login_current.sendKeys(password1);
		WebElement password_login_new = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password_1\"]")));
		password_login_new.sendKeys("Sai@655143");
		WebElement password_login_confirm = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password_2\"]")));
		password_login_confirm.sendKeys("Sai@655143");
		WebElement save = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"post-381\"]/div/div/div[2]/form/p[5]/button")));
		//save.click();
		driver.navigate().back();
		WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"post-381\"]/div/div/nav/ul/li[7]/a")));
		logout.click();
	}


	
}
