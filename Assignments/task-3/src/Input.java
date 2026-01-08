import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Input {
    public static void main(String ar[]) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection conn = null;
        try {
            //database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava", "root", "Saurav$2004");
            System.out.println("insert new student information ->");
            String sql = "insert into student values(?,?,?,0);"; // parameterized query

            System.out.println("Enter the student id : "); // 1st input
            int id = sc.nextInt();
            System.out.println("Enter student name : "); //2nd input
            String name = sc.next();
            System.out.println("Enter student age : "); // 3rd input
            int age = sc.nextInt();

            PreparedStatement stmt = conn.prepareStatement(sql); // define query
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, age);


            int count = stmt.executeUpdate(); // execute query

            System.out.println(count + " student data is inserted. ");
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}



