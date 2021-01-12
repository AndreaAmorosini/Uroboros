import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

public class TestFunzioniGestioneAccount {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\andal\\Documents\\programmi_creati\\HTML\\progetti\\Uroboros\\Piattaforma_e-commerce\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--whitelisted-ips");
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testFunzioniGestore() throws InterruptedException {
        //accesso al sito come gestore
        driver.get("http://localhost:8080/Piattaforma_e-commerce_war/");
        driver.manage().window().setSize(new Dimension(1936, 1096));
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(By.linkText("Account"));
        actions.moveToElement(target).perform();
        driver.findElement(By.linkText("Accedi")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("admin1");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("admin1");
        driver.findElement(By.cssSelector("input:nth-child(8)")).click();
        System.out.println("Accesso come Gestore OK");
        //visualizzazione gestione account
        WebElement target1 = driver.findElement(By.linkText("Account"));
        actions.moveToElement(target1).perform();
        driver.findElement(By.linkText("Dashboard")).click();
        driver.findElement(By.cssSelector("div:nth-child(3) input")).click();
        System.out.println("Visualizzazione Gestione Account OK");
        //visualizzazione storico ordini account
        driver.findElement(By.cssSelector("div:nth-child(2) form:nth-child(3) > input:nth-child(2)")).click();
        System.out.println("Visualizzazione Storico Ordini Account OK");
        //visualizzazione dettagli account
        WebElement target2 = driver.findElement(By.linkText("Account"));
        actions.moveToElement(target2).perform();
        driver.findElement(By.linkText("Dashboard")).click();
        driver.findElement(By.cssSelector("div:nth-child(3) input")).click();
        driver.findElement(By.cssSelector("div:nth-child(2) form:nth-child(2) > input:nth-child(3)")).click();
        System.out.println("Visualizzazione dettagli account OK");
        //eliminazione account
        WebElement target3 = driver.findElement(By.linkText("Account"));
        actions.moveToElement(target3).perform();
        driver.findElement(By.linkText("Dashboard")).click();
        driver.findElement(By.cssSelector("div:nth-child(3) input")).click();
        driver.findElement(By.cssSelector("div:nth-child(3) form:nth-child(4) > input:nth-child(3)")).click();
        System.out.println("Eliminazione Account OK");
    }

}
