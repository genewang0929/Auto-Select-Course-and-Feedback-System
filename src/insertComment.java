public class InsertComment {
    private String query;
    public InsertComment(String className) {
        query = "INSERT INTO " + className + "(user_id, comment_, created_on)"
                + "VALUES (?, ?, CURRENT_TIMESTAMP)";
    }

    public String getQuery() {
        return this.query;
    }
}