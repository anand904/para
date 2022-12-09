package com.web.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyBalance {
	public static WebDriver driver;

	@FindBy(xpath  = "//a[text()='Accounts Overview']")
	private WebElement accountOverview;
	
	@FindBy(xpath  = "//a[text()='21780']")
	private WebElement account;
	
	@FindBy(xpath  = "//td[text()='$4736,500.00']")
	private WebElement totalAmmount1;
	
	@FindBy(xpath  = "//a[text()='27441']")
	private WebElement account1;
	
	@FindBy(xpath  = "//td[@id='balance'][text()='$13500.00']")
	private WebElement totalAmmount2;
	
	@FindBy(xpath  = "//table[@id='transactionTable']/tbody/tr[4]/td[4]")
	private WebElement transAmmount;
	
	public  VerifyBalance(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAccountOverview() {
		return accountOverview;
	}



	public WebElement getAccount() {
		return account;
	}



	public WebElement getTotalAmmount1() {
		return totalAmmount1;
	}



	public WebElement getAccount1() {
		return account1;
	}



	public WebElement getTotalAmmount2() {
		return totalAmmount2;
	}



	public WebElement getTransAmmount() {
		return transAmmount;
	}
}
