package com.ESS.generic.objectreporitory;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ESS.generic.fileutility.ExcelUtility;
import com.ESS.generic.webdriverutility.JavaUtility;
import com.ESS.generic.webdriverutility.WebDriverUtility;

public class ProductPage { 
	WebDriver driver;
    public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
    WebDriverUtility wu=new WebDriverUtility();
    ExcelUtility eu=new ExcelUtility();

	public WebElement getProductserviceLink() {
		return productserviceLink;
	}

	@FindBy(xpath = "//div[@class=\"mainmenu products topmenuimage\"]")
	private WebElement productserviceLink;

	@FindBy(xpath = "//a[text()='New product']")
	private WebElement newProductLink;

	public WebElement getNewProductLink() {
		return newProductLink;
		
	}
	
	@FindBy(id="ref")
	private WebElement productRefTf;

	
	
	@FindBy(name="label")
	private WebElement labelTf;

	public WebElement getLabelTf() {
		return labelTf;
	}

	public WebElement getProductRefTf() {
		return productRefTf;
	}
	
	public void selectStatusSell(WebElement element,String s1,String s2,String s3,String s4) {
		wu.selectBasedOnVisibleText(element, s1);
	}
	
	@FindBy(xpath="//span[@aria-labelledby='select2-statut-container']")
	private WebElement statusSellDropdown;
	
	
	@FindBy(xpath="//input[@aria-controls='select2-statut-results']")
	private WebElement statusSellsearch;
	
	public WebElement getStatusSellsearch() {
		return statusSellsearch;
	}

	public void setStatusSellsearch(WebElement statusSellsearch) {
		this.statusSellsearch = statusSellsearch;
	}

	public WebElement getStatusPurchaseSearch() {
		return statusPurchaseSearch;
	}

	public void setStatusPurchaseSearch(WebElement statusPurchaseSearch) {
		this.statusPurchaseSearch = statusPurchaseSearch;
	}

	public WebElement getStatusSellDropdown() {
		return statusSellDropdown;
	}

	@FindBy(xpath="//span[@aria-labelledby='select2-statut_buy-container']")
	private WebElement statusPurchaseDropdown;

	public WebElement getStatusPurchaseDropdown() {
		return statusPurchaseDropdown;
	}
	
	@FindBy(xpath="//input[@aria-controls='select2-statut_buy-results']")
	private WebElement statusPurchaseSearch;
	
	@FindBy(name="add")
	private WebElement createBtn;

	public WebElement getCreateBtn() {
		return createBtn;
	}

	public String createProduct() throws EncryptedDocumentException, IOException, InterruptedException
	{
		productserviceLink.click();
		newProductLink.click();
		JavaUtility ju=new JavaUtility();
		String data = eu.getDataFromExcel("Product", 1, 0)+ju.getRandomNumber();
		productRefTf.sendKeys(data);
		labelTf.sendKeys(eu.getDataFromExcel("Product", 1, 1)+ju.getRandomNumber());
		Thread.sleep(5000);
		statusSellDropdown.click();
		statusSellsearch.sendKeys(eu.getDataFromExcel("Product", 1, 3),Keys.TAB);
		Thread.sleep(5000);
	
		statusPurchaseDropdown.click();
		statusPurchaseSearch.sendKeys(eu.getDataFromExcel("Product", 2, 3),Keys.TAB);
		createBtn.click();
		return data;
	}
	
	
	
}
