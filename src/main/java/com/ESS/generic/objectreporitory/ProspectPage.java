package com.ESS.generic.objectreporitory;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ESS.generic.fileutility.ExcelUtility;
import com.ESS.generic.webdriverutility.JavaUtility;

public class ProspectPage {
	WebDriver driver;

	public ProspectPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getThirdPartyLink() {
		return thirdPartyLink;
	}

	@FindBy(xpath = "//div[@class='mainmenu companies topmenuimage']")
	private WebElement thirdPartyLink;

	@FindBy(xpath = "//a[text()='New Prospect']")
	private WebElement newProspectLink;

	public WebElement getNewProspectLink() {
		return newProspectLink;
	}

	@FindBy(xpath = "//input[@id='name']")
	private WebElement ThirdPartyName;

	public WebElement getThirdPartyName() {
		return ThirdPartyName;
	}

	@FindBy(xpath = "//span[@aria-labelledby='select2-customerprospect-container']")
	private WebElement prospectDropdown;

	public WebElement getProspectDropdown() {
		return prospectDropdown;
	}

	@FindBy(xpath = "//span[@aria-labelledby='select2-fournisseur-container']")
	private WebElement vendorDropdown;

	public WebElement getVendorDropdown() {
		return vendorDropdown;
	}

	@FindBy(xpath = "//span[@aria-labelledby='select2-status-container']")
	private WebElement statusDropdown;

	public WebElement getStatusDropdown() {
		return statusDropdown;
	}

	@FindBy(xpath = "//input[@value=\"Create third party\"]")
	private WebElement createBtn;

	public WebElement getCreateBtn() {
		return createBtn;
	}

	ExcelUtility eu = new ExcelUtility();
	JavaUtility ju=new JavaUtility();

	public String createNewProspect() throws EncryptedDocumentException, IOException {
		thirdPartyLink.click();
		newProspectLink.click();
		String data=eu.getDataFromExcel("Prospect", 1, 0)+ju.getRandomNumber();
		ThirdPartyName.sendKeys(data,Keys.TAB);
		prospectDropdown.click();
		prospectDropdown.sendKeys(eu.getDataFromExcel("Prospect", 1, 1),Keys.TAB);
		vendorDropdown.click();
		vendorDropdown.sendKeys(eu.getDataFromExcel("Prospect", 2, 2),Keys.TAB);
		statusDropdown.click();
		statusDropdown.sendKeys(eu.getDataFromExcel("Prospect", 2, 3),Keys.TAB);
		createBtn.click();
		return data;

	}
	
	@FindBy(xpath="//a[text()='New Customer']")
	private WebElement newCustomerLink;
	
	public WebElement getNewCustomerLink() {
		return newCustomerLink;
	}

	public void setNewCustomerLink(WebElement newCustomerLink) {
		this.newCustomerLink = newCustomerLink;
	}

	public String createTpCustomer() throws EncryptedDocumentException, IOException
	{
		thirdPartyLink.click();
		newCustomerLink.click();
		String data=eu.getDataFromExcel("Prospect", 1, 0)+ju.getRandomNumber();
		ThirdPartyName.sendKeys(data);
		prospectDropdown.sendKeys(eu.getDataFromExcel("Prospect", 3, 1),Keys.TAB);
		createBtn.click();
		return data;
		
	}
	
	@FindBy(xpath="//a[text()='List of Prospects']")
	private WebElement list;
	
	public WebElement getList() {
		return list;
	}
	
	@FindBy(xpath="//input[@name=\"search_nom\"]")
	private WebElement searchtpTf;

	public WebElement getSearchtpTf() {
		return searchtpTf;
	}
	
	@FindBy(xpath="//a[text()='+data+']")
	private WebElement verifyingProspect;

	public WebElement getVerifyingProspect() {
		return verifyingProspect;
	}

	public String verifyProspectInList() throws EncryptedDocumentException, IOException
	{
		thirdPartyLink.click();
		list.click();
		String data=eu.getDataFromExcel("Prospect", 1, 0)+ju.getRandomNumber();
		ThirdPartyName.sendKeys(data);
		searchtpTf.sendKeys(data,Keys.ENTER);
		System.out.println(verifyingProspect.getText());
		
		return data;
	
	}

}
