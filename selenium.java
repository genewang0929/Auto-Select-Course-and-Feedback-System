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
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver = new ChromeDriver();
    }
    public static void loginNTOU(String Account, String Password) {
        setDriver();
        driver.get("https://ais.ntou.edu.tw/Default.aspx");
        WebElement username = driver.findElement(By.name("M_PORTAL_LOGIN_ACNT"));
        username.sendKeys(Account);
        WebElement password = driver.findElement(By.name("M_PW"));
        password.sendKeys(Password);
        //我看不懂，幫我註解一下
        //哪個王八蛋
        /*
        try {
            Robot r=new Robot();
            r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            r.keyPress(KeyEvent.VK_F11);
        }catch (Exception e){
            return;
        }
        */

        driver.findElement(By.xpath("//*[@id=\"LGOIN_BTN\"]")).click();

        //上教學務爬取登入者姓名
        //String name = String.valueOf(driver.findElement(By.xpath("//*[@id=\"USERNAME\"]")));
        //System.out.println(name);
        //TODO

        //將登入資料傳送到資料庫
//        connectToSQL connectToSQL = new connectToSQL();
//        connectToSQL.studentInfo(Account, Password, Name);
    }
    public static void acessToSelectClass(){
        driver.get("https://ais.ntou.edu.tw/Application/TKE/TKE22/TKE2211_01.aspx");
        //bs4去爬資料
        //結合批次選課
    }
}
