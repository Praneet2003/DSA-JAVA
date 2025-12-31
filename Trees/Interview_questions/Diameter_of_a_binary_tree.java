import java.util.Scanner;
public class Diameter_of_a_binary_tree {
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
    int diameter=0;
    public int height(Node node){
        if(node == null){
            return -1; // height in terms of edges
        }
        int left_h = height(node.left);
        int right_h = height(node.right);
        int dia = left_h + right_h + 2;
        diameter = Math.max(diameter, dia);
        return Math.max(left_h, right_h) + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Diameter_of_a_binary_tree tree = new Diameter_of_a_binary_tree();
        tree.insert(sc);
        int hieght = tree.height(tree.root);
        System.out.println(hieght);
        System.out.println(tree.diameter);
    }
}
