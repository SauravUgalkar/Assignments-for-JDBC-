import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Scanner;

public class Delete {
    public static void main(String ar[]) throws SQLException{
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","Saurav$2004");
            System.out.println("delete student information ->");

            String sql = "delete from student where id=?;";

            System.out.println("enter student id: ");
            int id = sc.nextInt();

            PreparedStatement stmt =  con.prepareStatement(sql);
            stmt.setInt(1, id);

            int count =  stmt.executeUpdate();

            System.out.println("student information deleted.");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
