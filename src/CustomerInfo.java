import java.io.*;
import java.util.Scanner;

public class CustomerInfo {
    public  static void getCustomerInfo_name() {
        try {
            File myObj = new File("C:\\Users\\Deniz Günseren\\Desktop\\sdp\\cust.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public  static void getCustomerInfo_password() {
        try {
            File myObj = new File("C:\\Users\\Deniz Günseren\\Desktop\\sdp\\password.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
