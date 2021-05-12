import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class autoClicker extends KeyAdapter {
    private int x,y;
    private JFrame clicker;
    private JLabel currentFunction;
    private Timer timer;
    private TimerTask task;
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
        currentFunction.setText("閒置模式");
        openBrowser();
        sleep(6);
        oneClick(80,255);//教務系統
        sleep(2);
        oneClick(80,320);//選課系統
        sleep(2);
        oneClick(100,370);//線上即時加退選
        sleep(2);
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
    public void openBrowser(){
        try {
            String url="https://ais.ntou.edu.tw/MainFrame.aspx";//請先提前登入教學務系統
            java.net.URI uri = java.net.URI.create(url);
            // 獲取當前系統桌面擴充套件
            java.awt.Desktop dp = java.awt.Desktop.getDesktop();
            // 判斷系統桌面是否支援要執行的功能
            if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
                dp.browse(uri);
                // 獲取系統預設瀏覽器開啟連結
            }
        } catch (java.lang.NullPointerException e) {
            // 此為uri為空時丟擲異常
            e.printStackTrace();
        } catch (java.io.IOException e) {
            // 此為無法獲取系統預設瀏覽器
            e.printStackTrace();
        }
    }
    public void mod1(){//自動掛機
        currentFunction.setText("掛機模式");
        clicker.add(currentFunction);
        clicker.setVisible(true);
        task=new TimerTask() {
            @Override
            public void run() {//連點
                oneClick(377,339);//查詢鍵
            }
        };
        timer=new Timer();
        timer.schedule(task, 1000, 2000);//每兩秒點一次
    }
    @Override
    public void  keyPressed(KeyEvent e){//如果按shift+f4 程式停止
        if(e.isShiftDown()&&e.getKeyCode()==KeyEvent.VK_F4) {
            task.cancel();
            clicker.dispose();
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
        else if(e.getKeyCode()==KeyEvent.VK_F1) {//按F1進入掛機mod shift+F1離開掛機mod
            if(e.isShiftDown()) {
                task.cancel();
                currentFunction.setText("閒置模式");
            }
            else
                mod1();
        }
    }
}
