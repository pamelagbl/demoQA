package org.example.tests;

import org.example.pages.basePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class testTextBox {
    WebDriver driver;
    basePage basePage;
    WebDriverWait wait;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://demoqa.com/text-box");
        basePage = new basePage(driver);
    }

    @Test
    public void testTextBoxForm() {
        String fullName = "Pamela Brito";
        String email = "name@example.com";
        String currentAddress = "Bogotá";
        String permanentAddress = "Suba";

        basePage.enterFullName(fullName);
        basePage.enterEmail(email);
        basePage.enterCurrentAddress(currentAddress);
        basePage.enterPermanentAddress(permanentAddress);
        basePage.clickSubmit();

        WebElement nameOutput = driver.findElement(By.xpath("//*[@id='name']"));
        String actualName1 = nameOutput.getText().replace("Name:", "").trim();
        String actualName = actualName1.substring(actualName1.indexOf(":") + 1).trim(); // Elimina el prefijo "Name:" y luego elimina espacios en blanco

        Assert.assertEquals(actualName, fullName, "El nombre completo válido debe mostrarse en la salida.");
        System.out.println("Aserción completada. El registro coincide");
        System.out.println("Actual Name: " + actualName + ", Expected Name: " + fullName);

        // email
        WebElement emailOutput = driver.findElement(By.xpath("//*[@id='email']"));
        String emailReplace = emailOutput.getText().replace("Email:", "").trim();
        String emailActual = emailReplace.substring(emailReplace.indexOf(":") + 1).trim(); // Elimina el prefijo "Name:" y luego elimina espacios en blanco

        Assert.assertEquals(emailActual, email, "El nombre completo válido debe mostrarse en la salida.");
        System.out.println("Aserción completada. El registro coincide");
        System.out.println("Actual email: " + email + ", Expected email: " + emailActual);

        // currentAddress
        WebElement currentAddressOutput = driver.findElement(By.xpath("//*[@id='currentAddress']"));
        String currentAddreesReplace = currentAddressOutput.getText().replace("Current Address:", "").trim();
        String currentAddressActual = currentAddreesReplace.substring(currentAddreesReplace.indexOf(":") + 1).trim(); // Elimina el prefijo "Name:" y luego elimina espacios en blanco

        Assert.assertEquals(emailActual, email, "El nombre completo válido debe mostrarse en la salida.");
        System.out.println("Aserción completada. El registro coincide");
        System.out.println("Actual Current Address: " + currentAddressActual + ", Expected Current Address: " + currentAddress);

        // permanentAddress
        WebElement permanentAddressOutput = driver.findElement(By.xpath("//*[@id='permanentAddress']"));
        String permanentAddreesReplace = permanentAddressOutput.getText().replace("Permananet Address:", "").trim();
        String permanentAddressActual = permanentAddreesReplace.substring(permanentAddreesReplace.indexOf(":") + 1).trim(); // Elimina el prefijo "Name:" y luego elimina espacios en blanco

        Assert.assertEquals(emailActual, email, "El nombre completo válido debe mostrarse en la salida.");
        System.out.println("Aserción completada. El registro coincide");
        System.out.println("Actual Permanent: " + permanentAddressActual + ", Expected Permanent: " + permanentAddress);

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

