import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

public class TestAccountAcquistoOperation {

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
    public void testAccountAcquistoOperation(){
        driver.get("http://localhost:8080/Piattaforma_e-commerce_war/");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        //visualizzazione catalogo completo
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(By.linkText("Catalogo"));
        actions.moveToElement(target).perform();
        driver.findElement(By.linkText("Catalogo Completo")).click();
        System.out.println("Visualizzazione Catalogo OK");
        //apertura prodotto
        driver.findElement(By.cssSelector("div:nth-child(1) img")).click();
        System.out.println("Apertura Prodotto OK");
        //aggiunta al carrello
        driver.findElement(By.id("button")).click();
        System.out.println("Aggiunta Al Carrello OK");
        //acquisto senza login
        driver.findElement(By.cssSelector("grid:nth-child(1) input")).click();
        driver.findElement(By.cssSelector("form:nth-child(3) > input")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("Utente4");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("Utente40");
        driver.findElement(By.cssSelector("input:nth-child(8)")).click();
        System.out.println("Acquisto senza Login OK");
        //ACQUISTO
        driver.findElement(By.linkText("Carrello")).click();
        driver.findElement(By.cssSelector("grid:nth-child(1) input")).click();
        System.out.println("Acquisto OK");
        //visualizzazione storico ordini
        WebElement target1 = driver.findElement(By.linkText("Account"));
        actions.moveToElement(target1).perform();
        driver.findElement(By.linkText("Storico ordini")).click();
        driver.findElement(By.cssSelector("input:nth-child(2)")).click();
        System.out.println("Visualizzazione Storico Ordini OK");
        //Modifica dati utente
        WebElement target2 = driver.findElement(By.linkText("Account"));
        actions.moveToElement(target2).perform();
        driver.findElement(By.linkText("Profilo")).click();
        driver.findElement(By.name("button")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("Utente40");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).click();
        {
            WebElement element = driver.findElement(By.id("password"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }
        driver.findElement(By.id("password")).sendKeys("Utente4000");
        driver.findElement(By.id("password1")).click();
        driver.findElement(By.id("password1")).click();
        {
            WebElement element = driver.findElement(By.id("password1"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }
        driver.findElement(By.id("password1")).sendKeys("Utente4000");
        driver.findElement(By.cssSelector("form:nth-child(2) > input")).click();
        System.out.println("Modifica Dati Utente OK");
        //Logout
        WebElement target3 = driver.findElement(By.linkText("Account"));
        actions.moveToElement(target3).perform();
        driver.findElement(By.linkText("LogOut")).click();
        System.out.println("Logout OK");
    }
}
