package org.example.tests;

import org.example.pages.basePageWebTables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class testWebTable {
    WebDriver driver;
    basePageWebTables basePageWebTables;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();
        basePageWebTables = new basePageWebTables(driver);
    }

    @Test
    public void addWebTable() throws InterruptedException{
        basePageWebTables.clickButtonAdd();

        String firstN = "Pamela";
        String lastN = "Brito";
        String mail = "name@example.com";
        String age = "35";
        String salary1 = "1500";
        String department1 = "IT";

        basePageWebTables.enterFirstName(firstN);
        basePageWebTables.enterLastName(lastN);
        basePageWebTables.enterEmail(mail);
        basePageWebTables.enterAge(age);
        basePageWebTables.enterSalary(salary1);
        basePageWebTables.enterDepartment(department1);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        driver.switchTo().defaultContent();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
