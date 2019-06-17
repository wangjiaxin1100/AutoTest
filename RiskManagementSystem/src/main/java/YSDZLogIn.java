import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YSDZLogIn {
    public static  void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://10.10.134.232:7001/login.jsp");
        driver.manage().window().maximize();
        WebElement search_text = driver.findElement(By.id("userId"));
        search_text.sendKeys("AB000046");
        WebElement search_password = driver.findElement(By.id("password"));
        search_password.sendKeys("000000");
        WebElement search_submit = driver.findElement(By.className("loginBtn"));
        search_submit.click();


        Thread.sleep(2000);

        WebElement search_styleTit = driver.findElement(By.className("styleTit"));
        search_styleTit.click();
       WebElement search_changeStyle = driver.findElement(By.className("traditionS"));
        search_changeStyle.click();
//        WebElement search_icon_arrow = driver.findElement(By.id("icon_arrow"));
//        search_icon_arrow.click();
//        WebElement search_daily = driver.findElement(By.id("011001"));
//        search_daily.click();
        String title = driver.getTitle();
        System.out.printf(title);

//        driver.close();
    }
}
