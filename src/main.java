// Java program implementing Singleton class
// with method name as that of class

// Class 1
// Helper class


import java.util.ArrayList;
import java.util.Scanner;



// Class 2
// Main class
class GFG {
    // Main driver method
    public static void main(String args[])
    {

        ArrayList<String> name= CustomerInfo.getCustomerInfo_name();
        ArrayList<String> password= CustomerInfo.getCustomerInfo_password();



        Scanner reader_name = new Scanner(System.in);  // Reading from System.in
        Scanner reader_password = new Scanner(System.in);

        System.out.print("Enter name : ");
        String input_name = reader_name.nextLine().toLowerCase();

        System.out.print("Enter password : ");
        String input_password = reader_password.nextLine().toLowerCase();

        if (name.indexOf(input_name) == password.indexOf(input_password)) {
            Singleton x = Singleton.Singleton();
        }
        else {
            System.out.println("Wrong Password or User Name");
        }

    }


    }
