import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class chooseFunctionFrame extends JFrame implements ActionListener {
    private JButton comment,chooseClass;
    private JFrame chooseFunction;
    public void open(){
        //主介面
        chooseFunction=new JFrame("自動選課小幫手");
        chooseFunction.setSize(500,500);
        chooseFunction.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        chooseFunction.setLocationRelativeTo(null);//置中
        //以上除了size外先不要動


        //Botton
        chooseClass=new JButton("搶課!");
        comment=new JButton("評論區");
        chooseClass.addActionListener(this);//事件監聽
        comment.addActionListener(this);
        //Label
        JLabel label=new JLabel("選擇功能    ");

        //Panel
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
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
            enterClassFrame next=new enterClassFrame();
            next.open();
        }
        else if(event.getSource()==comment){
            chooseFunction.dispose();
            createAccountFrame next=new createAccountFrame();
            next.open();
        }
    }
}
