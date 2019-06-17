import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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


        Actions action = new Actions(driver);
        String xpath="//*[@id=\"menu\"]/a[6]";
        action.moveToElement(driver.findElement(By.xpath(xpath))).perform();/*鼠标悬浮在在线商城导航标签上面*/
//        elementtool.ms(time);
        String xpath="//*[@id=\"ext-gen4\"]/div[8]/ul/li[1]/div/a";
        action.moveToElement(driver.findElement(By.xpath(xpath))).perform();/*鼠标悬浮在在线商城导航标签上面*/
        xpath=" //*[@id=\"ext-gen4\"]/div[8]/ul/li[1]/div/a/div/ul/li[1]/a";
        driver.findElement(By.xpath(xpath)).click();/*点击在线商城导航标签下面手机*/






//        Thread.sleep(2000);
//        WebElement search_sarmra = driver.findElement(By.xpath("//*[@id=\"task_list\"]/div[2]/table/tbody/tr/td[5]/a/em"));
//        search_sarmra.click();
//        //切换窗口
//        driver.switchTo().frame(0);
//        Thread.sleep(2000);
//        //点击全选
//        WebElement search_selectall = driver.findElement(By.cssSelector(".x-grid3-hd-checker:nth-child(2)"));
//        search_selectall.click();
//        Thread.sleep(2000);
//
//        //点击快速评估
//        WebElement search_quicktest = driver.findElement(By.id("ext-gen55"));
//        search_quicktest.click();
//        Thread.sleep(2000);
//        driver.switchTo().frame(1);
//        //点击评估结果
//        WebElement search_sarmraresult = driver.findElement(By.id("ext-gen143"));
//        search_sarmraresult.click();
//        //点击不符合
//
//         String title = driver.getTitle();
//         System.out.printf(title);
//
//         driver.close();

    }
}