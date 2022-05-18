package com.fca.calidad.merncrud;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import java.io.File;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CrudTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void AgregarTest() throws Exception {
	//cambiar esta linea luego para correrla en la pagina por:
	//driver.get("https://mern-crud.herokuapp.com/");
    driver.get("http://localhost:3000/");
    //fin del cambio
    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Hakeem");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("HakeemO@gmail.com");
    driver.findElement(By.name("age")).click();
    driver.findElement(By.name("age")).clear();
    driver.findElement(By.name("age")).sendKeys("54");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gender'])[2]/following::div[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Male'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Woah!'])[1]/following::button[1]")).click();
    pause(3000);
    //Assert que se agrego correctamente
    assertThat(driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[1]")).getText(),is("Hakeem"));
    driver.findElement(By.xpath("//i")).click();
  }
  
  private void pause(long mils) {
	  try {
		  Thread.sleep(mils);
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
  }
  
  @Test
  public void BuscarTest() throws Exception {
	//cambiar esta linea luego para correrla en la pagina por:
	//driver.get("https://mern-crud.herokuapp.com/");
    driver.get("http://localhost:3000/");
    //fin del cambio
    driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[1]")).click();
    pause(3000);
    //assert que busca el nuevo elemento agregado "David"
    assertThat(driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[2]")).getText(),is("hakeemo@gmail.com"));
  }
  
  @Test
  public void CambiarTest() throws Exception {
	//cambiar esta linea luego para correrla en la pagina por:
	//driver.get("https://mern-crud.herokuapp.com/");
    driver.get("http://localhost:3000/");
    //fin del cambio
    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("David");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Woah!'])[1]/following::button[1]")).click();
    pause(3000);
    //assert que busca el nuevo elemento agregado "David"
    assertThat(driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[1]")).getText(),is("David"));
    driver.findElement(By.xpath("//i")).click();
  }
  
  
  @Test
  public void EliminarTest() throws Exception {
	//cambiar esta linea luego para correrla en la pagina por:
	//driver.get("https://mern-crud.herokuapp.com/");
    driver.get("http://localhost:3000/");
    //fin del cambio
    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='David'])[2]/following::button[1]")).click();
    pause(3000);
    //assert confirmacion de eliminacion de la unica entrada disponible
    assertThat(driver.findElement(By.xpath("/html/body/div/div/div[2]/em")).getText(),is("No one else is online"));
    pause(3000);
  }
  

  @After
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