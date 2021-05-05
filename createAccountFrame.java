import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createAccountFrame extends JFrame implements ActionListener {
    //這邊全部超前面 還要改
    private JFrame createAccountFrame;
    private JButton submit,back;
    public void open(){
        //主介面
        createAccountFrame=new JFrame("登入");
        createAccountFrame.setSize(500,500);
        createAccountFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createAccountFrame.setLocationRelativeTo(null);//置中
        //以上除了size外先不要動

        //Botton
        submit=new JButton("送出");
        back=new JButton("回上頁");
        submit.addActionListener(this);//事件監聽
        back.addActionListener(this);

        //Label
        JLabel label=new JLabel("輸入帳號密碼");

        //Panel
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        createAccountFrame.setContentPane(panel);
        panel.add(label);
        panel.add(submit);
        panel.add(back);

        createAccountFrame.setVisible(true);//這放最後面
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==null);

    }
}
