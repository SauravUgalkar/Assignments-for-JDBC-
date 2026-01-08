import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Producttable {

    //1 task table
    public static void product(Connection con, Scanner sc) throws SQLException {
        String sql = "create table if not exists product(id int, name varchar(30),price double, quantity int)";
        PreparedStatement stmt = con.prepareStatement(sql);

        int count  = stmt.executeUpdate();
        System.out.println("product table is created.");
    }
    // 2 task table
    public static void cart(Connection con, Scanner sc) throws SQLException{

        String sql = "create table if not exists cart(id int, name varchar(30),price double, quantity int)";
        PreparedStatement stmt = con.prepareStatement(sql);

        int count = stmt.executeUpdate();
        System.out.println("cart table is created.");
    }
}
