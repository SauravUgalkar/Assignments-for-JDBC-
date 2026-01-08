import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update {
    public static void main(String ar[]){
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        try{
            //database connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","Saurav$2004");

//            String sql = "ALTER TABLE student ADD COLUMN marks INT DEFAULT 0;"; // add marks column to student table

            System.out.println("update student information ->");

            String sql1 = "Update student set marks = ? where id = ?;"; //parameterized query

            System.out.println("Enter student id : ");
            int id = sc.nextInt();

            System.out.println("Enter new marks : ");
            int marks = sc.nextInt();
            PreparedStatement stmt = con.prepareStatement(sql1);
            stmt.setInt(1,marks);
            stmt.setInt(2, id);
            int count  = stmt.executeUpdate();

            System.out.println(" student information updated.");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
