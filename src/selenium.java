import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.event.InputEvent;

public class selenium {
    private static WebDriver driver;
    private static WebDriverWait wait;
    public WebDriver getDriver(){
        return this.driver;
    }
    public void setDriver2(WebDriver driver){
        this.driver=driver;
    }
    public static  void setDriver(){
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver,5);
    }
    public  void loginNTOU(String Account, String Password) {
        setDriver();
        driver.get("https://ais.ntou.edu.tw/Default.aspx");
        WebElement username = driver.findElement(By.name("M_PORTAL_LOGIN_ACNT"));
        username.sendKeys(Account);
        WebElement password = driver.findElement(By.name("M_PW"));
        password.sendKeys(Password);
        driver.findElement(By.xpath("//*[@id=\"LGOIN_BTN\"]")).click();

        //將登入資料傳送到資料庫
        if(!driver.getCurrentUrl().equals("https://ais.ntou.edu.tw/MainFrame.aspx"))
            System.out.println("Login Error");
        else {
            try {
                connectToSQL connectToSQL = new connectToSQL();
                connectToSQL.studentInfo(Account, Password);
            }catch (Exception e){
                System.out.println(e);
            }
        }
        //acessToSelectClass();
    }

    public  void acessToSelectClass(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame("menuFrame");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Menu_TreeViewt1\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/table/tbody/tr[1]/td/div/div/div/table[3]/tbody/tr/td[5]/a"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/table/tbody/tr[1]/td/div/div/div/div/table[2]/tbody/tr/td[6]/a"))).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("mainFrame");


        //idClicking("B570339Q");
    }
    public  void idSearch(String target){
        driver.findElement(By.xpath("//*[@id=\"Q_COSID\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"Q_COSID\"]")).sendKeys(target);
        driver.findElement(By.xpath("//*[@id=\"QUERY_COSID_BTN\"]")).click();
    }
    public  void idClicking(String target){
        idSearch(target);

        while (true){
            try {
                driver.findElement(By.xpath("/html/body/form/div[3]/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table[3]/tbody/tr[2]/td[2]/div/div/table/tbody/tr[2]/td[1]/a")).click();
                wait.until( ExpectedConditions.alertIsPresent()).accept();

            }catch (Exception e){
                //System.out.println(e);
            }
        }
    }
    public void idOneClick(String target){
        idSearch(target);
        try {
            driver.findElement(By.xpath("/html/body/form/div[3]/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table[3]/tbody/tr[2]/td[2]/div/div/table/tbody/tr[2]/td[1]/a")).click();
            wait.until( ExpectedConditions.alertIsPresent()).accept();

        }catch (Exception e){
            //System.out.println(e);
        }
    }


    public  void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }
}