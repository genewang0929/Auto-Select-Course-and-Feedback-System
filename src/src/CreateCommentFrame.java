import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateCommentFrame extends JFrame implements ActionListener {
    private String userName;
    private String className;
    private JLabel create_comment;
    private JButton submit;
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
        submit = new JButton("確認");
        add(submit, BorderLayout.SOUTH);

        //不熟悉JTextArea
        //comment = new JTextArea();
        //TODO

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit) {
            ConnectToSQL conn = new ConnectToSQL();
            conn.insertComment(userName, comment.getText(), className);
            //尚須update
            //TODO
        }
    }
}
