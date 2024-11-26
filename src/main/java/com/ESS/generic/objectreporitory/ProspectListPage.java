package com.ESS.generic.objectreporitory;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ESS.generic.fileutility.ExcelUtility;
import com.ESS.generic.webdriverutility.JavaUtility;

public class ProspectListPage {
	WebDriver driver;

	public ProspectListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='mainmenu companies topmenuimage']")
	private WebElement thirdPartyLink;

	public WebElement getThirdPartyLink() {
		return thirdPartyLink;
	}

	@FindBy(xpath = "//a[text()='List of Prospects']")
	private WebElement prospectList;
	

	public WebElement getProspectList() {
		return prospectList;
	}

	@FindBy(xpath = "//input[@name=\"search_nom\"]")
	private WebElement searchTpTf;

	public WebElement getSearchTpTf() {
		return searchTpTf;
	}
	
	@FindBy(xpath = "//span[@class=\"fas fa-search\"]")
	private WebElement searchIcon;

	public WebElement getSearchIcon() {
		return searchIcon;
	}
	
	ExcelUtility eu=new ExcelUtility();
	JavaUtility ju=new JavaUtility();
	
	public String searchInList() throws EncryptedDocumentException, IOException
	{
		thirdPartyLink.click();
		prospectList.click();
		String data = eu.getDataFromExcel("Prospect", 1, 0)+ju.getRandomNumber();
		searchTpTf.sendKeys(data);
		searchIcon.click();
		return data;
	}

}
