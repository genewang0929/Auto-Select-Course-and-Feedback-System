public class InsertInfo {
    private String query;
    public InsertInfo() {
        query = "INSERT INTO studentinfo(username, password_, ban) VALUES(?, ?, ?)";
    }

    public String getQuery() {
        return this.query;
    }
}