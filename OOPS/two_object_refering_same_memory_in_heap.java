class Student{
    String name;
    int roll;
    float marks;
    public Student(){
        this.name = "Anshu";
        this.marks = 88.5f;
        this.roll = 46; 
    }
    Student(Student obj){
        this.name = obj.name;
        this.roll = 51;
        this.marks = obj.marks;
    }
    public Student(int roll,float marks, String name){
        this.name = name;
        this.marks = marks;
        this.roll = roll; 
    }
    public void Student_details(){
        System.out.print("Name: "+this.name);
        System.out.print("\nRoll: "+this.roll);
        System.out.print("\nMarks: "+this.marks);
    }
}
class two_object_refering_same_memory_in_heap{
    public static void main(String[] args) {
        // Student a = new Student();
        // System.out.println("\nCalled by Constructor a: \n");
        // a.Student_details();
        // Student b = new Student(a);
        // System.out.println("\nCalled by Constructor b: \n");
        // b.Student_details();
        Student c = new Student(19,90.67f,"Anshu");
        Student d = c;//now both c and d are pointing to same memory in heap.
        d.name = "Praneet Raj";
        c.Student_details();
    }
}