import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class commentAreaFrame extends JFrame implements ActionListener {
    private JFrame commentAreaFrame;
    private JButton submit,back;
    private String username;
    public commentAreaFrame(String username){
        this.username=username;
    }
    public void open(){
        //主介面
        commentAreaFrame =new JFrame("評論區(目前登入:"+username+")");
        commentAreaFrame.setSize(500,500);
        commentAreaFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        commentAreaFrame.setLocationRelativeTo(null);//置中
        //以上除了size外先不要動

        //Botton
        submit=new JButton("送出");
        submit.setBounds(150,140,60,30);
        back=new JButton("回上頁");
        back.setBounds(240,140,90,30);
        submit.addActionListener(this);//事件監聽
        back.addActionListener(this);


        //Label
        JLabel label,label1,label2,label3;

        //Panel
        JPanel panel = new JPanel(null);
        panel.setLayout(null);
        commentAreaFrame.setContentPane(panel);
        /*panel.add(label);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);*/
        panel.add(submit);
        panel.add(back);

        commentAreaFrame.setVisible(true);//這放最後面
    }
    public void lastPage(){
        commentAreaFrame.dispose();
        mainFrame tmp=new mainFrame();
        tmp.open();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==submit){

        }
        else if(event.getSource()==back){
            /*commentAreaFrame.dispose();
            chooseFunctionFrame tmp=new chooseFunctionFrame(username);
            tmp.open();*/
        }
    }
}
