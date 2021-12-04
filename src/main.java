// Java program implementing Singleton class
// with method name as that of class

// Class 1
// Helper class


import java.util.Scanner;



// Class 2
// Main class
class GFG {
    // Main driver method
    public static void main(String args[])
    {
       // Scanner name_obj = new Scanner(System.in);  // Create a Scanner object
       // System.out.println("Enter username:");
       // String name_user_input = name_obj.nextLine();

      //  Scanner pass_obj = new Scanner(System.in);  // Create a Scanner object
      //  System.out.println("Enter password:");
       // String password_user_input = pass_obj.nextLine();


       String[] name= CustomerInfo.getCustomerInfo_name();
       String[] password= CustomerInfo.getCustomerInfo_password();



        CustomerInfo.getCustomerInfo_password();
        // Instantiating Singleton class with variable x
        Singleton x = Singleton.Singleton();

        // Instantiating Singleton class with variable y
        Singleton y = Singleton.Singleton();

        // instantiating Singleton class with variable z
        Singleton z = Singleton.Singleton();

        // Now  changing variable of instance x
        // via toUpperCase() method
        x.s = (x.s).toUpperCase();

        Scanner reader = new Scanner(System.in);  // Reading from System.in

        System.out.println(name[2]);
        System.out.println(password[2]);


//once finished
        reader.close();


    }
}