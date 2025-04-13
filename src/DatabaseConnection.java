import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection implements Database{


    private static final String URL = "jdbc:mysql://localhost:3306/tasks_db";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void initializeDatabase(){
        String createDB = "CREATE DATABASE IF NOT EXISTS tasks_db";
        String useDB = "USE tasks_db";
        String createTable = """
                CREATE TABLE IF NOT EXISTS tasks(
                        taskName varchar(20) primary key,
                        description varchar(50),
                        category varchar(20),
                        deadline date 
                        )
                        """;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()){
            stmt.execute(createDB);
            stmt.execute(useDB);
            stmt.execute(createTable);
        }
        catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Database initialization failed: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void addTask(String name, String desc, String category, String deadline) {
        String useDB = "USE tasks_db";
        String add = "insert into tasks values ( '" + name + "', '" + desc + "', '" + category + "', ' " + String.valueOf(deadline) + "') ";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()){
            stmt.execute(useDB);
            stmt.execute(add);

        }
        catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Database initialization failed: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void deleteTask(String name) {
        String useDB = "USE tasks_db";
        String delete = "delete from tasks where taskName= ' " + name + "') ";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()){
            stmt.execute(useDB);
            stmt.execute(delete);

        }
        catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Database initialization failed: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }

    }


    @Override
    public void editTask(String oldName, String name, String desc, String category, String deadline) {
        String useDB = "USE tasks_db";

        String edit = "update tasks set taskName=' " + name + "', description= '" + desc +
                "',  category='" + category + "',  deadline='" + deadline + "'" +
                " where taskName=' " + oldName + "';";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()){
            stmt.execute(useDB);
            stmt.execute(edit);

        }
        catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Database initialization failed: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
