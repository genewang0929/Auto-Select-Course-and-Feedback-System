import java.sql.Statement;

public class CreateCommentTable {
    String query;
    public CreateCommentTable(String className) {
        query = "CREATE TABLE " + className + " (num SERIAL PRIMARY KEY, "
                + "user_id VARCHAR(50) NOT NULL, "
                + "comment_ VARCHAR(100000) NOT NULL, "
                + "created_on TIMESTAMP)";
    }
    public String getQuery() {
        return this.query;
    }
}