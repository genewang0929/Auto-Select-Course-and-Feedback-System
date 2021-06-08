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
        selenium.acessToSelectClass();
        name=new ArrayList<String>();//使用者輸入的課號
        try {
            Scanner in=new Scanner(Paths.get("./src/classdata.txt"));
            while(in.hasNextLine()){
                name.add(in.nextLine());
            }
        }catch (Exception e){
            System.out.println(e);
        }
        log=new int[name.size()];
        text="<html><body><p align=\"center\">當前狀態:";
        for(int i=0;i<name.size();i++){
            selenium.idOneClick(name.get(i));
            if(selenium.haveBeenSelect(name.get(i)))
                log[i]=1;
            else if(selenium.haveClassTimeClash(name.get(i)))
                log[i]=2;
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
