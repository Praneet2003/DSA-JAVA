class Singleton{
    private Singleton(){
        System.out.println("THis is the private Constructor of Singleton class.");
    }
    private static Singleton instance;
    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }
}
public class Singleton_class {
    
    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        //here all three above reference variable is pointing to just one object.
    }
}
