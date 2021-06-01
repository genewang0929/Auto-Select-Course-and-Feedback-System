public class insertInfo {
    private String query;
    public insertInfo() {
        query = "INSERT INTO StudentInfo(user_id, password_, ban) VALUES(?, ?, ?)";
    }

    public String getQuery() {
        return this.query;
    }
}
