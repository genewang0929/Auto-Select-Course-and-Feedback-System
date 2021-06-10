import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CommentFrame extends JFrame implements ActionListener {
    private String userName;
    private String className;
    private JButton createComment, back;
    private JPanel buttonPanel;
    private JPanel titlePanel;
    private JPanel showComment;
    private ClassData currentClassData;
    public CommentFrame(String userName, String className) {
        super("評論區(目前登入:" + userName + ")");
        this.userName = userName;
        this.className = className;
    }

    public void open() {
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//置中

        //Button
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        createComment = new JButton("留言");
        back = new JButton("回上頁");
        createComment.addActionListener(this);//事件監聽
        back.addActionListener(this);
        buttonPanel.add(back);
        buttonPanel.add(createComment);
        add(buttonPanel, BorderLayout.SOUTH);

        //標題
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.CYAN);
        titlePanel.setPreferredSize(new Dimension(100, 100));
        titlePanel.setLayout(new BorderLayout());
        JTextField title = new JTextField(className);
        title.setFont(new Font("Consolos", Font.BOLD, 30));
        title.setHorizontalAlignment(JTextField.CENTER);
        title.setEditable(false);
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);

        //顯示留言，用scrollbar和scrollpane
        //TODO
        showComment = new JPanel();
        showComment.setLayout(new GridLayout(15, 1));
        loadComment();
        add(showComment);

        setVisible(true);
    }

    public void loadComment() {
        ConnectToSQL conn = new ConnectToSQL();
        ArrayList<ClassData> classArr = conn.getComment(className);
        for(ClassData item : classArr) {
            currentClassData = item;
            JPanel panel = new JPanel(new BorderLayout());
            JLabel user = new JLabel(currentClassData.getUserName());
            JTextField comm = new JTextField(currentClassData.getComment());
            comm.setEditable(false);
            JLabel time = new JLabel(currentClassData.getCreate_time());
            panel.add(user, BorderLayout.WEST);
            panel.add(comm, BorderLayout.CENTER);
            panel.add(time, BorderLayout.EAST);
            showComment.add(panel);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == createComment){
            CreateCommentFrame tmp = new CreateCommentFrame(userName, className);
            dispose();
            tmp.open();
        }
        else if(e.getSource() == back){
            dispose();
            commentAreaFrame tmp=new commentAreaFrame(userName);
            tmp.open();
        }
    }
}
