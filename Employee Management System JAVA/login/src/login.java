package employeemanagementsystem;
import java.util.*;

public class Login {
    public Login() {
        String id = null;
        String password = null;
        System.out.println("Enter login id");
        Scanner sc = new Scanner(System.in);
        id = sc.next();
        System.out.println("Enter password");
        password = sc.next();

        if (id.equals("admin") && password.equals("1234")) {
            EMS e = new EMS();
            e.ems();
        } else {
            System.out.println("Invalid login credentials please try again...");
        }
        sc.close();
    }

    public static void main(String[] args) {
        new Login();
        
    }
}