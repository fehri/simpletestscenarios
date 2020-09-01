
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
}