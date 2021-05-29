import java.sql.Statement;

public class CreateTable {
    String query;
    public CreateTable(String className) {
        query = "CREATE TABLE " + className + " (user_id SERIAL PRIMARY KEY, "
                + "username VARCHAR(50) NOT NULL, "
                + "comment_ VARCHAR(100000) NOT NULL, "
                + "created_on TIMESTAMP)";
    }
    public String getQuery() {
        return this.query;
    }
}
