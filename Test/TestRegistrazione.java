// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class TestRegistrazione {
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
  public void registrazionenuovoutente(){
    driver.get("http://localhost:8080/Piattaforma_e-commerce_war/");
    driver.manage().window().setSize(new Dimension(1936, 1096));
    Actions actions = new Actions(driver);
    WebElement target = driver.findElement(By.linkText("Account"));
    actions.moveToElement(target).perform();
    driver.findElement(By.linkText("Registrati")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).sendKeys("utente4");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("Utente40");
    driver.findElement(By.id("password1")).click();
    driver.findElement(By.id("password1")).sendKeys("Utente40");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Utente");
    driver.findElement(By.cssSelector("fieldset:nth-child(2)")).click();
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).sendKeys("2");
    driver.findElement(By.id("CF")).click();
    driver.findElement(By.id("CF")).sendKeys("8476847694");
    driver.findElement(By.id("dataDiNascita")).click();
    driver.findElement(By.id("datDiNascita")).clear();
    driver.findElement(By.id("dataDiNascita")).sendKeys("2000-03-24");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).sendKeys("947864");
    driver.findElement(By.id("mail")).click();
    driver.findElement(By.id("mail")).sendKeys("mail2@mail.it");
    driver.findElement(By.id("#carta")).click();
    driver.findElement(By.id("#carta")).sendKeys("84769376");
    driver.findElement(By.id("tipoCarta")).click();
    driver.findElement(By.id("tipoCarta")).sendKeys("visa");
    driver.findElement(By.id("dataDiScadenza")).click();
    driver.findElement(By.id("dataDiScadenza")).sendKeys("0002-01-20");
    driver.findElement(By.id("dataDiScadenza")).sendKeys("0020-01-20");
    driver.findElement(By.id("dataDiScadenza")).sendKeys("0203-01-20");
    driver.findElement(By.id("dataDiScadenza")).sendKeys("2030-01-20");
    driver.findElement(By.id("CSV")).click();
    driver.findElement(By.id("CSV")).sendKeys("234");
    driver.findElement(By.id("nomeTitolare")).click();
    driver.findElement(By.id("nomeTitolare")).sendKeys("utente");
    driver.findElement(By.id("cognomeTitolare")).click();
    driver.findElement(By.id("cognomeTitolare")).sendKeys("2");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("via")).sendKeys("via10");
    driver.findElement(By.id("via2")).click();
    driver.findElement(By.id("via2")).sendKeys("2");
    driver.findElement(By.id("nazione")).click();
    driver.findElement(By.id("nazione")).sendKeys("nazione2");
    driver.findElement(By.id("regione")).click();
    driver.findElement(By.id("regione")).sendKeys("regione2");
    driver.findElement(By.id("CAP")).click();
    driver.findElement(By.id("CAP")).sendKeys("479468");
    driver.findElement(By.id("città")).click();
    driver.findElement(By.id("città")).sendKeys("città2");
    driver.findElement(By.id("registraButton")).click();
    System.out.println("Registrazione OK");

  }
}