import org.openqa.selenium.WebDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class mainFrame extends JFrame implements ActionListener{
    private JButton login;
    private JFrame mainApp;
    private JComboBox select;
    private int index;
    private String[][] data;
    public void open(){
        //主介面
        mainApp=new JFrame("自動選課小幫手(尚未登入)");
        mainApp.setSize(500,150);
        mainApp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainApp.setLocationRelativeTo(null);//置中
        mainApp.setLayout(null);
        //以上除了size外先不要動

        //ComboBox
        select=new JComboBox();
        select.addItem("無(輸入帳號密碼)");
        try{
            Scanner in=new Scanner(Paths.get("./src/userdata.txt"));
            index=0;
            data=new String[100][];
            while(in.hasNextLine()){
                String account=in.nextLine();
                data[index]=account.split(" ");
                select.addItem(data[index][0]);
                index++;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        select.setBounds(160,50,150,20);

        //Button
        login=new JButton("登入");
        login.addActionListener(this);//事件監聽
        login.setBounds(200,80,60,30);

        //Label
        JLabel label=new JLabel("請用教學務系統帳密登入"),label1=new JLabel("或選擇已登入帳號");
        label.setBounds(165,0,150,30);
        label1.setBounds(180,20,150,30);

        //Panel
        JPanel panel = new JPanel(null);
        mainApp.setContentPane(panel);
        panel.add(label);
        panel.add(label1);
        panel.add(login);
        panel.add(select);

        mainApp.setVisible(true);//這個放最後面
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==login){//跳轉登入介面
            String Case=(String) select.getSelectedItem();
            mainApp.dispose();//關掉視窗
            if(Case=="無(輸入帳號密碼)") {
                loginFrame next = new loginFrame();
                next.open();
            }
            else{
                WebDriver driver=null;
                for(int i=0;i<index;i++) {
                    if(Case==data[i][0]) {
                        selenium.loginNTOU(data[i][0], data[i][1]);
                    }
                }
                chooseFunctionFrame next=new chooseFunctionFrame(Case);
                next.open();
            }
        }
    }
}
