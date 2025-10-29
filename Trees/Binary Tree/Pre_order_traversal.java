import java.util.*;
public class Pre_order_traversal{
    private Node root;
    public Pre_order_traversal(){

    }
    private class Node{
        int val;
        Node left;
        Node right;
        public Node(int n){
            this.val = n;
            this.left = null;
            this.right = null;
        }
    }
    //inserting elements.
    public void insert(Scanner sc){
        System.out.println("Enter Root Node: "); 
        int val = sc.nextInt();
        root = new Node(val);
        insert(sc,root);
    }
    private void insert(Scanner sc , Node node){
        System.out.println("Do you want to insert left of "+node.val);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter the value: ");
            int val = sc.nextInt();
            Node newnode = new Node(val);
            node.left = newnode;
            insert(sc,node.left);
        }
        System.out.println("Do you want to insert right of "+node.val);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter the Value: ");
            int val = sc.nextInt();
            Node newnode = new Node(val);
            node.right = newnode;
            insert(sc,node.right);
        }
    }
    public void display(){
        display(root," ");
    }
    private void display(Node node, String indent){
        if(node==null){
            return;
        }
        System.out.println(indent+node.val);
        display(node.left,indent+"\t");
        display(node.right,indent+"\t");
    }
    public void display2(){
        display2(root,0);//here 0 is level/depth.
    }
    private void display2(Node node,int level){
        if(node==null){
            return;
        }
        display2(node.right,level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++){
                System.out.print("|\t\t");
            }
            System.out.println("|---------->"+node.val);
        }else{
            System.out.println(node.val);
        }
        display2(node.left,level+1);
    }
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.val+"-->");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pre_order_traversal tree = new Pre_order_traversal();
        tree.insert(sc);
        tree.preOrder();
    }
}
// Enter Root Node: 
// 10
// Do you want to insert left of 10
// True
// Enter the value:
// 20
// Do you want to insert left of 20
// True
// Enter the value:
// 15
// Do you want to insert left of 15
// False
// Do you want to insert right of 15
// False
// Do you want to insert right of 20
// True
// Enter the Value:
// 13
// Do you want to insert left of 13
// False
// Do you want to insert right of 13
// False
// Do you want to insert right of 10
// True
// Enter the Value:
// 12
// Do you want to insert left of 12
// False
// Do you want to insert right of 12
// False
// 10-->20-->15-->13-->12-->