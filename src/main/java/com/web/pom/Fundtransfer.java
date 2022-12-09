package com.web.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Fundtransfer {
	public static WebDriver driver;

	@FindBy(xpath  = "//a[text()='Transfer Funds']")
	private WebElement transfer;
	
	
	@FindBy(xpath  = "//input[@id='amount']")
	private WebElement ammount;
	
	@FindBy(xpath  = "//select[@id='fromAccountId']")
	private WebElement fromAccount;
	
	@FindBy(xpath  = "//select[@id='toAccountId']")
	private WebElement toAccount;
	
	@FindBy(xpath  = "//input[@value='Transfer']")
	private WebElement transferButton;
	
	public  Fundtransfer(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getTransfer() {
		return transfer;
	}

	public WebElement getAmmount() {
		return ammount;
	}

	public WebElement getFromAccount() {
		return fromAccount;
	}

	public WebElement getToAccount() {
		return toAccount;
	}

	public WebElement getTransferButton() {
		return transferButton;
	}


}
