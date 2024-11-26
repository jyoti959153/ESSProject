package com.ESS.generic.objectreporitory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="username")
	private WebElement loginTf;

	public WebElement getLoginTf() {
		return loginTf;
	}

    @FindBy(id="password")
    private WebElement passwordTf;

	public WebElement getPasswordTf() {
		return passwordTf;
	}
	
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBtn;

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	public void loginToApp(String username,String password)
	{
		loginTf.sendKeys(username);	
		passwordTf.sendKeys(password);
		loginBtn.click();
	}
    
	
	
	
	

}
