class Student{
    String name;
    int roll;
    float marks;
    Student(String name,int roll,float marks){
        this.name = name;
        this.roll = roll;
        this.marks = marks;
    }
    public void details(){
        System.out.println("name: "+this.name);
        System.out.println("Roll: "+this.roll);
        System.out.println("Marks: "+this.marks);
    }
}
class Final_objects{
    public static void main(String[] args) {
        final Student a = new Student("Praneet raj",51,89.6f);
        a.name = "Mr. Praneet Raj";
        a.details();
        // a = new Student();

        //NOTE: even after making the object as final you can modifiy internal properties but not reassign new object to it.
    }
}