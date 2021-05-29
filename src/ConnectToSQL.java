import org.postgresql.util.PSQLException;

import java.sql.*;

public class ConnectToSQL {
    Connection connection;
    String jdbcURL;
    String sqlUser;
    String sqlPassword;
    public ConnectToSQL() {
        //與pgAdmin連線
        jdbcURL = "jdbc:postgresql://localhost:5432/Student";
        sqlUser = "postgres";
        sqlPassword = "al2520626";
        try {
            connection = DriverManager.getConnection(jdbcURL, sqlUser, sqlPassword);
            System.out.println("Connected to PostgreSQL server");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void StudentInfo(String user_id, String password, String name) {
        try{
            //加入Student Info
            InsertInfo insertInfo = new InsertInfo();
            PreparedStatement statement1 = connection.prepareStatement(insertInfo.getQuery());
            statement1.setString(1, user_id);
            statement1.setString(2, password);
            statement1.setString(3, name);
            try {
                statement1.executeUpdate();
                System.out.println("A new student has registered");
            } catch (PSQLException e) {
                System.out.println("Welcome Back");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Comment(String user_id, String comment) {
        try{
            //創建comment table
            Statement statement = connection.createStatement();
            CreateCommentTable createTable = new CreateCommentTable("Java");
            statement.executeUpdate(createTable.getQuery());
            System.out.println("Table Created!");
            //加入comment
            InsertComment insertComment = new InsertComment("Java");
            PreparedStatement statement2 = connection.prepareStatement(insertComment.getQuery());
            statement2.setString(1, "00857053");
            statement2.setString(2, "讚!");
            statement2.executeUpdate();
            System.out.println("A new comment has been inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}