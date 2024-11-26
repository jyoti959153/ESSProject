package com.ESS.generic.objectreporitory;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ESS.generic.fileutility.ExcelUtility;
import com.ESS.generic.webdriverutility.JavaUtility;

public class SalesOrderPage {
	WebDriver driver;

	public SalesOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='mainmenu commercial topmenuimage']")
	private WebElement commerceLink;

	public WebElement getCommerceLink() {
		return commerceLink;
	}
	
	@FindBy(xpath="(//a[text()='New order'])[1]")
	private WebElement newSalesOrderLink;

	public WebElement getNewSalesOrderLink() {
		return newSalesOrderLink;
	}
	
	@FindBy(xpath="//input[@name='ref_client']")
	private WebElement refCustomerTf;

	public WebElement getRefCustomerTf() {
		return refCustomerTf;
	}
	
	@FindBy(xpath="//span[@aria-labelledby=\"select2-socid-container\"]")
	private WebElement selectTpDropdown;

	public WebElement getSelectTpDropdown() {
		return selectTpDropdown;
	}
	
	@FindBy(xpath="//span[@class='select2-results']")
	private WebElement clickoption;

	public WebElement getClickoption() {
		return clickoption;
	}
	
	@FindBy(xpath="//input[@id=\"re\"]")
	private WebElement calender;

	public WebElement getCalender() {
		return calender;
	}

	@FindBy(xpath="//input[@value=\"Create draft\"]")
	private WebElement createBtn;
	public WebElement getCreateBtn() {
		return createBtn;
	}
	public void setCalender(WebElement calender) {
		this.calender = calender;
	}
	
	ExcelUtility eu=new ExcelUtility();
	JavaUtility ju=new JavaUtility();
	
	public void createDraft() throws EncryptedDocumentException, IOException, InterruptedException
	{
		commerceLink.click();
		Thread.sleep(2000);
		newSalesOrderLink.click();
		Thread.sleep(2000);
		refCustomerTf.sendKeys(eu.getDataFromExcel("Sales order", 1, 0)+ju.getRandomNumber());
		Thread.sleep(2000);
		selectTpDropdown.click();
		Thread.sleep(2000);
		selectTpDropdown.sendKeys(eu.getDataFromExcel("Sales order", 1, 1)+ju.getRandomNumber());
		Thread.sleep(2000);
		clickoption.click();
		Thread.sleep(2000);
		createBtn.click();
		
	}
	

}
