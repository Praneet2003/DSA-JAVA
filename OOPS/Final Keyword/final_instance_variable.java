class Student{
    String name;
    int roll;
    float marks;
    final int total = 500;//final instance varibale.
}
class final_instance_variable{
    public static void main(String[] args) {
        Student obj = new Student();
        System.out.println(obj.total);
        Student obj1 = new Student();
        System.out.println(obj1.total);
        // obj1.total = 700; //cant be modified
    }
}
// if a class contains final instance variable,for differnt object
// there are distinct copies of final varibale for each object, they can only 
// acsess(i.e read) but can't modify it.