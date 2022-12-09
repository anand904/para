package com.web.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public static WebDriver driver;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement pasword;
	
	@FindBy(xpath = "//input[@value='Log In']")
	private WebElement login;

	
	public  HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUsername() {
		return username;
	}


	public WebElement getPasword() {
		return pasword;
	}


	public WebElement getLogin() {
		return login;
	}

	
	
}
