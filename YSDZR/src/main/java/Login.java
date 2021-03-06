// Generated by Selenium IDE

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.HashMap;
import java.util.Map;
public class Login {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void Login() {
        driver.get("http://10.10.134.232:7001/");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.findElement(By.id("userId")).click();
        driver.findElement(By.id("userId")).click();
        driver.findElement(By.id("userId")).sendKeys("AB000046");
        driver.findElement(By.id("password")).sendKeys("000000");
        driver.findElement(By.cssSelector(".loginBtn")).click();
        String right_click = driver.findElement(By.linkText("linkText=切换风格"));
        ActionChains(driver)
//        {
//            WebElement element = driver.findElement(By.linkText("切换风格"));
//            Action builder = new Actions(driver);
//            builder.moveToElement(element).perform();
//        }
        driver.findElement(By.xpath("//a[contains(text(),\'传统风格\')]")).click();
        driver.switchTo().frame(3);
        driver.findElement(By.id("icon_arrow")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(2);
        driver.findElement(By.linkText("报销管理")).click();
        driver.findElement(By.id("sd187")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(4);
        driver.findElement(By.xpath("(//input[@id=\'vt\'])[2]")).click();
        driver.findElement(By.name("helpButton")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("a:nth-child(6) > img")).click();
    }
}
