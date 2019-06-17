import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SwitchTo {

    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.126.com");

        WebElement xf = driver.findElement(By.xpath("//*[@id='loginDiv']/iframe"));
        driver.switchTo().frame(xf);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("username");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.id("dologin")).click();
        driver.switchTo().defaultContent();
        //……
    }
}