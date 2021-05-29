public class InsertComment {
    String query;
    public InsertComment(String className) {
        query = "INSERT INTO " + className + "(username, comment_, created_on)"
                + "VALUES (?, ?, CURRENT_TIMESTAMP)";
    }

    public String getQuery() {
        return this.query;
    }
}
