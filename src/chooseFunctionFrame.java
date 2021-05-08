import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class chooseFunctionFrame extends JFrame implements ActionListener {
    private JButton comment,chooseClass;
    private JFrame chooseFunction;
    static int mouseAtX;
    static int mouseAtY;
    public void open(){
        //主介面
        chooseFunction=new JFrame("自動選課小幫手");
        chooseFunction.setSize(500,500);
        chooseFunction.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        chooseFunction.setLocationRelativeTo(null);//置中
        chooseFunction.setUndecorated(true);//視窗去邊框
        chooseFunction.setAlwaysOnTop(true);//設定視窗總在最前
        chooseFunction.setBackground(new Color(0,0,0,0));//設定視窗背景為透明色
        //以上除了size外先不要動
        chooseFunction.addMouseListener(new MouseAdapter() 		//設定視窗可拖動
        {
            public void mousePressed(MouseEvent e)
            {
                mouseAtX = e.getPoint().x;
                mouseAtY= e.getPoint().y;
            }
        });
        chooseFunction.addMouseMotionListener(new MouseMotionAdapter()
        {
            public void mouseDragged(MouseEvent e)
            {
                chooseFunction.setLocation((e.getXOnScreen()-mouseAtX),(e.getYOnScreen()-mouseAtY));//設定拖拽後，視窗的位置
            }
        });

        //Botton
        chooseClass=new JButton("搶課!");
        comment=new JButton("評論區");
        chooseClass.addActionListener(this);//事件監聽
        comment.addActionListener(this);
        //Label
        JLabel label=new JLabel("登入或創建新帳戶     ");

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
            loginFrame next=new loginFrame();
            next.open();
        }
        else if(event.getSource()==comment){
            chooseFunction.dispose();
            createAccountFrame next=new createAccountFrame();
            next.open();
        }
    }
}
