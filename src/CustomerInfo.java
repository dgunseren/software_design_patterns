import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class CustomerInfo {
    public  static ArrayList<String> getCustomerInfo_name() {
        ArrayList<String> new_list = new ArrayList<String>();
        try {
            File myObj = new File("C:\\Users\\Deniz Günseren\\Desktop\\sdp\\cust.txt");
            Scanner myReader = new Scanner(myObj);
            int i =0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().toLowerCase();
                new_list.add(data.trim());


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
   return  new_list; }
    public  static ArrayList<String> getCustomerInfo_password() {
        ArrayList<String> new_list = new ArrayList<String>();
        try {
            File myObj = new File("C:\\Users\\Deniz Günseren\\Desktop\\sdp\\password.txt");
            Scanner myReader = new Scanner(myObj);
            int i =0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().toLowerCase();
                new_list.add(data.trim());

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
   return new_list; }
}
