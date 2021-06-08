/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createAccountFrame extends JFrame implements ActionListener {
    //此頁面可能暫時不會用到
    private JFrame createAccountFrame;
    private JButton submit,back;
    private JTextField account;
    private JPasswordField password,passwordCheck;
    public void open(){
        //主介面
        createAccountFrame=new JFrame("登入");
        createAccountFrame.setSize(500,500);
        createAccountFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createAccountFrame.setLocationRelativeTo(null);//置中
        //以上除了size外先不要動

        //Botton
        submit=new JButton("送出");
        submit.setBounds(150,140,60,30);
        back=new JButton("回上頁");
        back.setBounds(240,140,90,30);
        submit.addActionListener(this);//事件監聽
        back.addActionListener(this);

        //TestField
        account=new JTextField();
        account.setBounds(100,30,150,30);

        //PasswordField
        password=new JPasswordField();
        password.setBounds(100,60,150,30);
        passwordCheck=new JPasswordField();
        passwordCheck.setBounds(100,90,150,30);

        //Label
        JLabel label,label1,label2,label3;
        label=new JLabel("輸入帳號密碼");
        label.setBounds(200,0,100,30);
        label1=new JLabel("帳號");
        label1.setBounds(20,30,150,30);
        label2=new JLabel("密碼");
        label2.setBounds(20,60,150,30);
        label3=new JLabel("再次輸入密碼");
        label3.setBounds(20,90,150,30);
        //Panel
        JPanel panel = new JPanel(null);
        panel.setLayout(null);
        createAccountFrame.setContentPane(panel);
        panel.add(password);
        panel.add(passwordCheck);
        panel.add(account);
        panel.add(label);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(submit);
        panel.add(back);

        createAccountFrame.setVisible(true);//這放最後面
    }
    public void lastPage(){
        createAccountFrame.dispose();
        mainFrame tmp=new mainFrame();
        tmp.open();
    }
    public boolean checkPassword(){
        String a=new String(password.getPassword()),b=new String(passwordCheck.getPassword());
        if(a.length()<8||b.length()<8){
            JOptionPane.showMessageDialog(new JPanel(), "輸入的密碼不能小於8個字", "錯誤", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(!a.equals(b)) {
            JOptionPane.showMessageDialog(new JPanel(), "兩次輸入的密碼不相同", "錯誤", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    public boolean checkAccount(){
        if(account.getText().length()<8){
            JOptionPane.showMessageDialog(new JPanel(),"用戶名需大於8個字","錯誤",JOptionPane.ERROR_MESSAGE);
            //return false;
        }
        // else if(帳號已經存在){
            //TODO
            //資料庫查詢
            //JOptionPane.showMessageDialog(new JPanel(),"用戶名已經存在","錯誤",JOptionPane.ERROR_MESSAGE);
            //return false;
        //}
        return true;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==submit){
            if(checkAccount()&&checkPassword()){
                //TODO
                //資料庫建立新資料
                JOptionPane.showMessageDialog(new JPanel(),"即將跳轉登入介面","提示訊息",JOptionPane.INFORMATION_MESSAGE);
                createAccountFrame.dispose();
                lastPage();
            }
        }
        else if(event.getSource()==back)
            lastPage();
    }
}*/