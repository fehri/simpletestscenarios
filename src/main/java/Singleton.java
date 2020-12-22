public class Singleton {

    // Hidden class variable of its own type
    private static Singleton instance;

    // Attribute to be stored in the Singleton
    private String name;

    // Private constructor to avoid possibility of direct creation of a new object of this class
    private Singleton () {}

    // Creates once a new Singleton object and always return this particular object
    public static Singleton getInstance () {
        if (Singleton.instance == null) {
            Singleton.instance = new Singleton ();
        }
        return Singleton.instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {

        // If the object is compared with itself
        if (obj == this) {
            return true;
        }

        // Check if the object o is an instance of Singleton or not
        if (!(obj instanceof Singleton)) {
            return false;
        }

        // typecast object to Singleton so that we can compare data members
        Singleton singleton = (Singleton) obj;

        // Compare the names and return accordingly
        return this.getName().equals(((Singleton) obj).getName());
    }

}