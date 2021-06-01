import org.postgresql.util.PSQLException;

import java.sql.*;

public class connectToSQL {
    Connection connection;
    String jdbcURL;
    String sqlUser;
    String sqlPassword;
    public connectToSQL() {
        //與postgreSQL連線
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

    public void studentInfo(String user_id, String password) {
        try{
            //加入Student Info
            insertInfo insertInfo = new insertInfo();
            PreparedStatement statement1 = connection.prepareStatement(insertInfo.getQuery());
            statement1.setString(1, user_id);
            statement1.setString(2, password);
            statement1.setString(3, "false");
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

    public void createClass(String user_id, String comment, String className) {
        //創建comment table
        try {
            Statement statement = connection.createStatement();
            createCommentTable createTable = new createCommentTable(className);
            statement.executeUpdate(createTable.getQuery());
            System.out.println("Table Created!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        insertComment(user_id, comment, className);
    }

    public void insertComment(String user_id, String comment, String className) {
        //加入comment
        try{
            insertComment insertComment = new insertComment(className);
            PreparedStatement statement2 = connection.prepareStatement(insertComment.getQuery());
            statement2.setString(1, user_id);
            statement2.setString(2, comment);
            statement2.executeUpdate();
            System.out.println("A new comment has been inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}