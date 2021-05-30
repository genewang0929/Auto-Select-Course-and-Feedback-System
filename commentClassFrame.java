import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class commentClassFrame extends JFrame implements ActionListener {
    //這邊全部超前面 還要改
    private JFrame commentFrame;
    private JButton submit,back;
    private JTable classImformation;
    public void open(){
        int []time={206,207,208};
        Class verilog=new Class("8177818","非常LAG",false,"馬永倉","",time);
        final Object[] columnTitle = {"課號" , "課名" , "必修","老師","照片"};
        Object[][] tableData =
                {
                        new Object[]{verilog.id , verilog.ChineseName , verilog.compulsory,verilog.teacherName,verilog.teacherPhoto}

                };
        classImformation = new JTable(tableData , columnTitle);
        //主介面
        commentFrame=new JFrame("課程");
        commentFrame.setSize(500,500);
        commentFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        commentFrame.setLocationRelativeTo(null);//置中
        //以上除了size外先不要動

        //Botton
        submit=new JButton("送出");
        submit.setBounds(150,140,60,30);
        back=new JButton("回上頁");
        back.setBounds(240,140,90,30);
        submit.addActionListener(this);//事件監聽
        back.addActionListener(this);





        //Label
        JLabel label;
        label=new JLabel("課程詳細資訊");
        //Panel
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setLayout(null);
        commentFrame.setContentPane(panel);
        panel.add(label);
        panel.add(classImformation);
        panel.add(submit);
        panel.add(back);

        commentFrame.setVisible(true);//這放最後面
    }
    public void lastPage(){
        commentFrame.dispose();
        mainFrame tmp=new mainFrame();
        tmp.open();
    }


    @Override
    public void actionPerformed(ActionEvent event) {

        if(event.getSource()==back)
            lastPage();
    }
}
