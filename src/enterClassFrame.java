import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class enterClassFrame extends JFrame implements ActionListener {
    private JFrame enterClassFrame;
    private JButton back,submit;
    private JTextArea className;
    private String[] errorMessage=new String[3];//["課號長度太短","課號長度太長","課號不存在"]
    public void open(){
        //主介面
        enterClassFrame=new JFrame("登入");
        enterClassFrame.setSize(500,500);
        enterClassFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        enterClassFrame.setLocationRelativeTo(null);//置中
        //以上除了size外先不要動

        //Botton
        submit=new JButton("送出");
        submit.setBounds(150,400,60,30);
        back=new JButton("回上頁");
        back.setBounds(240,400,90,30);
        submit.addActionListener(this);//事件監聽
        back.addActionListener(this);

        //TestArea
        className=new JTextArea();
        className.setBounds(175,60,150,300);

        //Label
        JLabel label,label1,label2;
        label=new JLabel("輸入欲選課課號");
        label.setBounds(200,0,100,30);
        label1=new JLabel("輸入多筆請用enter隔開");
        label1.setBounds(175,30,150,30);

        //Panel
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setLayout(null);
        enterClassFrame.setContentPane(panel);
        panel.add(className);
        panel.add(label);
        panel.add(label1);
        panel.add(submit);
        panel.add(back);

        enterClassFrame.setVisible(true);//這放最後面
    }
    public void errorMessage(int type){
        String msg="";
        if(type==1)
            msg="不存在";
        else if(type==2)
            msg="密碼錯誤";
        JOptionPane.showMessageDialog(new JPanel(),msg,"錯誤",JOptionPane.ERROR_MESSAGE);
    }
    public void openBrowser(){
        try {
            String url="https://ais.ntou.edu.tw/MainFrame.aspx";//請先提前登入教學務系統
            java.net.URI uri = java.net.URI.create(url);
            // 獲取當前系統桌面擴充套件
            java.awt.Desktop dp = java.awt.Desktop.getDesktop();
            // 判斷系統桌面是否支援要執行的功能
            if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
                dp.browse(uri);
                // 獲取系統預設瀏覽器開啟連結
            }
        } catch (java.lang.NullPointerException e) {
            // 此為uri為空時丟擲異常
            e.printStackTrace();
        } catch (java.io.IOException e) {
            // 此為無法獲取系統預設瀏覽器
            e.printStackTrace();
        }
    }
    public void startChooseClass(){
        String[] name=className.getText().split("\n");//使用者輸入的課號
        openBrowser();
        //TODO
        //1.從教學務系統首頁進入選課頁面
        //2.一個填入課號(自動填入)
    }
    public void lastPage(){
        enterClassFrame.dispose();
        chooseFunctionFrame tmp=new chooseFunctionFrame();
        tmp.open();
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==back)
            lastPage();
        else if(event.getSource()==submit){
            startChooseClass();
        }
    }
}
