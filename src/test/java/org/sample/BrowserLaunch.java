package org.sample;

import org.base.BaseClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BrowserLaunch extends BaseClass {

	@Test
	public  void main() {
		BaseClass class1 = new BaseClass();
		class1.getDriver();
		class1.launchUrl("https://www.facebook.com/");
		WebElement txtUserName = driver.findElement(By.id("email"));
		class1.typeText(txtUserName, "welcome javaaaa");
		WebElement txtPassword = driver.findElement(By.id("pass"));
		class1.typeText(txtPassword, "java selenium");
		WebElement btnLogin = driver.findElement(By.name("login"));
		class1.butnClick(btnLogin);
	}

}
