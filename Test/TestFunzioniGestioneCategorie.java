import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

public class TestFunzioniGestioneCategorie {

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
    public void testFunzioniGestioneCategorie(){
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
        //Visualizzazione Gestione Prodotti
        WebElement target1 = driver.findElement(By.linkText("Account"));
        actions.moveToElement(target1).perform();
        driver.findElement(By.linkText("Dashboard")).click();
        driver.findElement(By.cssSelector("div:nth-child(4) input")).click();
        System.out.println("Visualizzazione Gestione Categorie OK");
        //Aggiunta di una categoria
        driver.findElement(By.name("button")).click();
        driver.findElement(By.name("IDCategoria")).click();
        driver.findElement(By.name("IDCategoria")).sendKeys("4");
        driver.findElement(By.name("nome")).click();
        driver.findElement(By.name("nome")).sendKeys("categoria4");
        driver.findElement(By.cssSelector("form:nth-child(2)")).click();
        driver.findElement(By.name("descrizione")).click();
        driver.findElement(By.name("descrizione")).sendKeys("categoria4");
        driver.findElement(By.cssSelector("input:nth-child(7)")).click();
        System.out.println("Aggiunta di una categoria OK ");
        //modifica dati categoria
        driver.findElement(By.cssSelector("div:nth-child(4) form:nth-child(3) > input:nth-child(2)")).click();
        driver.findElement(By.name("descrizione")).click();
        driver.findElement(By.name("descrizione")).sendKeys("Descrizione della categoria 4");
        driver.findElement(By.cssSelector("input:nth-child(6)")).click();
        System.out.println("Modifica Dati Categoria OK");
        //rimozione categoria
        driver.findElement(By.cssSelector("div:nth-child(4) form:nth-child(4) > input:nth-child(2)")).click();
        System.out.println("Rimozione Categoria OK");
    }
}
