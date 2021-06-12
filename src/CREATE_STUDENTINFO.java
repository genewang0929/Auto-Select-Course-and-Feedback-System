public class CREATE_STUDENTINFO {
    private String query;
    public  CREATE_STUDENTINFO() {
        query = "CREATE TABLE studentinfo(\n" +
                "  num SERIAL PRIMARY KEY,\n" +
                "  username VARCHAR(50) UNIQUE NOT NULL,\n" +
                "  password_ VARCHAR(50) NOT NULL,\n" +
                "  ban VARCHAR(20))";
    }

    public String getQuery() {
        return query;
    }
}
