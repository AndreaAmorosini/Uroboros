import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

public class TestFunzioniGestioneProdotti {

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
    public void testFunzioniGestioneProdotti(){
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
        System.out.println("Accesso come gestore OK");
        //gestione prodotti
        WebElement target3 = driver.findElement(By.linkText("Account"));
        actions.moveToElement(target3).perform();
        driver.findElement(By.linkText("Dashboard")).click();
        driver.findElement(By.cssSelector("div:nth-child(5) input")).click();
        System.out.println("Visualizzazione gestione Prodotti OK");
        //aggiunta prodotto
        driver.findElement(By.name("button")).click();
        driver.findElement(By.name("prodID")).click();
        driver.findElement(By.name("prodID")).sendKeys("12");
        driver.findElement(By.name("nome")).click();
        driver.findElement(By.name("nome")).sendKeys("prodotto12");
        driver.findElement(By.name("descrizione")).click();
        driver.findElement(By.name("descrizione")).sendKeys("loremi ipsu descriptus ");
        driver.findElement(By.name("prezzo")).click();
        driver.findElement(By.name("prezzo")).sendKeys("20.00");
        driver.findElement(By.name("quantita")).click();
        driver.findElement(By.name("quantita")).sendKeys("3");
        driver.findElement(By.name("categoria")).click();
        {
            WebElement dropdown = driver.findElement(By.name("categoria"));
            dropdown.findElement(By.xpath("//option[. = 'Hardware']")).click();
        }
        driver.findElement(By.name("categoria")).click();
        driver.findElement(By.cssSelector("input:nth-child(15)")).click();
        System.out.println("Aggiunta di un prodotto OK");
        //modifica dati prodotto
        driver.findElement(By.cssSelector("div:nth-child(10) > form:nth-child(4) > input:nth-child(2)")).click();
        driver.findElement(By.name("nome")).click();
        driver.findElement(By.name("nome")).sendKeys("prodotto13");
        driver.findElement(By.cssSelector("form:nth-child(2)")).click();
        driver.findElement(By.cssSelector("input:nth-child(10)")).click();
        System.out.println("Modifica Dati Prodotto OK");
        //rimozione prodotto
        driver.findElement(By.cssSelector("div:nth-child(10) > form:nth-child(5) > input:nth-child(2)")).click();
        System.out.println("Rimozione Prodotto OK");
    }
}
