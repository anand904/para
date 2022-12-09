package parabank.paraBank_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.web.configurationReader.ConfigurationReaderHelp;

import baseClass.BaseClass;

public class ParaBank extends BaseClass {
	public static WebDriver driver;

	public void browserLaunch() {

		driver = BaseClass.browserLaunch("chrome");
		BaseClass.url("https://parabank.parasoft.com/parabank/index.htm");
	}

	public static void accountCreate() {
		WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
		elementClick(register);

		WebElement firstName = driver.findElement(By.id("customer.firstName"));
		elementSendKeys(firstName, "demo");
		WebElement lastName = driver.findElement(By.id("customer.lastName"));
		elementSendKeys(lastName, "jhon");
		WebElement address = driver.findElement(By.id("customer.address.street"));
		elementSendKeys(address, "91,19street, shakthi nagar");
		WebElement city = driver.findElement(By.id("customer.address.city"));
		elementSendKeys(city, "chennai");
		WebElement state = driver.findElement(By.id("customer.address.state"));
		elementSendKeys(state, "Tamilnadu");
		WebElement zipCode = driver.findElement(By.id("customer.address.zipCode"));
		elementSendKeys(zipCode, "600107");

		WebElement phNumber = driver.findElement(By.id("customer.phoneNumber"));
		elementSendKeys(phNumber, "9876543210");
		WebElement sssn = driver.findElement(By.id("customer.ssn"));
		elementSendKeys(sssn, "12345");

		WebElement userName = driver.findElement(By.id("customer.username"));
		elementSendKeys(userName, "demo");

		WebElement password = driver.findElement(By.id("customer.password"));
		elementSendKeys(password, "jhon");

		WebElement confirmPass = driver.findElement(By.id("repeatedPassword"));
		elementSendKeys(confirmPass, "jhon");
		WebElement registerButton = driver.findElement(By.id("//input[@type='submit' and @value='Register']"));
		elementClick(registerButton);

	}

	public static void newAccount() {
		WebElement newAccount = driver.findElement(By.xpath("//a[text()='Open New Account']"));
		elementClick(newAccount);
		WebElement accountType = driver.findElement(By.xpath("//select[@id='type']"));
		selecMethod(accountType, "text", "checking");
		WebElement ammountt = driver.findElement(By.xpath("//select[@id='fromAccountId']"));
		selecMethod(ammountt, "text", "21780");

	}
	
	public static void fundTransfer() {
		WebElement transfer = driver.findElement(By.xpath("//a[text()='Transfer Funds']"));
		elementClick(transfer);
		
		WebElement ammount = driver.findElement(By.xpath("//input[@id='amount']"));
		elementSendKeys(ammount, "50");
		WebElement fromAccount = driver.findElement(By.xpath("//select[@id='fromAccountId']"));
		selecMethod(fromAccount, "value", "21780");
		WebElement toAccount = driver.findElement(By.xpath("//select[@id='toAccountId']"));
		selecMethod(toAccount, "value", "25665");
		WebElement transferButton = driver.findElement(By.xpath("//input[@value='Transfer']"));
		elementClick(transferButton);
	}

}
