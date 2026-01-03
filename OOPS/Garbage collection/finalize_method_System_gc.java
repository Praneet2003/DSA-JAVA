final class Student{
    String name;
    int roll;
    public Student() {
        this.name = "Praneet raj";
        this.roll = 51;
    }
    public void details(){
        System.out.println("Name: "+this.name);
        System.out.println("Roll: "+this.roll);
    }
    @Override
    protected void finalize() throws Throwable{
        System.out.println("Object destroyed by Demon thread (Garbage Collector)");
    }
}
class finalize_method_System_gc{
    public static void main(String[] args) {
        Student obj = new Student();
        obj.details();
        // obj.finalize(); you can't call finalize method directly it is automatically been called by the JVM.
        obj = null;
        System.gc();
        System.out.println("End of the main method");
    }
}