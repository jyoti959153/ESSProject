package com.ESS.generic.objectreporitory;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ESS.generic.fileutility.ExcelUtility;
import com.ESS.generic.webdriverutility.JavaUtility;

public class VendorProposalPage {
	WebDriver driver;

	public VendorProposalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='mainmenu commercial topmenuimage']")
	private WebElement commerceLink;

	public WebElement getCommerceLink() {
		return commerceLink;
	}
	
	@FindBy(xpath="//a[@title=\"New price request\"]")
	private WebElement newPriceRequest;

	public WebElement getNewPriceRequest() {
		return newPriceRequest;
	}
	
	@FindBy(xpath="//span[@aria-labelledby=\"select2-socid-container\"]")
	private WebElement selectTpDropdown;

	public WebElement getSelectTpDropdown() {
		return selectTpDropdown;
	}
	
	@FindBy(xpath="//input[@value=\"Create draft\"]")
	private WebElement createBtn;

	public WebElement getCreateBtn() {
		return createBtn;
	}
	
	@FindBy(xpath="//span[@class='select2-results']")
	private WebElement clickoption;
	
	public WebElement getClickoption() {
		return clickoption;
	}

	ExcelUtility eu=new ExcelUtility();
	JavaUtility ju=new JavaUtility();
	public String createvp() throws EncryptedDocumentException, IOException, InterruptedException
	{
		commerceLink.click();
		newPriceRequest.click();
		selectTpDropdown.click();
		Thread.sleep(2000);
		String data = eu.getDataFromExcel("commerce", 1, 0);
		selectTpDropdown.sendKeys(data);
		Thread.sleep(2000);
		clickoption.click();
		Thread.sleep(2000);
		createBtn.click();
		return data;
	}
	
	
}
