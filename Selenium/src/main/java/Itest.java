package javaBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Itest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("http://10.10.134.232:7001/");

        String title = driver.getTitle();
        System.out.printf(title);

        driver.close();
    }
}