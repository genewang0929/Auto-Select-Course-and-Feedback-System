import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateCommentFrame extends JFrame implements ActionListener {
    private String userName;
    private String className;
    private JLabel create_comment;
    private JButton submit;
    private JButton back;
    private JTextArea comment;
    public CreateCommentFrame(String userName, String className) {
        super("評論區(目前登入:" + userName + ")");
        this.userName = userName;
        this.className = className;
    }

    public void open() {
        setSize(350,350);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);//置中
        setLayout(new BorderLayout());

        create_comment = new JLabel("新增留言 : ");
        add(create_comment, BorderLayout.NORTH);

        comment = new JTextArea();
        add(comment, BorderLayout.CENTER);

        submit = new JButton("確認");
        submit.addActionListener(this);
        back = new JButton("回上頁");
        back.addActionListener(this);
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(back);
        panel.add(submit);
        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit) {
            ConnectToSQL conn = new ConnectToSQL();
            conn.insertComment(userName, comment.getText(), className, true);
            dispose();
        }
        else {
            dispose();
            CommentFrame cf = new CommentFrame(userName, className);
            cf.open();
        }
    }
}
