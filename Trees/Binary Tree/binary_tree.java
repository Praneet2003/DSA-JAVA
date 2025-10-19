import java.util.*;
public class binary_tree{
    private Node root;
    public binary_tree(){

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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        binary_tree tree = new binary_tree();
        tree.insert(sc);
        tree.display2();
    }
}
// Output
// Enter Root Node: 
// 15
// Do you want to insert left of 15
// True
// Enter the value: 
// 6
// Do you want to insert left of 6
// True
// Enter the value:
// 8
// Do you want to insert left of 8
// False
// Do you want to insert right of 8
// True
// Enter the Value:
// 10
// Do you want to insert left of 10
// False
// Do you want to insert right of 10
// False
// Do you want to insert right of 6
// True
// Enter the Value:
// 14
// Do you want to insert left of 14
// False
// Do you want to insert right of 14
// False
// Do you want to insert right of 15
// True
// Enter the Value:
// 9
// Do you want to insert left of 9
// False
// Do you want to insert right of 9
// False
// |---------->9
// 15
// |           |---------->14
// |---------->6
// |           |           |---------->10
// |           |---------->8