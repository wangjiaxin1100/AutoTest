import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogIn {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://10.10.108.20:7001/abfx/login.action");
        driver.manage().window().maximize();
        WebElement search_text = driver.findElement(By.id("j_username"));
        search_text.sendKeys("AB046807");
        WebElement search_password = driver.findElement(By.name("j_password"));
        search_password.sendKeys("111111");
        WebElement search_captcha = driver.findElement(By.name("j_captcha"));
        search_captcha.sendKeys("1111");
        WebElement search_submit = driver.findElement(By.id("IbtnEnter"));
        search_submit.click();
    }
}