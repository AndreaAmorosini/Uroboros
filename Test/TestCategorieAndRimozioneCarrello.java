import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

public class TestCategorieAndRimozioneCarrello {

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
    public void testCategorieAndRimozioneCarrello(){
        driver.get("http://localhost:8080/Piattaforma_e-commerce_war/");
        driver.manage().window().setSize(new Dimension(1936, 1096));
        //Visualizzazione Categoria
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(By.linkText("Catalogo"));
        actions.moveToElement(target).perform();
        driver.findElement(By.linkText("Giochi")).click();
        System.out.println("Visualizzazione Categoria OK");
        //Selezione Prodotto
        driver.findElement(By.cssSelector("div:nth-child(1) img")).click();
        System.out.println("Selezione Prodotto OK");
        //Aggiunta Prodotto al carrello
        driver.findElement(By.id("button")).click();
        System.out.println("Aggiunta prodotto al carrello OK");
        //rimozione prodotto dal carrello
        driver.findElement(By.cssSelector("input:nth-child(3)")).click();
        System.out.println("Rimozione prodotto dal carrello OK");
    }
}
