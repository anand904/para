package com.web.sdp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.web.pom.AccountVerify;
import com.web.pom.Fundtransfer;
import com.web.pom.HomePage;
import com.web.pom.NewAccount;

import com.web.pom.SavingsAccount;
import com.web.pom.VerifyBalance;

public class Sdp {

	public WebDriver driver;
	
	public HomePage hp;
	public AccountVerify av;
	public Fundtransfer ft;
	public NewAccount na;
	public SavingsAccount sa;
	public VerifyBalance vb;
	
	public Sdp(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage getHomePage() {
		if(hp==null) {
			hp=new HomePage(driver);
			}
	return hp;
	}
	public AccountVerify getAccountverify() {
		if(av==null) {
			av=new AccountVerify(driver);
			}
	return av;
	}
	
	public Fundtransfer getfundtransfer() {
		if(ft==null) {
			ft=new Fundtransfer(driver);
			}
	return ft;
	}

	public NewAccount getNewaccount() {
		if(na==null) {
			na=new NewAccount(driver);
			}
	return na;
	}

	public SavingsAccount getSavingsAccount() {
		if(sa==null) {
			sa=new SavingsAccount(driver);
			}
	return sa;
	}

	public VerifyBalance getverifyBalance() {
		if(vb==null) {
			vb=new VerifyBalance(driver);
			}
	return vb;
	}

}
