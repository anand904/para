package com.web.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountVerify {
	public static WebDriver driver;
	@FindBy(xpath  = "//a[text()='Accounts Overview']")
	private WebElement accountOverView;

	@FindBy(xpath  = "//a[text()='21780']")
	private WebElement account;
	
	public AccountVerify(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getAccountOverView() {
		return accountOverView;
	}

	public WebElement getAccount() {
		return account;
	}

	

}
