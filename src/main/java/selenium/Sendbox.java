package selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.*;

import java.sql.SQLException;

import static com.codeborne.selenide.Condition.*;
import connection.*;

public class Sendbox {

	public static WebDriver driver;
	MySqlJDBC db = new MySqlJDBC();

	@Before
	public void startDriver() throws ClassNotFoundException, SQLException {
		String path = "C:/Users/user/Downloads/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		System.setProperty("selenide.browser", "Chrome");
		Configuration.closeBrowserTimeoutMs = 30000;
		db.createConnection();
	}

//	@Test
	public void sendbox() throws ClassNotFoundException, SQLException {
		db.deleteByID(6, 6);
		db.readValues(1, 100);

	}

	@Test
	public void testRegistration() throws InterruptedException, ClassNotFoundException, SQLException {
		LoginPage lp = new LoginPage();

		String login = "FranciscoFrancoEmail";
		String password = "12345TestTest12345";
		int rand = ((int) (Math.random() * 1000));
		login += rand;
		System.out.println(login);
		System.out.println(password);

		open(lp.URL);
		lp.enterFirstName("YuriJ");
		lp.enterLastName("Litvin");

		lp.enterEmail(login);
		if (!lp.checkThatEmailIsUnique()) {
			lp.enterEmail(login + rand + "unique");
		}

		lp.enterPassword(password);

		lp.enterDateOfbirth(23, 7, 1987);
		lp.enterGender("Мужской");

		db.insertLoginPassword(login + "@gmail.com", password);
		db.readValues(0, 100);
		lp.submit();

		Thread.sleep(30000);

	}

	@After
	public void exitDriver() throws SQLException {
		db.closeConnection();
	}
}
