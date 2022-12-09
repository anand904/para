package parabank.paraBank_Project;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.web.configurationReader.ConfigurationReaderHelp;
import com.web.sdp.Sdp;

import baseClass.BaseClass;

public class DemoAccount extends BaseClass {
	public static WebDriver driver;
	public static Sdp sdp;
  @Test(priority=0)
	public void browserLaunch() throws IOException {
	  String browser = ConfigurationReaderHelp.getInstance().getBrowser();
		driver = BaseClass.browserLaunch(browser);
		String url = ConfigurationReaderHelp.getInstance().getUrl();
		BaseClass.url(url);
		sdp= new Sdp(driver);
	}
  @DataProvider(name="login")
	public Object[][] login() {
		return new Object[][] {{"demo","jhon"}
			
		};
	}
  @Test(dataProvider ="login",priority=1)
	public static void accountLogin(String user,String pass) {
		waits(30);

		WebElement userName = sdp.getHomePage().getUsername();
		elementSendKeys(userName, user);
		
		WebElement password = sdp.getHomePage().getPasword();
		elementSendKeys(password, pass);
		
		WebElement login =sdp.getHomePage().getLogin();
		elementClick(login);
	}
  @DataProvider(name="checking")
	public Object[][] checking() {
		return new Object[][] {{"checking","21780"}
			
		};
	}
  @Test(dataProvider ="checking",priority=2)
	public static void checkingAccount(String type, String id) {
		WebElement newAccount = sdp.getNewaccount().getNewAccount();
		elementClick(newAccount);
		
		WebElement accountType = sdp.getNewaccount().getAccountType();
		selecMethod(accountType, "text", type);
		
		WebElement accountId =sdp.getNewaccount().getAccountId();
		selecMethod(accountId, "text", id);

	}
  @DataProvider(name="savings")
 	public Object[][] savings() {
 		return new Object[][] {{"SAVINGS","27441"}
 			
 		};
 	}
  @Test(dataProvider ="savings",priority=3)
public static void savingAccount(String type, String id) {
	WebElement newAccount = sdp.getSavingsAccount().getNewAccountOpen();
	elementClick(newAccount);
	
	WebElement accountType = sdp.getSavingsAccount().getAccountType();
	selecMethod(accountType, "text", type);
	
	WebElement accountId = sdp.getSavingsAccount().getAccountId();
	selecMethod(accountId, "text", id);
	}
  @Test(priority=4)
	public static void accountVerify() {
		WebElement accountOevrView = sdp.getAccountverify().getAccountOverView();
		elementClick(accountOevrView);
		
		WebElement account = sdp.getAccountverify().getAccount();
		elementClick(account);
		
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.contains("21780")) {
			System.out.println("Samae Account Page Is Opened");
		}
	}
  @DataProvider(name="tranfer")
	public Object[][] tranfer() {
		return new Object[][] {{"50","21780","27441"}
			
		};
	}
  @Test(priority=5,dataProvider ="tranfer")
	public static void fundTransfer(String amount, String id1, String id2) {
		WebElement transfer = sdp.getfundtransfer().getTransfer();
		elementClick(transfer);
		
		WebElement ammount = sdp.getfundtransfer().getAmmount();
		elementSendKeys(ammount, amount);
		
		WebElement fromAccount =sdp.getfundtransfer().getFromAccount();
		selecMethod(fromAccount, "value", id1);
		
		WebElement toAccount = sdp.getfundtransfer().getToAccount();
		selecMethod(toAccount, "value", id2);
		
		WebElement transferButton = sdp.getfundtransfer().getTransferButton();
		elementClick(transferButton);
	}
  @Test(priority=6)
  public void verifyBalance() {
	  waits(30);
	  WebElement accountOevrView = sdp.getverifyBalance().getAccountOverview();
		elementClick(accountOevrView);
		
		WebElement account = sdp.getverifyBalance().getAccount();
		elementClick(account);
		
		WebElement totalAmmount1 = sdp.getverifyBalance().getTotalAmmount1();
		elementGetText(totalAmmount1);
		elementClick(accountOevrView);
		
		WebElement account1 = sdp.getverifyBalance().getAccount1();
		elementClick(account);
		
		WebElement totalAmmount2 = sdp.getverifyBalance().getTotalAmmount2();
		elementGetText(totalAmmount2);
		WebElement transAmmount = sdp.getverifyBalance().getTransAmmount();
		String text = elementGetText(transAmmount);
		if(text.equals("50")) {
			System.out.println("Ammount Recieved: $50");
		}
  }
  @Test(dependsOnMethods = "verifyBalance" )
  public void browserClose() {
	  closeOrQuit("close");
  }
}
