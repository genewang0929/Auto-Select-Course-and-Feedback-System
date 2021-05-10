import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class autoClicker {
    public autoClicker(int mode){
        if(mode==1){//自動掛機
            //TODO
            //1.進入線上即時加退選介面
            //2.找到"查詢"按鍵位置==(x,y)
            int x=0,y=0;
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
        else if(mode==2){

        }
    }
}
