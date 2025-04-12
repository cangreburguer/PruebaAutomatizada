package com.robloxtest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RobloxTest {

    private WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeAll
    void setUpReport() {
        extent = ExtentReportUtil.getInstance();
    }

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
@Order(1)
void testLogin() throws InterruptedException {
    test = extent.createTest("Login en Roblox");

    driver.get("https://www.roblox.com/");
    test.info("Página cargada");

    WebElement loginButton = driver.findElement(By.xpath("//*[@id='main-login-button']"));
    loginButton.click();
    test.info("Clic en botón de login");

    Thread.sleep(2000);

    driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys("SonGokudahhh");
    driver.findElement(By.xpath("//*[@id='login-password']")).sendKeys("dragonball");
    driver.findElement(By.xpath("//*[@id='login-button']")).click();
    test.pass("Credenciales ingresadas");

    takeScreenshot("logged_in.png");
    test.addScreenCaptureFromPath("screenshots/logged_in.png");

    
}

@Test
@Order(1)
void testLoginGeneral() throws InterruptedException {
    test = extent.createTest("Login en Roblox");

    driver.get("https://www.roblox.com/");
    test.info("Página cargada");

    WebElement loginButton = driver.findElement(By.xpath("//*[@id='main-login-button']"));
    loginButton.click();
    test.info("Clic en botón de login");

    Thread.sleep(2000);

    driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys("SonGokudahhh");
    driver.findElement(By.xpath("//*[@id='login-password']")).sendKeys("dragonball");
    driver.findElement(By.xpath("//*[@id='login-button']")).click();
    test.pass("Credenciales ingresadas");


}

@Test
@Order(2)
void testBuscarJuego() throws InterruptedException {
    testLoginGeneral(); 
    Thread.sleep(5000);
    test = extent.createTest("Buscar juego");

    WebElement searchBox = driver.findElement(By.xpath("//*[@id='navbar-search-input']"));
    searchBox.sendKeys("Aot Revolution", Keys.ENTER);
    test.info("Juego buscado");

    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@id=\"4658598196\"]")).click();


    Thread.sleep(3000);
    takeScreenshot("Juegobuscado.png");
    test.pass("Juego buscado exitosamente");
    test.addScreenCaptureFromPath("screenshots/Juego_buscado.png");
}

@Test
@Order(3)
void testVolverHomePage() throws InterruptedException {
    testLoginGeneral(); 
    Thread.sleep(5000);
    test = extent.createTest("Volver al homepage");

    WebElement searchBox = driver.findElement(By.xpath("//*[@id='navbar-search-input']"));
    searchBox.sendKeys("Dragon Ball Online Generations", Keys.ENTER);
    test.info("Juego buscado");

    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='1374118848']")).click();

    Thread.sleep(2000);
    WebElement homeLink = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[1]/div[1]/div[2]/a/span[2]"));
    homeLink.click();

    Thread.sleep(4000);

    takeScreenshot("Homepage.png");
    test.pass("Se ha vuelto al inicio");
    test.addScreenCaptureFromPath("screenshots/paginainicio.png");
}

@Test
@Order(4)
void testAbrirPerfil() throws InterruptedException {
    testLoginGeneral(); 
    Thread.sleep(5000);
    test = extent.createTest("Abrir perfil desde el menú");

    WebElement profileBtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[1]/div[2]/div[2]/ul/div[2]/a/span[2]"));
    profileBtn.click();

    Thread.sleep(3000);
    takeScreenshot("perfil.png");
    test.pass("Perfil abierto correctamente");
    test.addScreenCaptureFromPath("screenshots/perfil.png");
}


@Test
@Order(5)
void testMarcarJuego() throws InterruptedException {
    testLoginGeneral(); 
    Thread.sleep(5000);

    test = extent.createTest("Like, Favorito y Seguir");
    Thread.sleep(2000);

    WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"navbar-search-input\"]"));
            searchBox.sendKeys("Dragon Ball Z Final Stand");
            searchBox.sendKeys(Keys.ENTER);

    //Pondré thread.sleep para que se vea cómo da click uno a uno a los botones de me gusta, etc.

    Thread.sleep(2000);

    WebElement Juegoboton = driver.findElement(By.xpath("//*[@id=\"210213771\"]"));
    Juegoboton.click();

    Thread.sleep(2000);

    WebElement Likeboton = driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div[1]/div[3]/div[2]/div[2]/ul/li[3]/div[2]/div/div/div[1]/span"));
    Likeboton.click();

    Thread.sleep(2000);

    WebElement Favboton = driver.findElement(By.xpath("//*[@id=\"game-favorite-icon\"]"));
    Favboton.click();

    Thread.sleep(2000);
    
    WebElement Seguirboton = driver.findElement(By.xpath("//*[@id=\"game-follow-icon\"]"));
    Seguirboton.click();

    Thread.sleep(2000);
    takeScreenshot("Me gusta juego.png");
    test.pass("Todas las interacciones realizadas");
    test.addScreenCaptureFromPath("screenshots/likes.png");
}

@Test
@Order(6)
void testLoginFail() throws InterruptedException {
    test = extent.createTest("Login en Roblox");

    driver.get("https://www.roblox.com/");
    test.info("Página cargada");

    WebElement loginButton = driver.findElement(By.xpath("//*[@id='main-login-button']"));
    loginButton.click();
    test.info("Clic en botón de login");

    Thread.sleep(2000);

    driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys("SonGokudahhh");
    driver.findElement(By.xpath("//*[@id='login-password']")).sendKeys("dragonbal");
    driver.findElement(By.xpath("//*[@id='login-button']")).click();
    test.fail("Credenciales incorrectas");

    Thread.sleep(2000);
    takeScreenshot("loginfail.png");
    test.addScreenCaptureFromPath("screenshots/failedlogin.png");
}

    private void takeScreenshot(String fileName) {
        try {
            File screenshotDir = new File("screenshots");
            if (!screenshotDir.exists()) screenshotDir.mkdirs();

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), Paths.get(screenshotDir.getPath(), fileName));

        } catch (IOException ex) {
            System.err.println("Error saving screenshot: " + ex.getMessage());
        }
    }

    @AfterEach
    void tearDown() {
       // if (driver != null) driver.quit();
    }

    @AfterAll
    void flushReport() {
        extent.flush();
        System.out.println("Reporte generado en test-output/roblox-report.html");
    }
}
