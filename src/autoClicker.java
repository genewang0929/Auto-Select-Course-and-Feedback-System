import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class autoClicker extends KeyAdapter {
    private JFrame clicker;
    private JLabel showLog;
    private Timer timer;
    private TimerTask task;
    private String username;
    private WebDriver driver;
    private ArrayList<String> name;
    private String[] msg={"尚未選到","已經擁有這門課","衝堂"};
    private int[] log;
    public autoClicker(String username,WebDriver driver){
        this.driver=driver;
        this.username=username;
    }
    public void open(){
        clicker=new JFrame();
        clicker.setSize(200,150);
        clicker.setUndecorated(true);
        clicker.setVisible(true);
        clicker.setAlwaysOnTop(true);
        clicker.addKeyListener(this);
        clicker.setLocation(1280,150);
        clicker.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        showLog=new JLabel("按Enter鍵開始選課");
        JPanel panel=new JPanel(null);
        panel.add(showLog);
        clicker.setContentPane(panel);
        showLog.setBounds(50,0,200,150);
    }
    public void start(){
        String text="";
        selenium s=new selenium();
        s.setDriver2(driver);
        s.acessToSelectClass();
        name=new ArrayList<String>();//使用者輸入的課號
        try {
            Scanner in=new Scanner(Paths.get("src\\classdata.txt"));
            while(in.hasNextLine()){
                name.add(in.nextLine());
            }
        }catch (Exception e){
            System.out.println(e);
        }
        log=new int[name.size()];
        text="<html><body><p align=\"center\">當前狀態:";
        for(int i=0;i<name.size();i++){
            s.idOneClick(name.get(i));
            if(haveBeenSelect(name.get(i)))
                log[i]=1;
            text+="<br/>"+name.get(i)+" "+msg[log[i]];
        }
        text+="</p></body></html>";
        showLog.setText(text);
        clicker.revalidate();
        /*for(int i=0;i<name.size();i++){
            if(log[i]==false)
                s.idClicking(name.get(i));
        }*/
    }
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
    public boolean haveBeenSelect(String target){
        int haveBeenSelectNum=0;
        try {
            haveBeenSelectNum=Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"LISTNUM3\"]")).getText());
        }catch (Exception e){
            System.out.println(e);
        }
        //System.out.println(haveBeenSelectNum+"\n\n\n\n");
        for (int i = 2; i <= haveBeenSelectNum+1; i++) {
           // System.out.println(driver.findElement(By.xpath("//*[@id=\"DataGrid3\"]/tbody/tr["+i+"]/td[7]")).getText()+"\n\n\n\n");
            if(driver.findElement(By.xpath("//*[@id=\"DataGrid3\"]/tbody/tr["+i+"]/td[2]")).getText().equals(target))
                return true;
        }
        return false;

    }
    public void sleep(int n){
        try {
            java.util.concurrent.TimeUnit.SECONDS.sleep(n);
        }catch (Exception e){
            return;
        }
    }
    public void oneClick(int x,int y){
        try{
            Robot r = new Robot();
            r.mouseMove(x, y);
            r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }catch (AWTException e){
            e.printStackTrace();
        }
    }


    @Override
    public void  keyPressed(KeyEvent e){//如果按shift+f4 程式停止
        if(e.isShiftDown()&&e.getKeyCode()==KeyEvent.VK_F4) {
            clicker.dispose();
            task.cancel();
            return;
        }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN)//移動懸浮窗 use 上下左右鍵
            clicker.setLocation(clicker.getX(),clicker.getY()+10);
        else if(e.getKeyCode()==KeyEvent.VK_UP)
            clicker.setLocation(clicker.getX(),clicker.getY()-10);
        else if(e.getKeyCode()==KeyEvent.VK_LEFT)
            clicker.setLocation(clicker.getX()-10,clicker.getY());
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
            clicker.setLocation(clicker.getX()+10,clicker.getY());
        else if(e.getKeyCode()==KeyEvent.VK_ENTER)
            start();

    }
}
