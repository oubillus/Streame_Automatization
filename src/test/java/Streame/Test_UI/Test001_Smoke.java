package Streame.Test_UI;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import junit.framework.Assert;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test001_Smoke {
	  
private WebDriver driver;
private String baseUrl;
private boolean acceptNextAlert = true;
private StringBuffer verificationErrors = new StringBuffer();

//Change Url to QA or Staging Environment
 @BeforeClass(alwaysRun = true)
 public void setUp() throws Exception {
// URL OF GECKODRIVER
System.setProperty("webdriver.gecko.driver","C:\\Users\\dmarroquin\\Documents\\QA\\Selenium_tools\\geckodriver.exe" );
 driver = new FirefoxDriver();
 baseUrl = "http://localhost:4200";
 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 }

 @Test
  public void test() throws Exception {
  driver.get(baseUrl + "/playground");
  Thread.sleep(5000);
  assertTrue(isElementPresent(By.cssSelector("img[alt=\"Streame logo\"]")));
  assertTrue(isElementPresent(By.linkText("DISCOVER")));
  assertEquals(driver.findElement(By.linkText("DISCOVER")).getText(), "DISCOVER");
  assertTrue(isElementPresent(By.id("navbar-comp__langMenu")));
  assertTrue(isElementPresent(By.cssSelector("option[value=\"en\"]")));
  assertEquals(driver.findElement(By.cssSelector("option[value=\"en\"]")).getText(), "en");
  assertTrue(isElementPresent(By.cssSelector("option[value=\"es\"]")));
  assertEquals(driver.findElement(By.cssSelector("option[value=\"es\"]")).getText(), "es");
  assertTrue(isElementPresent(By.id("navbar-comp__login-link")));
  assertEquals(driver.findElement(By.id("navbar-comp__login-link")).getText(), "LOGIN");
  assertTrue(isElementPresent(By.id("navbar-comp__register-link")));
  assertEquals(driver.findElement(By.id("navbar-comp__register-link")).getText(), "CREAR CUENTA");
  assertTrue(isElementPresent(By.cssSelector("img[alt=\"LeeHowell.jpg\"]")));
  assertEquals(driver.findElement(By.cssSelector("h1.col-sm-12.favorites-title")).getText(), "My Latest Favorites");
  driver.findElement(By.cssSelector("option[value=\"en\"]")).click();
  Thread.sleep(1000);
  assertEquals(driver.findElement(By.id("navbar-comp__login-link")).getText(), "SIGN IN");
  assertEquals(driver.findElement(By.id("navbar-comp__register-link")).getText(), "CREATE ACCOUNT");
  //Login
  driver.findElement(By.id("navbar-comp__login-link")).click();
  Thread.sleep(4000);
  assertTrue(isElementPresent(By.cssSelector("div.modal-header")));
  assertEquals(driver.findElement(By.cssSelector("h2.modal-title")).getText(), "Bienvenido");
  assertTrue(isElementPresent(By.id("login_comp__close-button")));
  assertEquals(driver.findElement(By.id("login_comp__close-button")).getText(), "×");
  assertTrue(isElementPresent(By.id("login-comp__username")));
  driver.findElement(By.id("login-comp__username")).click();
  driver.findElement(By.id("login-comp__password")).click();
  Thread.sleep(1000);
  assertTrue(isElementPresent(By.cssSelector("div.alert.alert-danger")));
  assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "El correo electrónico es requerido");
  assertTrue(isElementPresent(By.id("login-comp__password")));
  driver.findElement(By.id("login-comp__password")).click();
  driver.findElement(By.id("login-comp__username")).click();
  Thread.sleep(1000);
  assertEquals(driver.findElement(By.xpath("//div[@id='login-comp']/div[2]/form/div[2]/div")).getText(), "La contraseña es requerida");
  assertTrue(isElementPresent(By.cssSelector("label")));
  assertTrue(isElementPresent(By.id("login-comp__remember-me")));
  assertEquals(driver.findElement(By.cssSelector("label")).getText(), "Recordarme");
  driver.findElement(By.id("login_comp__close-button")).click();
  Thread.sleep(1000);
  //REGISTER
  driver.findElement(By.id("navbar-comp__register-link")).click();
  Thread.sleep(4000);
  assertTrue(isElementPresent(By.cssSelector("button.close")));
  assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Cree su cuenta. Ahora gratis.");
  assertTrue(isElementPresent(By.id("register-comp__first-name")));
  driver.findElement(By.id("register-comp__first-name")).click();
  driver.findElement(By.id("register-comp__last-name")).click();
  assertTrue(isElementPresent(By.cssSelector("div.alert.alert-danger")));
  assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "Nombre es requerido para el registro");
  assertTrue(isElementPresent(By.id("register-comp__last-name")));
  driver.findElement(By.id("register-comp__last-name")).click();
  driver.findElement(By.id("register-comp__email")).click();
  assertTrue(isElementPresent(By.xpath("//div[@id='register-comp']/form/div[2]/div/div")));
  assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[2]/div/div")).getText(), "Apellido es requerido para el registro");
  assertTrue(isElementPresent(By.id("register-comp__email")));
  driver.findElement(By.id("register-comp__email")).click();
  driver.findElement(By.xpath("//div[@id='register-comp']/form/div[5]/div/div/div/label")).click();
  assertTrue(isElementPresent(By.xpath("//div[@id='register-comp']/form/div[3]/div/div")));
  assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[3]/div/div")).getText(), "Correo electrónico es requerido para el registro");
  assertTrue(isElementPresent(By.name("dp")));
  assertTrue(isElementPresent(By.xpath("//div[@id='register-comp']/form/div[5]/div/div/div/label")));
  assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[5]/div/div/div/label")).getText(), "Hombre");
  assertTrue(isElementPresent(By.xpath("//div[@id='register-comp']/form/div[5]/div/div/div[2]/label")));
  assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[5]/div/div/div[2]/label")).getText(), "Mujer");
  assertTrue(isElementPresent(By.id("register-comp__display-name")));
  driver.findElement(By.id("register-comp__display-name")).click();
  driver.findElement(By.id("register-comp__url")).click();
  assertTrue(isElementPresent(By.cssSelector("div.alert.alert-danger")));
  assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[6]/div/div")).getText(), "Nombre a mostrar es requerido para el registro");
  assertTrue(isElementPresent(By.id("register-comp__url")));
  driver.findElement(By.id("register-comp__address")).click();
  Thread.sleep(2000);
  assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[7]/div/div")).getText(), "URL es requerido para el registro");
  assertTrue(isElementPresent(By.id("register-comp__address")));
  assertTrue(isElementPresent(By.id("register-comp__country")));
  assertTrue(isElementPresent(By.id("register-comp__city")));
  assertTrue(isElementPresent(By.id("register-comp__zipcode")));
  assertTrue(isElementPresent(By.cssSelector("span.make-drag-overlay.avatar-inherit")));
  driver.findElement(By.id("register-comp")).sendKeys(Keys.ARROW_DOWN); 
  driver.findElement(By.id("register-comp")).sendKeys(Keys.ARROW_DOWN); 
  assertTrue(isElementPresent(By.id("register-comp__password")));
  assertTrue(isElementPresent(By.id("register-comp__confirm-password")));
  driver.findElement(By.id("register-comp__confirm-password")).click();
  driver.findElement(By.cssSelector("button.close")).click();
  }

 @AfterClass(alwaysRun = true)
 public void tearDown() throws Exception {
 driver.quit();
 String verificationErrorString = verificationErrors.toString();
 if (!"".equals(verificationErrorString)) {
 fail(verificationErrorString);
 }
 }
	
 private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

 private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

 private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}

