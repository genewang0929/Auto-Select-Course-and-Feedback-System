import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;

public class CreateClassFrame extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel input_Class;
    private JLabel input_Comment;
    private JTextField inputClass;
    private JTextArea inputComment;
    private JButton submit;
    private String userName;
    public CreateClassFrame(String userName) {
        super("評論區(目前登入:" + userName + ")");
        this.userName = userName;
    }

    public void open() {
        setSize(350,350);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);//置中
        setLayout(new BorderLayout());

        input_Class = new JLabel("輸入課名 : ");
        add(input_Class, BorderLayout.NORTH);
        //沒辦法建JTextField，找不到bug
        // TODO
//        panel = new JPanel(new BorderLayout());
//        inputClass = new JTextField();
//        inputClass.addActionListener(this);
//        panel.add(inputClass);
//        add(panel, BorderLayout.WEST);
        input_Comment = new JLabel("輸入留言 : ");
        add(input_Comment);
        /* 不太熟悉JTextArea
        //TODO
        inputComment = new JTextArea(1, 1);
        add(inputComment);*/

        submit = new JButton("確認");
        submit.addActionListener(this);
        add(submit, BorderLayout.SOUTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit) {
            ConnectToSQL conn = new ConnectToSQL();
            conn.createClass(userName, inputComment.getText(), inputClass.getText());
            dispose();
        }
    }
}
