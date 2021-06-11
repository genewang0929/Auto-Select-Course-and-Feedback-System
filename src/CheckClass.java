import javax.swing.*;

public class CheckClass {
    private JButton button;
    private String className;

    public CheckClass(JButton button, String className) {
        this.button = button;
        this.className = className;
    }

    public JButton getButton() {
        return button;
    }

    public String getClassName() {
        return className;
    }
}
