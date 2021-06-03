import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class chooseFunctionFrame extends JFrame implements ActionListener {
    private JButton comment,chooseClass;
    private JFrame chooseFunction;
    private String username;
    public chooseFunctionFrame(String username){
        this.username=username;
    }
    public void open(){
        //主介面
        chooseFunction=new JFrame("自動選課小幫手(目前登入:"+username+")");
        chooseFunction.setSize(500,150);
        chooseFunction.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        chooseFunction.setLocationRelativeTo(null);//置中
        //以上除了size外先不要動


        //Botton
        chooseClass=new JButton("搶課!");
        comment=new JButton("評論區");
        chooseClass.addActionListener(this);//事件監聽
        comment.addActionListener(this);
        chooseClass.setBounds(140,50,70,30);
        comment.setBounds(240,50,90,30);

        //Label
        JLabel label=new JLabel("選擇功能");
        label.setBounds(200,0,50,30);

        //Panel
        JPanel panel = new JPanel(null);
        chooseFunction.setContentPane(panel);
        panel.add(label);
        panel.add(chooseClass);
        panel.add(comment);
        panel.setOpaque(false);
        chooseFunction.setVisible(true);//這個放最後面
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==chooseClass){
            chooseFunction.dispose();//關掉視窗
            enterClassFrame next=new enterClassFrame(username);
            next.open();
        }
        else if(event.getSource()==comment){
            chooseFunction.dispose();
            commentAreaFrame next=new commentAreaFrame(username);
            next.open();
        }
    }
}
