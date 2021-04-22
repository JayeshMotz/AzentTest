package automation.AT;

import org.testng.Assert;

import Essentials.AT_Locators;
import Essentials.AT_Utils;
import Essentials.ConfigFile;

public class LoginClass extends AT_Utils {

	// method to Login to APP
	public void fLogin(String UserName, String Password)
			throws InterruptedException {

		//will login from login screen
		DynamicWait(AT_Locators.emailInput);
		driver.findElement(AT_Locators.emailInput).sendKeys(UserName);
		driver.findElement(AT_Locators.emailInput).sendKeys(Password);

		driver.findElements(AT_Locators.lpBtns).get(0).click();
		DynamicWait(AT_Locators.WebinarPopUp);

		//wait for webinar pop up and then close it
		driver.findElement(AT_Locators.WebinarPopUp)
				.findElement(AT_Locators.RootSVGBtn).click();
		Assert.assertTrue(
				driver.findElement(AT_Locators.LoggedInChipBtn).isDisplayed());

	}

	public void Login(String UserName, String Password)
			throws InterruptedException {

		//Login from inside screen
		driver.findElements(AT_Locators.lpBtns).get(4).click();
		DynamicWait(AT_Locators.emailInput);
		driver.findElement(AT_Locators.emailInput).sendKeys(UserName);
		driver.findElement(AT_Locators.emailInput).sendKeys(Password);

		driver.findElements(AT_Locators.lpBtns).get(22).click();
		DynamicWait(AT_Locators.WebinarPopUp);

		//wait for webinar pop up and then close it
		driver.findElement(AT_Locators.WebinarPopUp)
				.findElement(AT_Locators.RootSVGBtn).click();
		Assert.assertTrue(
				driver.findElement(AT_Locators.LoggedInChipBtn).isDisplayed());

	}

	public void Logout() throws InterruptedException {
		driver.findElement(AT_Locators.LoggedInChipBtn).click();
		DynamicWait(AT_Locators.MenuItem);
		driver.findElements(AT_Locators.MenuItem).get(2).click();
		wait(ConfigFile.Medium_Wait);
		Assert.assertFalse(
				driver.findElement(AT_Locators.LoggedInChipBtn).isDisplayed());
	}

}
