import java.util.*;
class Queue_pattern_Zig_Zag_Order_travesal{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue_pattern_Zig_Zag_Order_travesal tree = new Queue_pattern_Zig_Zag_Order_travesal();
        tree.insert(sc); 
        List<List<Integer>> res = tree.zigzagtravesal(tree.root);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
    public List<List<Integer>> zigzagtravesal(Node root){
        List<List<Integer>> outer = new ArrayList<>();
        Deque<Node> queue = new LinkedList<>();
        if(root==null){
            return outer;
        }
        queue.offer(root);
        boolean rev = false;
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> inner = new ArrayList<>(len);
            for(int i=0;i<len;i++){
                if(!rev){
                    Node current = queue.pollFirst();
                    inner.add(current.val);
                    if(current.left!=null){
                        queue.addLast(current.left);
                    }
                    if(current.right!=null){
                        queue.addLast(current.right);
                    }
                }else{
                    Node current = queue.pollLast();
                    inner.add(current.val);
                    if(current.right!=null){
                        queue.addFirst(current.right);
                    }
                    if(current.left!=null){
                        queue.addFirst(current.left);
                    }
                }
            }
            outer.add(inner);
            rev = !rev;
        }
        return outer;
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
}