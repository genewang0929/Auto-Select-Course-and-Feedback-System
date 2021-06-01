import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.event.InputEvent;

public class selenium {
    private static WebDriver driver;
    public static  void setDriver(){
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void loginNTOU(String Account, String Password) {
        setDriver();
        driver.get("https://ais.ntou.edu.tw/Default.aspx");
        WebElement username = driver.findElement(By.name("M_PORTAL_LOGIN_ACNT"));
        username.sendKeys(Account);
        WebElement password = driver.findElement(By.name("M_PW"));
        password.sendKeys(Password);
        driver.findElement(By.xpath("//*[@id=\"LGOIN_BTN\"]")).click();

        //將登入資料傳送到資料庫
//        connectToSQL connectToSQL = new connectToSQL();
//        connectToSQL.studentInfo(Account, Password, Name);
    }

    public static void acessToSelectClass(){
        //driver.get("https://ais.ntou.edu.tw/Application/TKE/TKE22/TKE2211_01.aspx");
        //還是用正規方法比較好
        driver.switchTo().frame("menuFrame");
        driver.findElement(By.xpath("//*[@id=\"Menu_TreeViewt1\"]")).click();
        sleep(1);
        driver.findElement(By.xpath("/html/body/form/div[3]/table/tbody/tr[1]/td/div/div/div/table[3]/tbody/tr/td[5]/a")).click();
        sleep(1);
        driver.findElement(By.xpath("/html/body/form/div[3]/table/tbody/tr[1]/td/div/div/div/div/table[2]/tbody/tr/td[6]/a")).click();
        //bs4去爬資料
        //結合批次選課
    }

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
