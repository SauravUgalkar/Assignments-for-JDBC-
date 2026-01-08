import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EmptyStackException;
import java.util.PropertyResourceBundle;
import java.util.Scanner;

public class Operations {

    // 1 task operation
    public static void insert(Connection con, Scanner sc) throws SQLException{
        System.out.println("Enter the product information ->");

        try{
            String sql = "insert into product values(?,?,?,?)";

            System.out.println("Enter the product id : ");
            int id = sc.nextInt();
            System.out.println("Enter the product name : ");
            String name = sc.next();
            System.out.println("Enter the product price : ");
            double price = sc.nextDouble();
            System.out.println("Enter the quantity : ");
            int quantity = sc.nextInt();

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.setString(2,name);
            stmt.setDouble(3,price);
            stmt.setInt(4,quantity);

            int count = stmt.executeUpdate();

            System.out.println(count + "the product information is inserted.");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void update(Connection con, Scanner sc) throws SQLException{
        System.out.println("update the product details -> ");

        try{
            String sql = "update product set name = ?, price = ?, quantity = ? ,where id = ?";

            System.out.println("Enter the id : ");
            int id = sc.nextInt();
            System.out.println("give the information of new product->");
            System.out.println("Enter the name : ");
            String name = sc.next();
            System.out.println("Enter the price : ");
            double price = sc.nextDouble();
            System.out.println("Enter the quantity : ");
            int quantity = sc.nextInt();

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(4,id);
            stmt.setString(1,name);
            stmt.setDouble(2,price);
            stmt.setInt(3,quantity);

            int count =  stmt.executeUpdate();
            System.out.println("product information is updated.");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void delete(Connection con, Scanner sc) throws SQLException{
        System.out.println("delete the product ->");

        try{
            String sql = "delete from product where id = ?";

            System.out.println("Enter the id : ");
            int id = sc.nextInt();

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,id);

            int count = stmt.executeUpdate();
            System.out.println("the product is deleted. ");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // 2nd task operations
    public static void add(Connection con, Scanner sc) throws SQLException{
        System.out.println("add to cart ->");

        try{
            String sql = "insert into cart values(?,?,?,?)";

            System.out.println("Enter the product id : ");
            int id = sc.nextInt();
            System.out.println("Enter the product name : ");
            String name = sc.next();
            System.out.println("Enter the product price : ");
            double price = sc.nextDouble();
            System.out.println("Enter the quantity : ");
            int quantity = sc.nextInt();

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.setString(2,name);
            stmt.setDouble(3,price);
            stmt.setInt(4,quantity);

            int count = stmt.executeUpdate();
            System.out.println("product added to the cart.");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void remove(Connection con, Scanner sc) throws SQLException{
        System.out.println("remove from cart ->");
        try{
            String sql = "delete from cart where id = ?";

            System.out.println("Enter the id : ");
            int id = sc.nextInt();

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,id);

            int count = stmt.executeUpdate();
            System.out.println("product is removed form the cart.");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void change(Connection con, Scanner sc) throws Exception{
        System.out.println("update the cart product quantity ->");

        try {
            String sql = "update cart set quantity = ? where id =? ";
            System.out.println("Enter the id : ");
            int id = sc.nextInt();
            System.out.println("Enter the quantity : ");
            int quantity = sc.nextInt();

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(2, id);
            stmt.setInt(1, quantity);

            int count = stmt.executeUpdate();
            System.out.println("update the cart.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void view(Connection con, Scanner sc) throws SQLException{
        System.out.println("view the products ->");

        try{
            String sql = "select * from cart";
            System.out.println("cart product detailed information ->");

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                System.out.print("name : "+ rs.getString("name")+"\t");
                System.out.print("\tprice : "+ rs.getDouble("price")+"\t");
                System.out.print("\tquantity : "+ rs.getString("quantity")+"\t");
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
