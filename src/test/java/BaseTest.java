import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;
    protected Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.get("https://jalasoft-dev-ed.lightning.force.com/lightning/o/Product2/list?filterName=Recent");
        driver.manage().window().setSize(new Dimension(1536, 824));
    }

    @Before
    public void login(){
        if ((Boolean) js.executeScript("return (document.querySelector(\'#theloginform\') && document.querySelector(\'#theloginform\').offsetHeight !== 0)")) {
            driver.findElement(By.id("username")).sendKeys("jmoya@freeorg01.com");
            driver.findElement(By.id("password")).click();
            driver.findElement(By.id("password")).sendKeys("Nataniel1804");
            driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
