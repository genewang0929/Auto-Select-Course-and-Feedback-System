import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;

public class CreateClassFrame extends JFrame implements ActionListener {
    private JPanel panel;
    private JPanel panel2;
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

        panel = new JPanel(new BorderLayout());
        input_Class = new JLabel("輸入課名 : ");
        inputClass = new JTextField();
        panel.add(input_Class, BorderLayout.WEST);
        panel.add(inputClass, BorderLayout.CENTER);
        add(panel, BorderLayout.NORTH);

        panel2 = new JPanel(new GridLayout(2, 1));
        input_Comment = new JLabel("輸入留言 : ");
        panel2.add(input_Comment);
        inputComment = new JTextArea();
        inputComment.setLineWrap(true);
        panel2.add(inputComment);
        add(panel2, BorderLayout.CENTER);

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
