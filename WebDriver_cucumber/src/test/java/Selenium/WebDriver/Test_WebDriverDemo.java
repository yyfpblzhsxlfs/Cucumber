package Selenium.WebDriver;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.*;

/**
 * Unit test for simple App.
 */
public class Test_WebDriverDemo {

	private String fast_link_name = "Selenium - Web Browser Automation";
	WebDriverDemo demo = new WebDriverDemo();

	@BeforeSuite
	public void Before() throws Exception {
		demo.setUp();
	}

	@AfterSuite
	public void After() throws Exception {
		demo.tearDown();
	}

	@Test
	public void test_select() throws Exception {
		String txt = demo.Select("自动化测试", "selenium");
		assertEquals(txt, fast_link_name);

	}

}
