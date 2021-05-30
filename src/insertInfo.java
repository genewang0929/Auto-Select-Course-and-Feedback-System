public class insertInfo {
    private String query;
    public insertInfo() {
        query = "INSERT INTO StudentInfo(user_id, password_, studentName) VALUES(?, ?, ?)";
    }

    public String getQuery() {
        return this.query;
    }
}
