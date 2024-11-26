package EssTestcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ESS.generic.fileutility.ExcelUtility;
import com.ESS.generic.objectreporitory.ProspectPage;

import BaseClass1.BaseTest1;

@Listeners(com.ESS.generic.listenerutility.ListenerImplementClass.class)
public class AddThirdPartyTest extends BaseTest1 {
	@Test(groups="systemTest")
	public void ctp() throws EncryptedDocumentException, IOException {
		ProspectPage pp = new ProspectPage(driver);
		
		
		String expectedTP = pp.createTpCustomer();

		ExcelUtility eu = new ExcelUtility();

		System.out.println("expected:" + expectedTP);
		String actualTP = driver.findElement(By.xpath("//div[(text()='"+expectedTP+"')]")).getText();
		//String actualWarehouse = driver.findElement(RelativeLocator.with(By.xpath("//div[text()='Short name of location :']")).above(By.xpath("//div[(text()='" + expectedWarehouse + "')]"))).getText();
		System.out.println("Actual:" + actualTP);
		boolean result = actualTP.contains(expectedTP);
		Assert.assertEquals(result, true);
		
		
	}

}
