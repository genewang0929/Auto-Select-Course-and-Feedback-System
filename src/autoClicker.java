import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class autoClicker extends KeyAdapter {
    private JFrame clicker;
    private JLabel currentFunction;
    private Timer timer;
    private TimerTask task;
    private String username;
    public autoClicker(String username){
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
    public void sleep(int n){
        try {
            java.util.concurrent.TimeUnit.SECONDS.sleep(n);
        }catch (Exception e){
            return;
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
        /*else if(e.getKeyCode()==KeyEvent.VK_ENTER)
            start();*/
        else if(e.getKeyCode()==KeyEvent.VK_F1) {//按F1進入掛機mod shift+F1離開掛機mod
            if(e.isShiftDown()) {
                task.cancel();
                currentFunction.setText("閒置模式");
            }
            /*else
                mod1();*/
        }
    }
}
