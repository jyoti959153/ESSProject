package com.ESS.generic.objectreporitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
WebDriver driver;
	
	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='admin']")
	private WebElement admin;

	public WebElement getAdmin() {
		return admin;
	}
	
	@FindBy(xpath="//span[text()='Logout']")
	private WebElement logoutBtn;

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	public void logoutFromApp() throws InterruptedException {
		Thread.sleep(5000);
		admin.click();
		logoutBtn.click();
	}
	
	

}
