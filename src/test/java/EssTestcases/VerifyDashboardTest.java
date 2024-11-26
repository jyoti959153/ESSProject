package EssTestcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass1.BaseTest1;

@Listeners(com.ESS.generic.listenerutility.ListenerImplementClass.class)
public class VerifyDashboardTest extends BaseTest1 {
	@Test(groups="smokeTest")
	public void dashBoard() {
		Reporter.log("Navigated to dashboard", true);
		Assert.assertEquals(driver.getTitle(), "Home - Dolibarr 19.0.1", "not a dashboard");
	}

}
