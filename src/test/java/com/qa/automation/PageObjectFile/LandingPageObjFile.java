package com.qa.automation.PageObjectFile;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.automation.core.JavaScriptExecutor;

import io.cucumber.java.Scenario;

public class LandingPageObjFile {
	
	private WebDriver driver;
	 private WebDriverWait wait;
	 Scenario scn;
	 JavaScriptExecutor javaScriptExecutorUtil;
	 
	 
	
	public LandingPageObjFile(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,15);
		javaScriptExecutorUtil = new JavaScriptExecutor(driver);
		
		
	}
	
	
	//Private Locators
	 private By prodBtn = By.xpath("//a[text()=' Products']");
	 private By cartBtn = By.xpath("//a[text()=' Cart']");
	 private By testCasesBtn = By.xpath("//a[text()=' Test Cases']");
	 private By signUpBtn = By.xpath("//a[text()=' Signup / Login']");
	 private By APITestingBtn = By.xpath("//a[text()=' API Testing']");
	 private By VideoTutorialBtn = By.xpath("//a[text()=' Video Tutorials']");
	 private By ContactUsBtn = By.xpath(" //a[text()=' Contact us']");
	 private By subscriptionText = By.xpath("//h2[text()='Subscription']");
	 private By emailSubscription = By.xpath("//input[@id='susbscribe_email']");
	 private By arrowBtn = By.xpath("//button[@id='subscribe']");
	 private By successTxt = By.xpath("//div[text()='You have been successfully subscribed!']");
	 
	 private By signupLogBtn = By.xpath("//a[text()=' Signup / Login']");
	 
	 private By signupLoginBtn = By.xpath(" //a[@href='/login']");
	 
	 private By loggedInUserName = By.xpath("//a[text()= ' Logged in as ']/b");
	 private By LogoutBtn = By.xpath("//a[text()=' Logout']");
	 
	 private By pageLogo =  By.xpath("//img[@alt='Website for automation practice']");
	 
	 private By actHederBtnNameList = By.xpath("//ul[@class='nav navbar-nav']/li/a");
	
	
	//Public Methods
	 public void homePageTitle()
	 {
		 String expectedTitle = "Automation Exercise";
		   String actualTitle = driver.getTitle();
		   Assert.assertEquals(expectedTitle, actualTitle);
	 }
	 
	 
	 public void verifyApplicationLogo()
	 {
		 WebElement pageLogoEle = driver.findElement(pageLogo);
		 Assert.assertEquals(true, pageLogoEle.isDisplayed());
	 }
	 
	 
	 
	 public void verifyHeaderSecBtnList(List<String> HeaderNameList)
	 {
		 List<String> headerSectionList = HeaderNameList;
		 List<WebElement> actHederBtnNameListEle = driver.findElements(actHederBtnNameList);
				 for(int i = 0; i < headerSectionList.size(); i++)
			{
				Assert.assertEquals(true, actHederBtnNameListEle.get(i).getText().contains(headerSectionList.get(i)));
				
			}
	 }
	 
	 
	 public void clickProductsBtn()
	 {
		 WebElement prodBtnEle = driver.findElement(prodBtn);
		 wait.until(ExpectedConditions.visibilityOf(prodBtnEle));
		 prodBtnEle.click();
	 }
	 
	 
	 public void validateProdPageTitle(String prodPageTitle)
		{
			Assert.assertEquals(true, driver.getTitle().contains(prodPageTitle));
		}
	 
	 
	 
	 public void clickCartBtn()
	 {
		 WebElement cartBtnEle = driver.findElement(cartBtn);
		 wait.until(ExpectedConditions.visibilityOf(cartBtnEle));
		 cartBtnEle.click();
	 }
	 
	 public void clickSignUpOrLoginBtn()
	 {
		 WebElement signupBtnEle = driver.findElement(signUpBtn);
		 signupBtnEle.click();
	 }
	 
	 public void clickTestCasesBtn()
	 {
		 WebElement testCasesBtnEle = driver.findElement(testCasesBtn);
		 testCasesBtnEle.click();
	 }
	 
	 public void clickAPITestingBtn()
	 {
		 WebElement APITestingBtnEle = driver.findElement(APITestingBtn);
		 APITestingBtnEle.click();
	 }
	 
	 public void clickOnVideoTutorialBtn()
	 {
		 WebElement VideoTutorialBtnEle = driver.findElement(VideoTutorialBtn);
		 VideoTutorialBtnEle.click();
	 }
	 
	 public void clickContactUsBtn()
	 {
		 WebElement ContactUsBtnEle = driver.findElement(ContactUsBtn);
		 ContactUsBtnEle.click();
	 }
	 
	 
	 public void userscrollDownPage()
	 {
		 JavaScriptExecutor javaScriptExecutor = new JavaScriptExecutor(driver);
		 javaScriptExecutor.scrollPageDown();
	 }
	 
	 
	 public void verifySubscriptionTxt(String SUBSCRIPTION)
	 {
			WebElement subscriptionTxtEle = driver.findElement(subscriptionText);
			wait.until(ExpectedConditions.visibilityOf(subscriptionTxtEle));
			Assert.assertEquals(SUBSCRIPTION, subscriptionTxtEle.getText());
	 }
	 
	 
	 public void enterEmailForSubscription(String emailForSubscription)
	 {
			WebElement EmailForSubscriptionEle = driver.findElement(emailSubscription);
			EmailForSubscriptionEle.sendKeys(emailForSubscription);
	 }
	 
	 
	 public void clickArrowBtn()
	 {
			WebElement arrowBtnEle = driver.findElement(arrowBtn);
			arrowBtnEle.click();
	 }
	 
	 
	 public void verifySubscriptionSuccessMsg(String SubscriptionsuccessMsg)
	 {
			WebElement successMsgEle = driver.findElement(successTxt);
			Assert.assertEquals(SubscriptionsuccessMsg, successMsgEle.getText());
	 }
	 
	 
	 public void clickOnsignupLoginBtn()
	 {
		 WebElement signupLogBtnEle = driver.findElement(signupLogBtn);
		 signupLogBtnEle.click();
	 }
	 
	 
	 public void verifySinupLoginButton()
	 {
			WebElement clickOnLoginBtnEle = driver.findElement(signupLoginBtn);
			clickOnLoginBtnEle.click();
	 }
	 
	 
	 public void userNameAfterLoggedIn(String username)
	 {
		 WebElement loggedInUserNameTxtEle = driver.findElement(loggedInUserName);
		 Assert.assertEquals(username,loggedInUserNameTxtEle.getText().trim());
	 }
	 
	 
	 
	 public void userClickOnLogoutBtn()
	 {
		 WebElement logoutBtnEle = driver.findElement(LogoutBtn);
		 logoutBtnEle.click();
	 }

}
