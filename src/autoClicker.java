import org.openqa.selenium.WebDriver;

import java.awt.AWTException;
import java.awt.Robot;
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
    private JLabel currentFunction;
    private Timer timer;
    private TimerTask task;
    private String username;
    private WebDriver driver;
    private ArrayList<String> name;
    private boolean[] log;
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
        currentFunction=new JLabel("按Enter鍵開始選課",SwingConstants.CENTER);
        clicker.add(currentFunction);
    }
    public void start(){
        String text="當前狀態:\n";
        currentFunction.setText(text);
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
        log=new boolean[name.size()];
        for(int i=0;i<name.size();i++){
            s.idOneClick(name.get(i));
            //sleep(1);
            log[i]=judge(name.get(i));
            text+=name.get(i)+" "+log[i]+"\n";
            clicker.revalidate();
        }
        for(int i=0;i<name.size();i++){
            if(log[i]==false)
                s.idClicking(name.get(i));
        }

    }
    public boolean judge(String target){
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
