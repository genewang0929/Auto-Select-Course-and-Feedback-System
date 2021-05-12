import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Timer;
import java.util.TimerTask;


public class enterClassFrame extends JFrame implements ActionListener {
    private JFrame enterClassFrame;
    private JButton back,submit;
    private JTextArea className;
    private String[] errorMessage=new String[3];//["課號長度太短","課號長度太長","課號不存在"]
    public void open(){
        //主介面
        enterClassFrame=new JFrame("登入");
        enterClassFrame.setSize(500,500);
        enterClassFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        enterClassFrame.setLocationRelativeTo(null);//置中
        //以上除了size外先不要動

        //Botton
        submit=new JButton("送出");
        submit.setBounds(150,400,60,30);
        back=new JButton("回上頁");
        back.setBounds(240,400,90,30);
        submit.addActionListener(this);//事件監聽
        back.addActionListener(this);

        //TestArea
        className=new JTextArea();
        className.setBounds(175,60,150,300);

        //Label
        JLabel label,label1,label2;
        label=new JLabel("輸入欲選課課號");
        label.setBounds(200,0,100,30);
        label1=new JLabel("輸入多筆請用enter隔開");
        label1.setBounds(175,30,150,30);

        //Panel
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setLayout(null);
        enterClassFrame.setContentPane(panel);
        panel.add(className);
        panel.add(label);
        panel.add(label1);
        panel.add(submit);
        panel.add(back);

        enterClassFrame.setVisible(true);//這放最後面
    }
    public void errorMessage(int type){
        String msg="";
        if(type==1)
            msg="不存在";
        else if(type==2)
            msg="密碼錯誤";
        JOptionPane.showMessageDialog(new JPanel(),msg,"錯誤",JOptionPane.ERROR_MESSAGE);
    }
    public void startChooseClass(){
        String[] name=className.getText().split("\n");//使用者輸入的課號
        //TODO
        //2.一個填入課號(自動填入)
        autoClicker tool=new autoClicker();
        tool.open();
    }
    public void lastPage(){
        enterClassFrame.dispose();
        chooseFunctionFrame tmp=new chooseFunctionFrame();
        tmp.open();
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==back)
            lastPage();
        else if(event.getSource()==submit){
            enterClassFrame.dispose();
            startChooseClass();
        }
    }
}
