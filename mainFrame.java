import org.w3c.dom.html.HTMLIsIndexElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainFrame extends JFrame implements ActionListener{

    private JButton login,createAccount;
    private JFrame mainApp;
    public void open(){
        //主介面
        mainApp=new JFrame("自動選課小幫手");
        mainApp.setSize(500,500);
        mainApp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainApp.setLocationRelativeTo(null);//置中
        //以上除了size外先不要動

        //Botton
        login=new JButton("登入");
        createAccount=new JButton("創建新帳戶");
        login.addActionListener(this);//事件監聽
        createAccount.addActionListener(this);
        //Label
        JLabel label=new JLabel("登入或創建新帳戶     ");

        //Panel
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        mainApp.setContentPane(panel);
        panel.add(label);
        panel.add(login);
        panel.add(createAccount);

        mainApp.setVisible(true);//這個放最後面
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==login){//跳轉登陸介面
            mainApp.dispose();//關掉視窗
            loginFrame next=new loginFrame();
            next.open();
        }
        else if(event.getSource()==createAccount){//跳轉創建帳號頁面
            mainApp.dispose();
            createAccountFrame next=new createAccountFrame();
            next.open();
        }
    }
}
