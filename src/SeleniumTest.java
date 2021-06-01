import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.event.InputEvent;

public class seleniumTest {
    public seleniumTest(String Account, String Password) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ais.ntou.edu.tw/Default.aspx");
        WebElement username = driver.findElement(By.name("M_PORTAL_LOGIN_ACNT"));
        username.sendKeys(Account);
        WebElement password = driver.findElement(By.name("M_PW"));
        password.sendKeys(Password);
        driver.findElement(By.xpath("//*[@id=\"LGOIN_BTN\"]")).click();
        driver.switchTo().frame("menuFrame");
        driver.findElement(By.xpath("//*[@id=\"Menu_TreeViewt1\"]")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/form/div[3]/table/tbody/tr[1]/td/div/div/div/table[3]/tbody/tr/td[5]/a")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/form/div[3]/table/tbody/tr[1]/td/div/div/div/div/table[2]/tbody/tr/td[6]/a")).click();
//        driver.findElement(By.xpath("//*[@id=\"Q_COSID\"]")).sendKeys("B57033MD");
//        driver.findElement(By.xpath("//*[@id=\"QUERY_COSID_BTN\"]")).click();
//        driver.findElement(By.xpath("//*[@id=\"DataGrid1_ctl02_edit\"]")).click();
        //將登入資料傳送到資料庫
//        connectToSQL connectToSQL = new connectToSQL();
//        connectToSQL.studentInfo(Account, Password);
    }
}