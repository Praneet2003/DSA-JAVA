import java.util.*;
public class Convert_flatten_binary_tree_to_Linked_list {
    private Node root;
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
    List<Node> list = new ArrayList<>();
    public void flatten(Node root){
        preorder(root);
        for(int i=0;i<list.size()-1;i++){
            Node current = list.get(i);
            current.left = null;
            current.right = list.get(i+1);
        }
    }
    private void preorder(Node root){
        if(root==null){
            return;
        }
        list.add(root);
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String args[]){
        Convert_flatten_binary_tree_to_Linked_list tree = new Convert_flatten_binary_tree_to_Linked_list();
        Scanner sc = new Scanner(System.in);
        tree.insert(sc);
        tree.flatten(tree.root);
        tree.display();
    }
}
// Enter Root Node: 
// 1
// Do you want to insert left of 1
// true
// Enter the value: 
// 2
// Do you want to insert left of 2
// true
// Enter the value: 
// 3
// Do you want to insert left of 3
// false
// Do you want to insert right of 3
// false
// Do you want to insert right of 2
// true
// Enter the Value:
// 4
// Do you want to insert left of 4
// false
// Do you want to insert right of 4
// false
// Do you want to insert right of 1
// true
// Enter the Value:
// 5
// Do you want to insert left of 5
// false
// Do you want to insert right of 5
// true
// Enter the Value:
// 6
// Do you want to insert left of 6
// false
// Do you want to insert right of 6
// false
//  1
//         2
//                 3
//                         4
//                                 5
//                                         6