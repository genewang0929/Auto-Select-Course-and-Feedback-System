public class InsertInfo {
    private String query;
    public InsertInfo() {
        query = "INSERT INTO StudentInfo(user_id, password_, ban) VALUES(?, ?, ?)";
    }

    public String getQuery() {
        return this.query;
    }
}
