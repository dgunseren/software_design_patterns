import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerInfo {
    public  static String[] getCustomerInfo_name() {
        String[] list = new String[4] ;
        try {
            File myObj = new File("C:\\Users\\Deniz Günseren\\Desktop\\sdp\\cust.txt");
            Scanner myReader = new Scanner(myObj);
            int i =0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                list[i]= data;
                //System.out.println(list[i]);
                i=i+1;
                if (i==4){break;}
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
   return  list; }
    public  static String[] getCustomerInfo_password() {
        String[] list = new String[4] ;
        try {
            File myObj = new File("C:\\Users\\Deniz Günseren\\Desktop\\sdp\\password.txt");
            Scanner myReader = new Scanner(myObj);
            int i =0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                list[i]= data;
                System.out.println(list[i]);
                i=i+1;
                if (i==4){break;}
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
   return list; }
}
