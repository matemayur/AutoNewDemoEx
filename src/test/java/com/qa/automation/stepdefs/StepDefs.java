package com.qa.automation.stepdefs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.qa.automation.core.WebDriverFacotry;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {
	
private static final Logger logger = LogManager.getLogger(StepDefs.class);
	
	private WebDriver driver;
	Scenario scn;
	String baseUrl = "https://automationexercise.com/";
	int implictlyWaitTimeoutSec = 20;
	
	@Before
	public void setUp(Scenario scn) throws Exception
	{
		this.scn = scn;
		String browserName = WebDriverFacotry.getBrowserName();
		driver = WebDriverFacotry.setUpBrowser(browserName);
		scn.log("browser get invoked");
	}
	
	@Given("user navigate to the home application url {string}")
	public void user_navigate_to_the_home_application_url(String url) {
		
		WebDriverFacotry.setURL(url);
	}



	@Given("user verify the home page is visible successfully")
	public void user_verify_the_home_page_is_visible_successfully() {
	   
	}
	
	
	@Given("user is able to click on Product button")
	public void user_is_able_to_click_on_product_button() {
	   
	}
	
	
	@When("user is redirected to the product page title as {string}")
	public void user_is_redirected_to_the_product_page_title_as(String string) {
	    
	}
	
	
	@Then("user is able to click on Cart button")
	public void user_is_able_to_click_on_cart_button() {
	   
	}
	
	
	@Then("user able on cart page title as {string}")
	public void user_able_on_cart_page_title_as(String string) {
	   
	}
	
	
	@Then("user is able to click on signup\\/login button")
	public void user_is_able_to_click_on_signup_login_button() {
	   
	}
	
	
	@Then("user over the signup\\/login page with title as {string}")
	public void user_over_the_signup_login_page_with_title_as(String string) {
	   
	}
	
	
	@Then("user is able to Click on test cases button")
	public void user_is_able_to_click_on_test_cases_button() {
	   
	}
	
	
	@Then("user is able over the test cases title as {string}")
	public void user_is_able_over_the_test_cases_title_as(String string) {
	    
	}
	
	
	@When("user click on API Testing button")
	public void user_click_on_api_testing_button() {
	    
	}
	
	
	@Then("User verify the {string} text is visible")
	public void user_verify_the_text_is_visible(String string) {
	   
	}
	
	
	@Then("user is click on contact us button")
	public void user_is_click_on_contact_us_button() {
	   
	}
	
	
	@Then("user able to see contact us page title as {string}")
	public void user_able_to_see_contact_us_page_title_as(String string) {
	    
	}

}
