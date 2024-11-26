package BaseClass1;

import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ESS.generic.databaseutility.databaseutility;
import com.ESS.generic.fileutility.ExcelUtility;
import com.ESS.generic.fileutility.FileUtility;
import com.ESS.generic.objectreporitory.LoginPage;
import com.ESS.generic.objectreporitory.LogoutPage;
import com.ESS.generic.webdriverutility.JavaUtility;
import com.ESS.generic.webdriverutility.StaticDriverTestUtility;
import com.ESS.generic.webdriverutility.WebDriverUtility;
import com.beust.jcommander.Parameter;


public class BaseTest1 {
    public static WebDriver driver;
    public static WebDriver sdriver;
    public databaseutility du=new databaseutility();
    public FileUtility fu=new FileUtility();
    public ExcelUtility eu=new ExcelUtility();
    public JavaUtility ju=new JavaUtility();
	WebDriverUtility wdu=new WebDriverUtility();
	
	@BeforeSuite(groups= {"SmokeTest","RegressionTest"})
	public void ConfigBS() throws SQLException
	{
	System.out.println("connect to database");
	du.connectToDatabase1();
	}
	
	@BeforeTest
	public void ConfigBT() 
	{
	System.out.println("Before test");
	}
	
	@Parameter
	@BeforeClass(groups= {"SmokeTest","RegressionTest"})
	public void ConfigBC(String browser1) throws Exception
	{
	System.out.println("launch the browser");
	String browser = fu.propertyFile("browser");
	WebDriver driver=null;
	if (browser.equals("chrome")) {
		driver = new ChromeDriver();
	} else if (browser.equals("firefox")) {
		driver = new FirefoxDriver();
	}
	else
	{
		driver = new ChromeDriver();
	}
	sdriver=driver;
	StaticDriverTestUtility.setDriver(driver);
	}
	
	@BeforeMethod(groups= {"SmokeTest","RegressionTest"})
	public void ConfigBM() throws Exception
	{
	System.out.println("login t o application");
	String url = fu.propertyFile("url");
	String username =fu.propertyFile("username"); 
	String password = fu.propertyFile("password");
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(username, password);
	}
	
	//@AfterMethod(groups= {"SmokeTest","RegressionTest"})
	public void ConfigAM() throws InterruptedException
	{
	System.out.println("logout from application");
	LogoutPage lo=new LogoutPage(driver);
	lo.logoutFromApp();
	}
	
    @AfterClass(groups= {"SmokeTest","RegressionTest"})
    public void ConfigAC() throws InterruptedException
	{
	System.out.println("close the browser");
	Thread.sleep(2000);
	driver.quit();
	}
    
    @AfterTest
    public void ConfigAT()
   	{
   	System.out.println("After Test");
   	}
    @AfterSuite(groups= {"SmokeTest","RegressionTest"})
    public void ConfigAS()
	{
	System.out.println("close database");
	du.colseConnection();
	}

}
