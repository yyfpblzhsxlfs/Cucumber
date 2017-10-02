package Selenium.WebDriver;

import java.io.File;

public class test {
	public static void main(String[] args) throws Exception {
		WebDriverDemo wdd = new WebDriverDemo();

		wdd.setUp();
		
		String txt = wdd.Select("自动化", "selenium");

		System.out.println(txt);

		wdd.tearDown();
	}
}
