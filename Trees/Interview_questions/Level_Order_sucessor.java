import java.util.*;
public class Level_Order_sucessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Level_Order_sucessor tree = new Level_Order_sucessor();
        tree.insert(sc);
        int n = sc.nextInt();
        List<Integer> res = tree.sucessor(tree.root);
        System.out.print(res);
        System.out.println("");
        boolean found = false;
        for(int i=0;i<res.size()-1;i++){
            if(res.get(i)==n){
                found = true;
                System.out.println(res.get(i+1));
                break;
            }
            if(n==res.get(res.size()-1)){
                System.out.println("This is the last node so not sucessor present");
            }
        }
        if(!found){
        System.out.println("Node "+n+" not found in the tree"); 
    }
}
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
    public List<Integer> sucessor(Node root){
        List<Integer> levelorder = new ArrayList<>();
        if(root==null){
            return levelorder;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
        int length = queue.size();
        for(int i=0;i<length;i++){
            Node current = queue.poll();
            levelorder.add(current.val);
            if(current.left!=null){
                queue.offer(current.left);
            }
            if(current.right!=null){
                queue.offer(current.right);
            }
        }
    }
        return levelorder;
    }
}
