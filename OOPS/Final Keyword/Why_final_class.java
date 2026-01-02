final class Student{
    String name;
    int roll;
    float marks;
    // Student(String name,int roll,float marks){
    //     this.name = name;
    //     this.roll = roll;
    //     this.marks = marks;
    // }
    // Student(){

    // }
    public void details(){
        System.out.println("name: "+this.name);
        System.out.println("Roll: "+this.roll);
        System.out.println("Marks: "+this.marks);
    }
}
class Why_final_class{
    public static void main(String[] args) {
        // Student a = new Student("Praneet raj",51,89.6f);
        // a.name = "Mr. Praneet Raj";
        // a.details();
        Student b = new Student();
        b.name ="praneet";
        b.roll = 51;
        b.marks = 99.5f;
        System.out.println(b.name+" "+b.roll+" "+b.marks);

    }
}