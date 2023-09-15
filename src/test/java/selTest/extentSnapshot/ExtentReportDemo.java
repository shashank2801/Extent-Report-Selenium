package selTest.extentSnapshot;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ExtentReportDemo {
	ExtentReports extent;
	
	@BeforeTest
	public void Config() {
		//ExtentReport and ExtentSparkReporter
		String path = System.getProperty("user.dir")+"//reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester name:", "Shashank Singhal");
		
	}
	
	@Test
	public void InitTest() {
		extent.createTest("Initial Demo");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		extent.flush();
	}
}
