package com.web.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavingsAccount {
	public static WebDriver driver;

	
	@FindBy(xpath  = "//a[text()='Open New Account']")
	private WebElement newAccount;

	
	@FindBy(xpath = "//select[@id='type']")
	private WebElement accountType;
	
	@FindBy(xpath = "//select[@id='fromAccountId']")
	private WebElement accountId;
	
	@FindBy(xpath = "//input[@value='Open New Account']")
	private WebElement newAccountOpen;
	
	
	public SavingsAccount(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getNewAccount() {
		return newAccount;
	}

	public WebElement getAccountType() {
		return accountType;
	}

	public WebElement getAccountId() {
		return accountId;
	}

	public WebElement getNewAccountOpen() {
		return newAccountOpen;
	}

}
