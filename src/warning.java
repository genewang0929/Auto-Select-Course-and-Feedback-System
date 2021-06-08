import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

public class warning extends JFrame {
    private String className;
    private JFrame warning;
    public warning(String className){
        this.className=className;
    }
    public void open(){
        warning=new JFrame();
        warning.setTitle("提示");
        warning.setSize(200,100);
        JLabel label=new JLabel("課程"+className+"已經可以選了");
        warning.add(label);
        warning.setLocationRelativeTo(null);
        warning.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer timer=new Timer();
        timer.schedule(task,0,200);
        warning.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                warning.dispose();
                task.cancel();
            }
        });
        warning.setVisible(true);

    }
    /*public static void main(String[] args){
        warning a=new warning("軟體工程");
        a.open();
    }*/
}
