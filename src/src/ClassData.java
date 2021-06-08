import java.util.ArrayList;

public class ClassData {
    private String userName;
    private String comment;
    private String create_time;

    public ClassData(String userName, String comment, String create_time) {
        this.userName = userName;
        this.comment = comment;
        this.create_time = create_time;
    }

    public String getComment() {
        return comment;
    }

    public String getCreate_time() {
        return create_time;
    }

    public String getUserName() {
        return userName;
    }
}
