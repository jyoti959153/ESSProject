package EssTestcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ESS.generic.objectreporitory.VendorProposalPage;

import BaseClass1.BaseTest1;

@Listeners(com.ESS.generic.listenerutility.ListenerImplementClass.class)
public class CreateVendorProposalTest extends BaseTest1 {
	@Test(groups="systemTest")
	public void cvp() throws EncryptedDocumentException, IOException, InterruptedException {
		VendorProposalPage vp = new VendorProposalPage(driver);
		vp.createvp();
		String expectedVp = vp.createvp();
		
		System.out.println("expected:" + expectedVp);
		String actualVp= driver.findElement(By.xpath("//a[(text()='"+expectedVp+"')]")).getText();
		System.out.println("Actual:" + actualVp);
		boolean result = actualVp.contains(expectedVp);
		Assert.assertEquals(result, true);
	}

}
