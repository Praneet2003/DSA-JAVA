class Box{
    double l,b,h;
    public Box(){
        super();//calls the constructor of super class Object.
        this.l = this.b = this.h = -1;
    }
    public Box(double side){
        this.h = side;
        this.l = side;
        this.b = side;
    }
    public Box(double l, double b,double h){
        this.l = l;
        this.b = b;
        this.h = h;
        System.out.println("Parent constructor.");
    }
    public Box(Box old){
        this.h = old.h;
        this.b = old.b;
        this.l = old.l;
    }
}
class BoxWeight extends Box{
    double weight;
    public BoxWeight(){
        this.weight = 0.0f;
    }
    public BoxWeight(double l,double b,double h,double w){
        super(l,b,h);
        this.weight = w;
        System.out.println("Child constructor");
    }
    public void calculatedweight(){
        System.out.printf("Total Weight is: %.2f\n",this.l*this.b*this.h*this.weight);
    }
}
public class Child_reference {
    public static void main(String[] args) {
        BoxWeight box = new BoxWeight(5.6,6.4,3.2,8.1);
        System.out.println("Box height: "+ box.h+"\nBox Length: "+box.l+"\nBox width: "+box.b);
        System.out.println("The total weight of box is: ");
        box.calculatedweight();
        // BoxWeight obj = new Box(4,5,6);
        // you can't have child refernce and parent object to it.
        //because parent class doesn't know about the extra properties of the child class
        // eg:- parent-> vehicle and child-> car
        // Every car can be vehicle but not evry vehicle can be car.
    }
}
