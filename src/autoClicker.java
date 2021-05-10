import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;import javax.swing.JFrame;
public class autoClicker extends KeyAdapter {
    private int x,y;
    private JFrame clicker;
    public autoClicker(int mode){
        //新增一個frame但invisible=false
        clicker=new JFrame("ds");
        clicker.setVisible(false);
        if(mode==1){//自動掛機
            //clicker.addKeyListener();
            mod1();
        }
        else if(mode==2){

        }
    }
    public void mod1(){
        //TODO
        //1.進入線上即時加退選介面
        //2.找到"查詢"按鍵位置==(x,y)



        try {
            Robot r = new Robot();
            r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            r.mouseMove(x, y);
            Thread.sleep(1000);
            Thread.interrupted();
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
