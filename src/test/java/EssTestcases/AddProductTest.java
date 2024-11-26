package EssTestcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ESS.generic.fileutility.ExcelUtility;
import com.ESS.generic.objectreporitory.ProductPage;

import BaseClass1.BaseTest1;

@Listeners(com.ESS.generic.listenerutility.ListenerImplementClass.class)
public class AddProductTest extends BaseTest1 {
	@Test(groups="systemTest")
	public void ap() throws EncryptedDocumentException, IOException, InterruptedException {
		ProductPage pp = new ProductPage(driver);
		pp.createProduct();
		
		String expectedProduct = pp.createProduct();

		ExcelUtility eu = new ExcelUtility();

		System.out.println("expected:" + expectedProduct);
		String actualProduct = driver.findElement(By.xpath("//div[(text()='"+expectedProduct+"')]")).getText();
		System.out.println("Actual:" + actualProduct);
		boolean result = actualProduct.contains(expectedProduct);
		Assert.assertEquals(result, true);
	}

}
