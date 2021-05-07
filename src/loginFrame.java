import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginFrame extends JFrame implements ActionListener {
    private JFrame loginFrame;
    private JButton back,submit;
    public void open(){
        //主介面
        loginFrame=new JFrame("登入");
        loginFrame.setSize(500,500);
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);//置中
        //以上除了size外先不要動

        //Botton
        submit=new JButton("送出");
        submit.setBounds(150,100,60,30);
        back=new JButton("回上頁");
        back.setBounds(240,100,90,30);
        submit.addActionListener(this);//事件監聽
        back.addActionListener(this);

        //TestField
        JTextField account=new JTextField();
        account.setBounds(100,30,150,30);

        //PasswordField
        JPasswordField passowrd=new JPasswordField();
        passowrd.setBounds(100,60,150,30);

        //Label
        JLabel label,label1,label2;
        label=new JLabel("輸入帳號密碼");
        label.setBounds(200,0,100,30);
        label1=new JLabel("帳號");
        label1.setBounds(30,30,150,30);
        label2=new JLabel("密碼");
        label2.setBounds(30,60,150,30);
        //Panel
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setLayout(null);
        loginFrame.setContentPane(panel);
        panel.add(passowrd);
        panel.add(account);
        panel.add(label);
        panel.add(label1);
        panel.add(label2);
        panel.add(submit);
        panel.add(back);

        loginFrame.setVisible(true);//這放最後面
    }
    public void errorMessage(int type){
        String msg="";
        if(type==1)
            msg="帳號錯誤或不存在";
        else if(type==2)
            msg="密碼錯誤";
        JOptionPane.showMessageDialog(new JPanel(),msg,"錯誤",JOptionPane.ERROR_MESSAGE);
    }
    public void lastPage(){
        loginFrame.dispose();
        mainFrame tmp=new mainFrame();
        tmp.open();
    }
    public int checkAccount(){
        return 2;
        //TODO
        //驗證帳密是否正確，負責資料庫的人寫
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==back)
            lastPage();
        else if(event.getSource()==submit){
            int pass=checkAccount();
            if(pass==0){
                loginFrame.dispose();
                autoClickerFrame next=new autoClickerFrame();
                next.open();
            }
            else
                errorMessage(pass);
        }
    }
}
