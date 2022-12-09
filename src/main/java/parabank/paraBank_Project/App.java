package parabank.paraBank_Project;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.web.configurationReader.ConfigurationReaderHelp;
import com.web.sdp.Sdp;

import baseClass.BaseClass;

public class App extends BaseClass {
	public static WebDriver driver;
	public static Sdp sdp = new Sdp(driver);

	@Test
	public void browserLaunch() throws IOException {
		String browser = ConfigurationReaderHelp.getInstance().getBrowser();
		driver = BaseClass.browserLaunch(browser);
		String url = ConfigurationReaderHelp.getInstance().getUrl();
		BaseClass.url(url);
	}

	@Test
	public static void accountLogin() {
		WebElement userName = sdp.getHomePage().getUsername();
		driver.findElement(By.xpath("//input[@name='username']"));
		elementSendKeys(userName, "demo");
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		elementSendKeys(password, "jhon");
		WebElement login = driver.findElement(By.xpath("//input[@value='Log In']"));
		elementClick(login);
	}

	@Test
	public static void checkingAccount() {
		WebElement newAccount = driver.findElement(By.xpath("//a[text()='Open New Account']"));
		elementClick(newAccount);
		WebElement accountType = driver.findElement(By.xpath("//select[@id='type']"));
		selecMethod(accountType, "text", "checking");
		WebElement accountId = driver.findElement(By.xpath("//select[@id='fromAccountId']"));
		selecMethod(accountId, "text", "21780");

	}

	@Test
	public static void savingAccount() {
		WebElement newAccount = driver.findElement(By.xpath("//a[text()='Open New Account']"));
		elementClick(newAccount);
		WebElement accountType = driver.findElement(By.xpath("//select[@id='type']"));
		selecMethod(accountType, "text", "SAVINGS");
		WebElement ammountt = driver.findElement(By.xpath("//select[@id='fromAccountId']"));
		selecMethod(ammountt, "text", "21780");
	}

	@Test
	public static void accountVerify() {
		WebElement accountOevrView = driver.findElement(By.xpath("//a[text()='Accounts Overview']"));
		elementClick(accountOevrView);
		WebElement account = driver.findElement(By.xpath("//a[text()='21780']"));
		elementClick(account);
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("21780")) {
			System.out.println("Samae Account Page Is Opened");
		}
	}

	@Test
	public static void fundTransfer() {
		WebElement transfer = driver.findElement(By.xpath("//a[text()='Transfer Funds']"));
		elementClick(transfer);

		WebElement ammount = driver.findElement(By.xpath("//input[@id='amount']"));
		elementSendKeys(ammount, "50");
		WebElement fromAccount = driver.findElement(By.xpath("//select[@id='fromAccountId']"));
		selecMethod(fromAccount, "value", "21780");
		WebElement toAccount = driver.findElement(By.xpath("//select[@id='toAccountId']"));
		selecMethod(toAccount, "value", "27441");
		WebElement transferButton = driver.findElement(By.xpath("//input[@value='Transfer']"));
		elementClick(transferButton);
	}

	@Test
	public void verifyBalance() {
		WebElement accountOevrView = driver.findElement(By.xpath("//a[text()='Accounts Overview']"));
		elementClick(accountOevrView);
		WebElement account = driver.findElement(By.xpath("//a[text()='21780']"));
		elementClick(account);
		WebElement totalAmmount1 = driver.findElement(By.xpath("//td[text()='$4736,500.00']"));
		elementGetText(totalAmmount1);

		elementClick(accountOevrView);
		WebElement account1 = driver.findElement(By.xpath("//a[text()='27441']"));
		elementClick(account);
		WebElement totalAmmount2 = driver.findElement(By.xpath("//td[@id='balance'][text()='$13500.00']"));
		elementGetText(totalAmmount2);
		WebElement transAmmount = driver.findElement(By.xpath("//table[@id='transactionTable']/tbody/tr[4]/td[4]"));
		String text = elementGetText(transAmmount);
		if (text.equals("50")) {
			System.out.println("Ammount Recieved: $50");
		}
	}
}
