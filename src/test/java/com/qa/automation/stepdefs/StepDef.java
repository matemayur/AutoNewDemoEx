package com.qa.automation.stepdefs;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.automation.PageObjectFile.HeaderSecPageObjectFile;
import com.qa.automation.PageObjectFile.LandingPageObjFile;
import com.qa.automation.PageObjectFile.SignupLoginPOMFile;
import com.qa.automation.core.WebDriverFacotry;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	
private static final Logger logger = LogManager.getLogger(StepDef.class);
	
	private WebDriver driver;
	Scenario scn;
	String baseUrl = "https://automationexercise.com/";
	int implictlyWaitTimeoutSec = 20;
	
	
	LandingPageObjFile landingPageObjFile;
	HeaderSecPageObjectFile headerSecPageObjectFile;
	SignupLoginPOMFile signupLoginPOMFile;
	
	@Before
	public void setUp(Scenario scn) throws Exception
	{
		this.scn = scn;
		String browserName = WebDriverFacotry.getBrowserName();
		driver = WebDriverFacotry.setUpBrowser(browserName);
		scn.log("browser get invoked");
		landingPageObjFile = new LandingPageObjFile(driver);
		headerSecPageObjectFile = new HeaderSecPageObjectFile(driver);
		signupLoginPOMFile = new SignupLoginPOMFile(driver);
		
		
	}
	
	
	@After(order=1)
	public void cleanUp()
	{
		WebDriverFacotry.quitDriver();
		scn.log("browser get closed");
	}
	
	@After(order=2)
	public void takescreenshot(Scenario scn)
	{
		WebDriverFacotry.failedScnScreenshot(scn);
	}
	
	
	@Given("user navigate to the home application url {string}")
	public void user_navigate_to_the_home_application_url(String url) {
	    
		WebDriverFacotry.setURL(url);
	}
	
	
	//////////////////////////////
	
	@Given("user able to see application logo is displayed")
	public void user_able_to_see_application_logo_is_displayed() {
	   
		landingPageObjFile.verifyApplicationLogo();
		logger.info("Application logo is displayed");
	}


	@Then("user see the following option are available on header section")
	public void user_see_the_following_option_are_available_on_header_section(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //io.cucumber.datatable.DataTable dataTable
	    // For other transformations you can register a DataTableType.
		
//		List<Map<String,String>> headerSectionList = dataTable.asMaps(String.class, String.class);
//		for(int i = 0; i < headerSectionList.size(); i++)
//		{
//			System.out.println(headerSectionList.get(i).get("HeaderListName"));
//			System.out.println(headerSectionList.get(i).get("HeaderBtnPageTitle"));
//		}
		
		landingPageObjFile.verifyHeaderSecBtnList(dataTable);
		
	}
	
	/////////////////////////////////////


	@Given("user verify the home page is visible successfully")
	public void user_verify_the_home_page_is_visible_successfully() {              //ul[@class='nav navbar-nav']
	   
		landingPageObjFile.homePageTitle();
		logger.info("user verify the home page title");
	}
	
	
	@Given("user is able to click on Product button")
	public void user_is_able_to_click_on_product_button() {
	   
		landingPageObjFile.clickProductsBtn();
		logger.info("user click on product button");
	}
	
	
	@When("user is redirected to the product page title as {string}")
	public void user_is_redirected_to_the_product_page_title_as(String ProdPageTitle) {
	   
		landingPageObjFile.validateProdPageTitle(ProdPageTitle);
		 logger.info("user verify the product page title");
	}
	
	@Then("user is able to click on Cart button")
	public void user_is_able_to_click_on_cart_button() {
	   
		landingPageObjFile.clickCartBtn();
	    logger.info("user click on cart button"); 
	}
	
	
	@Then("user able on cart page title as {string}")
	public void user_able_on_cart_page_title_as(String CartPageTitle) {
	  
		headerSecPageObjectFile.verifycartPageTitle(CartPageTitle);
		logger.info("user verify the cart page title");
	}
	
	@Then("user is able to click on signup\\/login button")
	public void user_is_able_to_click_on_signup_login_button() {
	   
		landingPageObjFile.clickSignUpOrLoginBtn();
		 logger.info("user click on signup/login button");
	}
	
	@Then("user over the signup\\/login page with title as {string}")
	public void user_over_the_signup_login_page_with_title_as(String signUpPageTitle) {
	   
		signupLoginPOMFile.verifySignUpPageTitle(signUpPageTitle);
	    logger.info("user verify the signup page title");
	}
	
	@Then("user is able to Click on test cases button")
	public void user_is_able_to_click_on_test_cases_button() {
	   
		landingPageObjFile.clickTestCasesBtn();
	    logger.info("user click on test cases button");
	}
	
	@Then("user is able over the test cases title as {string}")
	public void user_is_able_over_the_test_cases_title_as(String TCasesPageTitle) {
	   
		headerSecPageObjectFile.verifyTestCasesPage(TCasesPageTitle);
	    logger.info("user verify the test cases page title");
	}
	
	@When("user click on API Testing button")
	public void user_click_on_api_testing_button() {
	   
		landingPageObjFile.clickAPITestingBtn();
		logger.info("user click on API testing button");
	}
	
	@Then("User verify the {string} text is visible")
	public void user_verify_the_text_is_visible(String apiTestingList) {
	    
		headerSecPageObjectFile.verifyAPITestingPage(apiTestingList);
	    logger.info("user verify" + apiTestingList + "text is available");
	}
	
	@Then("user is click on contact us button")
	public void user_is_click_on_contact_us_button() {
	   
		landingPageObjFile.clickContactUsBtn();
		logger.info("user click on contact us button");
	}
	
	@Then("user able to see contact us page title as {string}")
	public void user_able_to_see_contact_us_page_title_as(String ContactUsPageTitle) {
	    
		headerSecPageObjectFile.verifycontactUsPageTitle(ContactUsPageTitle);
		logger.info("user verify contact us page title");
		
	}
	
	// Test cases for subscription fields
	
	
	@Given("User Scroll down to footer of the page")
	public void user_scroll_down_to_footer_of_the_page() {
	    
		landingPageObjFile.userscrollDownPage();
		logger.info("user scroll down the page");
	}



	@When("After scrooling down user is able to see {string} keyword")
	public void after_scrooling_down_user_is_able_to_see_keyword(String SUBSCRIPTION) {
	    
		landingPageObjFile.verifySubscriptionTxt(SUBSCRIPTION);
	      logger.info("user verify the SUBSCRIPTION text");
	}
	
	
	@When("user enter email address as {string} in box")
	public void user_enter_email_address_as_in_box(String emailForSubscription) {
	   
		landingPageObjFile.enterEmailForSubscription(emailForSubscription);
	    logger.info("user enter email for subscription");
	}
	
	
	@When("user click on arrow button")
	public void user_click_on_arrow_button() {
	   
		landingPageObjFile.clickArrowBtn();
		  logger.info("user click on arrow button");
	}
	
	
	@Then("user Verify success message {string} is visible on Display")
	public void user_verify_success_message_is_visible_on_display(String SubscriptionsuccessMsg) {
	    
		landingPageObjFile.verifySubscriptionSuccessMsg(SubscriptionsuccessMsg);

		   logger.info("user verify the subscription success msg");
		
	}
	
	
	// for error email and password section
	
	
	
	@Given("user click on signup\\/Login button")
	public void user_click_on_signup_login_button() {
	   
		landingPageObjFile.clickSignUpOrLoginBtn();
		logger.info("user click on signup/Login button");
		
	}


	@When("user redirected to signup\\/login page title as {string}")
	public void user_redirected_to_signup_login_page_title_as(String signupLogPagetitle) {
	   
		signupLoginPOMFile.verifySigLogPageTitle(signupLogPagetitle);
	    logger.info("user verify signupLogin page title");
	}
	
	
	@Then("user able to visible text as {string}")
	public void user_able_to_visible_text_as(String LoginToYourAccount) {
	    
		signupLoginPOMFile.verifyLoginToYourAcText(LoginToYourAccount);
		 logger.info("user able to visible Login to your acc txt");
	}
	
	
	@Then("user enter emailId {string}")
	public void user_enter_email_id(String emailIdLogin) {
	   
		signupLoginPOMFile.verifyEmailIdLogin(emailIdLogin);
		logger.info("user put invalid EmailID");
	}
	
	
	@Then("user enter password {string}")
	public void user_enter_password(String PasswordLogin) {
	    
		signupLoginPOMFile.verifyPassLogin(PasswordLogin);
		 logger.info("user put invalid password");
		
	}
	
	
	@Then("user click on login button")
	public void user_click_on_login_button() {
	    
		signupLoginPOMFile.verifyClickOnLoginBtn();
	    logger.info("user click on login button");
	}
	
	
	@Then("emailId and password is invalid the user able to see error message as {string}")
	public void email_id_and_password_is_invalid_the_user_able_to_see_error_message_as(String ErrorMsgVisible) {
	   
		signupLoginPOMFile.ValidateErrorMsgVisible(ErrorMsgVisible);
		logger.info("user able to visible error message");
		
	}
	
	
	// test cases on valid emailID n password users
	
	@Given("user click to signup\\/login button")
	public void user_click_to_signup_login_button() {
	   
		landingPageObjFile.verifySinupLoginButton();
		logger.info("user able to click on signup/login btn");
	}



	@When("user redirected to login page with title as {string}")
	public void user_redirected_to_login_page_with_title_as(String SignLoginPageTitle) {
	   
		signupLoginPOMFile.VerifySingLoginPageTitle(SignLoginPageTitle);
		logger.info("user verify the signup/login page title");
	}
	
	
	@Then("user able to see the text {string}")
	public void user_able_to_see_the_text(String LoginToYourAccount) {
	    
		signupLoginPOMFile.verifyLoginToYourAccountText(LoginToYourAccount);
		logger.info("user able to visible login acc text");
	}
	
	
	@Then("user enter email id as {string}")
	public void user_enter_email_id_as(String EmailIdforLogin) {
	    
		signupLoginPOMFile.verifyEmail(EmailIdforLogin);
		logger.info("user enter the valid emailID");
	}
	
	
	@Then("user enter password as {string}")
	public void user_enter_password_as(String PasswordForLoginPurpose) {
	    
		signupLoginPOMFile.verifyPassword(PasswordForLoginPurpose);
		logger.info("user enter the valid Password");
	}
	
	
	@Then("user verify with {string} just after Logged in as button")
	public void user_verify_with_just_after_logged_in_as_button(String username) {
	    
		landingPageObjFile.userNameAfterLoggedIn(username);
		 logger.info("user verify username after logged in - "+ username);
	}
	
	@Then("user click on logout button")
	public void user_click_on_logout_button() {
	   
		landingPageObjFile.userClickOnLogoutBtn();
		logger.info("user click on logout btn");
	}
	

}
