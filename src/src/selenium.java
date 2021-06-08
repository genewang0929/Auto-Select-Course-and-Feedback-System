import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class selenium {
    private static WebDriver driver;
    private static WebDriverWait wait;
    public WebDriver getDriver(){
        return this.driver;
    }
    public static  void setDriver(){
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver,8);
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
        /*
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
        */
    }

    public static void acessToSelectClass(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame("menuFrame");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Menu_TreeViewt1\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/table/tbody/tr[1]/td/div/div/div/table[3]/tbody/tr/td[5]/a"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/table/tbody/tr[1]/td/div/div/div/div/table[2]/tbody/tr/td[6]/a"))).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("mainFrame");


    }
    public static void idSearch(String target){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Q_COSID\"]"))).clear();
        driver.findElement(By.xpath("//*[@id=\"Q_COSID\"]")).sendKeys(target);
        driver.findElement(By.xpath("//*[@id=\"QUERY_COSID_BTN\"]")).click();
    }
    public static void idClicking(String target){
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
    public static void idOneClick(String target){
        idSearch(target);
        try {
            driver.findElement(By.xpath("/html/body/form/div[3]/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table[3]/tbody/tr[2]/td[2]/div/div/table/tbody/tr[2]/td[1]/a")).click();
            wait.until( ExpectedConditions.alertIsPresent()).accept();

        }catch (Exception e){
            //System.out.println(e);
        }
    }


    public  static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //href="javascript:__doPostBack('DataGrid1$ctl02$dolink','')"
    public static void idClearClicking(String target){
        idSearch(target);
        JavascriptExecutor executor = ((JavascriptExecutor)driver);
        executor.executeScript("document.getElementById('DataGrid1_ctl02_dolink').click()");
        System.out.print("人數上限:  ");
        //System.out.println(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"M_MAX_ST\"]"))).getText());
        System.out.println("目前人數:  "+driver.findElement(By.xpath("//*[@id=\"M_CHOICE_QTY\"]")).getText());
        executor.executeScript("top.mainFrame.$.fancybox.close();");
        while (true){
            try {
                executor.executeScript("document.getElementById('DataGrid1_ctl02_dolink').click()");
                System.out.println("目前人數:  "+driver.findElement(By.xpath("//*[@id=\"M_CHOICE_QTY\"]")).getText());
                executor.executeScript("top.mainFrame.$.fancybox.close();");
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    //判定是否有加選到那堂課
    public static boolean haveBeenSelect(String target){
        int haveBeenSelectNum=Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"LISTNUM3\"]")).getText());
        for (int i = 2; i <= haveBeenSelectNum+1; i++) {
            if(driver.findElement(By.xpath("//*[@id=\"DataGrid3\"]/tbody/tr["+i+"]/td[2]")).getText().equals(target))
                return true;
        }
        return false;

    }
    //判斷是否衝堂
    public static boolean haveClassTimeClash(String target){
        ArrayList<String> classTime=new ArrayList<String>();
        idSearch(target);
        int haveBeenSelectNum=Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"LISTNUM3\"]")).getText());
        for (int i = 2; i <= haveBeenSelectNum+1; i++) {
            for (String subTime:driver.findElement(By.xpath("//*[@id=\"DataGrid3\"]/tbody/tr["+String.format("%d",i)+"]/td[7]")).getText().split(",")) {
                classTime.add(subTime);
            }
        }

        String classTempTime=driver.findElement(By.xpath("//*[@id=\"DataGrid1\"]/tbody/tr[2]/td[9]")).getText();
        System.out.println(classTempTime);
        for (String subClassTime:classTempTime.split(",")) {
            for (String subTime:classTime) {
                if (subClassTime.equals(subTime))
                    //有衝堂
                    return true;
            }
        }
        //沒有衝堂
        return false;
    }
}
