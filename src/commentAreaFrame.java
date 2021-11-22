import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class commentAreaFrame extends JFrame implements ActionListener {
    private JFrame commentAreaFrame;
    private JScrollPane sp;
    private JButton createComment, back;
    private JPanel showClass;
    private String username;
    private String className;
    private int index;
    private ArrayList<CheckClass> allCheck = new ArrayList<CheckClass>();
    public commentAreaFrame(String username){
        this.username=username;
    }
    public void open(){
        //主介面
        commentAreaFrame = new JFrame("評論區(目前登入:"+username+")");
        commentAreaFrame.setSize(500,500);
        commentAreaFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        commentAreaFrame.setLocationRelativeTo(null);//置中
        //以上除了size外先不要動

        //Button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        createComment = new JButton("新增課程");
        back = new JButton("回上頁");
        createComment.addActionListener(this);//事件監聽
        back.addActionListener(this);
        buttonPanel.add(back);
        buttonPanel.add(createComment);
        commentAreaFrame.add(buttonPanel, BorderLayout.SOUTH);

        showClass = new JPanel();
        showClass.setLayout(new GridLayout(0, 1));
        commentAreaFrame.add(showClass);

        //顯示課程，用scrollbar和scrollpane
        //TODO
        sp = new JScrollPane(showClass);
        commentAreaFrame.add(sp);

        loadClass();

        commentAreaFrame.setVisible(true);//這放最後面
    }

    public void loadClass() {
        ConnectToSQL conn = new ConnectToSQL();
        ArrayList<String> classArr = conn.getAllClassName();
        for(String item : classArr) {
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.setSize(new Dimension(50, 50));
            JTextField name = new JTextField(item);
            name.setFont(new Font("Consolos", Font.BOLD, 30));
            name.setHorizontalAlignment(JTextField.CENTER);
            name.setEditable(false);
            JButton check = new JButton("查看");
            //check.addActionListener(this);
            allCheck.add(new CheckClass(check, item));
            panel.add(name, BorderLayout.CENTER);
            panel.add(check, BorderLayout.EAST);
            showClass.add(panel);
        }
        checkList();
    }

    public void checkList() {
        for(int i = 0; i < allCheck.size(); i++)
            allCheck.get(i).getButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == createComment){
            CreateClassFrame tmp = new CreateClassFrame(username);
            commentAreaFrame.dispose();
            tmp.open();
        }
        else if(event.getSource() == back){
            commentAreaFrame.dispose();
            chooseFunctionFrame tmp=new chooseFunctionFrame(username);
            tmp.open();
        }
        else {
            commentAreaFrame.dispose();
            //鎖定課名，使點擊查看可以連到該留言板
            for(int i = 0; i < allCheck.size(); i++) {
                if(event.getSource() == allCheck.get(i).getButton())
                    index = i;
            }
            CommentFrame tmp = new CommentFrame(username, allCheck.get(index).getClassName());
            tmp.open();
        }
    }
}
