import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        warning.setSize(300,200);
        warning.setLayout(null);
        JLabel label=new JLabel("課程"+className+"已經可以選了，是否加選?");
        label.setBounds(0,50,300,30);
        JButton yes=new JButton("是");
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                warning.dispose();
            }
        });

        warning.add(label);
        warning.setLocationRelativeTo(null);
        warning.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                Toolkit.getDefaultToolkit().beep();
            }
        };
        JButton no=new JButton("忍痛放棄");
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                warning.dispose();
                task.cancel();
            }
        });
        yes.setBounds(60,80,50,30);
        no.setBounds(120,80,100,30);
        warning.add(yes);
        warning.add(no);
        Timer timer=new Timer();
        timer.schedule(task,0,400);
        warning.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                warning.dispose();
                task.cancel();
            }
        });
        warning.setVisible(true);

    }
}