package org.example.tests;

import org.example.pages.basePageWebTables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
    public void addWebTable() throws InterruptedException {
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

        basePageWebTables.clickButtonSubmit();

        boolean recordFound = basePageWebTables.newRecord(firstN, lastN);
        Assert.assertTrue(recordFound, "Error al agregar el nuevo registro.");

        if (recordFound) {
            System.out.println("Nuevo registro agregado correctamente.");
        } else {
            System.out.println("Error al agregar el nuevo registro.");
        }
    }

    @Test
    public void deleteTable() throws InterruptedException {
        basePageWebTables.setDeleteButton();
        String firstN = "Cierra";
        String lastN = "Vega";
        boolean recordFound = basePageWebTables.validateDeleteRecord(firstN, lastN);
        Assert.assertFalse(recordFound, "Error al eliminar.");

        if (!recordFound) {
            System.out.println("Registro eliminado éxitosamente.");
        } else {
            System.out.println("Error al eliminar el registro.");
        }
    }

    @Test
    public void editRecord() throws InterruptedException {
        basePageWebTables.setEditButton();
        String firstN = "Cierra";
        String lastN = "Vega";
        String age = "25";
        String correo = "exampple@juju.com";
        String salaryN = "2000";
        String area = "RRHH";

        basePageWebTables.enterEditFirstName(firstN);
        basePageWebTables.enterEditLastName(lastN);
        basePageWebTables.enterEditEmail(correo);
        basePageWebTables.enterEditAge(age);
        basePageWebTables.enterEditSalary(salaryN);
        basePageWebTables.enterEditDepartment(area);
        basePageWebTables.clickButtonSubmit();

        System.out.println("Edit registro exitoso");

        boolean recordFound = basePageWebTables.newRecord(firstN, lastN);
        Assert.assertTrue(recordFound, "Error al agregar el nuevo registro.");

        if (recordFound) {
            System.out.println("Nuevo registro update correctamente.");
        } else {
            System.out.println("Error al actualizar el nuevo registro.");
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

