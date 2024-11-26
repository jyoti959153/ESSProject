package EssTestcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.slf4j.helpers.Reporter;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ESS.generic.fileutility.ExcelUtility;
import com.ESS.generic.objectreporitory.WarehousePage;

import BaseClass1.BaseTest1;

@Listeners(com.ESS.generic.listenerutility.ListenerImplementClass.class)
public class CreateWarehouseTest extends BaseTest1 {
	@Test(groups="integrationTest")
	public void cw() throws EncryptedDocumentException, IOException {
		WarehousePage wp = new WarehousePage(driver);
		String expectedWarehouse = wp.createWarehousemethod();

		ExcelUtility eu = new ExcelUtility();

		System.out.println("expected:" + expectedWarehouse);
		String actualWarehouse = driver.findElement(By.xpath("//div[(text()='"+expectedWarehouse+"')]")).getText();
		//String actualWarehouse = driver.findElement(RelativeLocator.with(By.xpath("//div[text()='Short name of location :']")).above(By.xpath("//div[(text()='" + expectedWarehouse + "')]"))).getText();
		System.out.println("Actual:" + actualWarehouse);
		boolean result = actualWarehouse.contains(expectedWarehouse);
		Assert.assertEquals(result, true);
	}

}
