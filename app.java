import javax.swing.*;
import java.awt.*;

public class app {
    public static void main(String args[]){
        //主介面
        JFrame mainApp=new JFrame("自動選課小幫手");
        mainApp.setSize(500,500);
        mainApp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainApp.setVisible(true);
        mainApp.setLocationRelativeTo(null);//置中
        //以上除了size外先不要動

        JButton login=new JButton("登入");
        JButton createAccount=new JButton("創建新帳戶");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(login, BorderLayout.NORTH);
        panel.add(createAccount, BorderLayout.SOUTH);
        mainApp.setContentPane(panel);

        mainApp.setVisible(true);//這個放最後面
    }
}
