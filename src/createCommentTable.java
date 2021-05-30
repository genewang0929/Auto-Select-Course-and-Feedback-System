import java.sql.Statement;

public class createCommentTable {
    String query;
    public createCommentTable(String className) {
        query = "CREATE TABLE " + className + " (num SERIAL PRIMARY KEY, "
                + "user_id VARCHAR(50) NOT NULL, "
                + "comment_ VARCHAR(100000) NOT NULL, "
                + "created_on TIMESTAMP)";
    }
    public String getQuery() {
        return this.query;
    }
}
