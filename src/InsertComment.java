public class insertComment {
    private String query;
    public insertComment(String className) {
        query = "INSERT INTO " + className + "(username, comment_, created_on)"
                + "VALUES (?, ?, CURRENT_TIMESTAMP)";
    }

    public String getQuery() {
        return this.query;
    }
}
