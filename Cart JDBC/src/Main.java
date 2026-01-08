import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String ar[]) throws Exception {
        Connection con = PropertyLoader.getConnection();
        Scanner sc = new Scanner(System.in);

        boolean mainSystemLoop = true;

        while (mainSystemLoop) {
            System.out.println("enter the task option from below ->");
            System.out.println("1. operations on product.");
            System.out.println("2. operations on cart.");
            System.out.println("------------------------------------------");

            System.out.println("enter your choice : ");
            int choices = sc.nextInt();

            switch (choices){
                case 1:
                    Producttable.product(con,sc);
                    boolean b = true;
                    while(b) {
                        System.out.println("\nselect the options ->\n");
                        System.out.println("1.insert new product.");
                        System.out.println("2.update product details.");
                        System.out.println("3.delete product.");
                        System.out.println("4.Exit.");

                        System.out.println("\nchoose option: ");
                        int choice = sc.nextInt();

                        switch (choice) {
                            case 1:
                                Operations.insert(con, sc);
                                break;
                            case 2:
                                Operations.update(con, sc);
                                break;
                            case 3:
                                Operations.delete(con, sc);
                                break;
                            case 4:
                                System.out.println("select an option ->");
                                System.out.println("1. go menu.");
                                System.out.println("2. exit system.");
                                int s = sc.nextInt();
                                if(s == 1){
                                    b = false;
                                }else{
                                    System.exit(0);
                                }
                                break;
                            default:
                                System.out.println("invalid option.");
                        }
                    }
                    break;

                case 2:
                    Producttable.cart(con,sc);
                    boolean c = true;
                    while(c) {
                        System.out.println("\nselect the options. ->\n");
                        System.out.println("1.Add into cart.");
                        System.out.println("2.remove from cart.");
                        System.out.println("3.update cart.");
                        System.out.println("4.view cart.");
                        System.out.println("5.Exit.");

                        System.out.println("\nchoose option: ");
                        int choice = sc.nextInt();

                        switch (choice) {
                            case 1:
                                Operations.add(con, sc);
                                break;
                            case 2:
                                Operations.remove(con, sc);
                                break;
                            case 3:
                                Operations.change(con, sc);
                                break;
                            case 4:
                                Operations.view(con,sc);
                                break;
                            case 5:
                                System.out.println("select an option ->");
                                System.out.println("1. go menu.");
                                System.out.println("2. exit system.");
                                int s = sc.nextInt();
                                if(s == 1){
                                    c = false;
                                }else{
                                    System.exit(0);
                                }
                                break;
                            default:
                                System.out.println("invalid option.");
                        }
                    }
                    break;
                default:
                    System.out.println("invalid option.");
            }
        }
        con.close();
        sc.close();
    }
}