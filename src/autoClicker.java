import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class autoClicker extends KeyAdapter {
    private int x,y;
    private JFrame clicker;
    public autoClicker(int mode){
        //新增一個frame但invisible=false
        clicker=new JFrame();
        clicker.setSize(200,150);
        clicker.setUndecorated(true);
        clicker.setVisible(true);
        clicker.setAlwaysOnTop(true);
        clicker.addKeyListener(this);
        clicker.setLocation(1280,150);
        clicker.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        if(mode==1){
            //clicker.addKeyListener();

            mod1();


        }
        else if(mode==2){

        }
    }
    public void mod1(){//自動掛機
        //TODO
        //1.進入線上即時加退選介面
        //2.找到"查詢"按鍵位置==(x,y)

        try {
            Robot r = new Robot();
            r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            r.mouseMove(x, y);
            Thread.sleep(4000);
            Thread.interrupted();
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void  keyPressed(KeyEvent e){//如果按shift+f4 程式停止
        if(e.isShiftDown()&&e.getKeyCode()==KeyEvent.VK_F4)
            clicker.dispose();
        else if(e.getKeyCode()==KeyEvent.VK_DOWN)//移動懸浮窗
            clicker.setLocation(clicker.getX(),clicker.getY()+10);
        else if(e.getKeyCode()==KeyEvent.VK_UP)
            clicker.setLocation(clicker.getX(),clicker.getY()-10);
        else if(e.getKeyCode()==KeyEvent.VK_LEFT)
            clicker.setLocation(clicker.getX()-10,clicker.getY());
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
            clicker.setLocation(clicker.getX()+10,clicker.getY());
    }
}
