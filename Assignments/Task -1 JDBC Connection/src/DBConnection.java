import java.sql.*;

public class DBConnection{
    static Connection conn = null;
   public static void main(String ar[]){
        try {
            String mysqlDriver = "com.mysql.cj.jdbc.Driver";
            String mysqlUrl = "jdbc:mysql://localhost:3306/advjava"; // jdbc connector://local system:port number/database name;

            Class.forName(mysqlDriver); //this line is optional because IDE finds that class automatically.
            conn = DriverManager.getConnection(mysqlUrl, "root", "Saurav$2004");
            System.out.println("Database connection successful. ");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

