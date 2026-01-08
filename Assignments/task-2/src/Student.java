
import java.sql.*;
public class Student {
    public static void main(String ar[]) throws SQLException {
        Connection conn = null;
        try{
            //database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","Saurav$2004");

            String sql = "select * from student;"; // select query
            PreparedStatement stmt = conn.prepareStatement(sql); // define the query

            ResultSet rs = stmt.executeQuery(); // execute query
            System.out.println("Id \t\t name \t\t age");
            while(rs.next()){ // fetch the information from the resultset
                System.out.print(rs.getInt(1)+"\t\t");
                System.out.print(rs.getString(2)+"\t\t\t");
                System.out.print(rs.getInt(3)+"\t\t");
                System.out.println();
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
