package com.ESS.generic.objectreporitory;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThirdPartyPage {
	WebDriver driver;

	public ThirdPartyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='mainmenu companies topmenuimage']")
	private WebElement thirdPartyLink;

	public WebElement getThirdPartyLink() {
		return thirdPartyLink;
	}
	
	

}
