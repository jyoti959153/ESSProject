package com.ESS.generic.objectreporitory;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ESS.generic.fileutility.ExcelUtility;
import com.ESS.generic.webdriverutility.JavaUtility;

public class WarehousePage {
	WebDriver driver;

	public WarehousePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//div[@class='mainmenu products topmenuimage']")
	private WebElement productserviceLink;

	public WebElement getProductserviceLink() {
		return productserviceLink;
	}

	@FindBy(xpath = "//a[text()='New warehouse']")
	private WebElement newWarehouseLink;

	public WebElement getNewWarehouseLink() {
		return newWarehouseLink;
	}

	@FindBy(xpath = "//input[@name='libelle']")
	private WebElement refTf;

	public WebElement getRefTf() {
		return refTf;
	}

	@FindBy(xpath = "//input[@value=\"Create\"]")
	private WebElement createBtn;

	public WebElement getCreateBtn() {
		return createBtn;
	}

	ExcelUtility eu=new ExcelUtility();
	JavaUtility ju=new JavaUtility();
	
	public String createWarehousemethod() throws EncryptedDocumentException, IOException {
		productserviceLink.click();
		newWarehouseLink.click();
		ExcelUtility eu = new ExcelUtility();
		String data=eu.getDataFromExcel("Warehouse", 1, 0)+ju.getRandomNumber();
		refTf.sendKeys(data, Keys.TAB);
		createBtn.click();
		return data;
	}

}
