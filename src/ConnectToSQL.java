import java.sql.*;

public class ConnectToSQL {
    public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:postgresql://localhost:5432/Student";
        String username = "postgres";
        String password = "al2520626";
        try{
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to PostgreSQL server");
//            Statement statement = connection.createStatement();
//            CreateTable createTable = new CreateTable("Java");
//            statement.executeUpdate(createTable.getQuery());
//            System.out.println("Table Created!");
//            InsertTable insertTable = new InsertTable("Java");
//            PreparedStatement statement = connection.prepareStatement(insertTable.getQuery());
//            statement.setString(1, "00857053");
//            statement.setString(2, "讚!");
//            statement.executeUpdate();
//            System.out.println("A new comment has been inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
