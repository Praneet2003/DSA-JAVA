import java.util.*;
public class Post_order{
    private Node root;
    public Post_order(){

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
        System.out.print(node.val+"-->");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+"-->");
    }
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.val+"-->");
        inOrder(node.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Post_order tree = new Post_order();
        tree.insert(sc);
        System.out.println("Post order: ");
        tree.postOrder();
        System.out.println("\nPre order: ");
        tree.preOrder();
        System.out.println("\nIn Order: ");
        tree.inOrder();
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
// Post order:
// 15-->13-->20-->12-->10-->
// Pre order:
// 10-->20-->15-->13-->12-->
// In Order:
// 15-->20-->13-->10-->12-->