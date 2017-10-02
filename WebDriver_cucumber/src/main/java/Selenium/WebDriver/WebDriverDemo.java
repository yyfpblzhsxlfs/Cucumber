package Selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverDemo {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;

	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.baidu.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/*
	 * 打开百度网址并输入自动化测试进行搜索 搜索后清空搜索框，重新输入selenium进行搜索 并获取搜索到的第一个结果标题超链接
	 */
	public String Select(String seach_1, String seach_2) throws Exception {
		driver.get(baseUrl + "/");

		driver.findElement(By.id("kw")).sendKeys(seach_1);
		driver.findElement(By.id("su")).click();

		WebElement we = driver.findElement(By.id("kw"));
		we.clear();
		we.sendKeys(seach_2);

		driver.findElement(By.id("su")).click();

		String txt = driver.findElement(By.xpath(".//*[@id='1']/h3/a")).getText();

		return txt;

	}

	public void tearDown() throws Exception {
		driver.quit();
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
