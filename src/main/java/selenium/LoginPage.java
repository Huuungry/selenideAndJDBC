package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPage {
	public final String URL = "https://accounts.google.com/SignUp?";
	// private WebElement firstName;
	// private WebElement lastName;
	// private WebElement gmailAdress;
	// private WebElement passwd;
	private WebDriver driver;

	public void enterFirstName(String firstName) {
		$(By.name("FirstName")).setValue(firstName);
	}

	public void enterLastName(String lastName) {
		$(By.name("LastName")).setValue(lastName);
	}

	public void enterEmail(String email) {
		$(By.name("GmailAddress")).setValue(email);
	}

	public boolean checkThatEmailIsUnique() {
		$(By.linkText("That user name is taken. Try another.")).isDisplayed();
		return true;
	}

	public void enterPassword(String password) {
		$(By.name("Passwd")).setValue(password);
		$(By.name("PasswdAgain")).setValue(password);
	}

	public void enterDateOfbirth(int d, int m, int y) {

		$(By.name("BirthDay")).setValue(String.valueOf(d));
		$(By.name("BirthYear")).setValue(String.valueOf(y));

		$(By.xpath(".//*[@id='BirthMonth']/div[1]/div[1]")).click();
		$(By.id(":" + m)).click();

	}

	public void enterGender(String gender) {
		$(By.id("Gender")).click();
		$(By.id(":f")).click();

	}

	public void submit() {
		$(By.id("submitbutton")).click();
	}

	LoginPage(WebDriver driver) {
		// PageFactory.initElements(driver, this);
		this.driver = driver;
	}

}
