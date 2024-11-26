package EssTestcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ESS.generic.fileutility.ExcelUtility;
import com.ESS.generic.objectreporitory.ProspectListPage;
import com.ESS.generic.objectreporitory.ProspectPage;

import BaseClass1.BaseTest1;

@Listeners(com.ESS.generic.listenerutility.ListenerImplementClass.class)
public class CreateProspectTest extends BaseTest1 {
	@Test(groups="integrationTest")
	public void cp() throws EncryptedDocumentException, IOException {
		ProspectPage pp = new ProspectPage(driver);
		pp.createNewProspect();

		String expectedProspect = pp.createNewProspect();

		ExcelUtility eu = new ExcelUtility();

		System.out.println("expected:" + expectedProspect);
		String actualProspect = driver.findElement(By.xpath("//div[(text()='" + expectedProspect + "')]")).getText();
		System.out.println("Actual:" + actualProspect);
		boolean result = actualProspect.contains(expectedProspect);
		Assert.assertEquals(result, true);
	}
	
	

}
