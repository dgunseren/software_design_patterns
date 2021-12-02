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
        CustomerInfo.getCustomerInfo_name();
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
        int name = reader.nextInt(); // Scans the next token of the input as an int.
        int surname = reader.nextInt();

//once finished
        reader.close();


    }
}