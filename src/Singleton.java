class Singleton {
    // Static variable single_instance of type Singleton
    private static Singleton single_instance = null;

    // Declaring a variable of type String
    public String s;

    // Constructor of this class
    // Here private constructor is is used to
    // restricted to this class itself
    private Singleton() {}

    // Method
    // Static method to create instance of Singleton class
    public static Singleton Singleton()
    {
        // To ensure only one instance is created
        if (single_instance == null) {
            single_instance = new Singleton();
            System.out.println("Logged In");
        }
        return single_instance;
    }
}
