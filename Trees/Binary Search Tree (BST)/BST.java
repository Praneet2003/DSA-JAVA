public class BST {
    private Node root;
    class Node{
        int val;
        Node left;
        Node right;
        int height;
        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
            this.height=0;
        }
        public int getValue(){
            return val;
        }
    }
    public BST(){}
    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty(){
        if(root==null){
            return true;
        }
        return false;
    }
    public void Insert(int val){
        root = Insert(root,val);
    }
    private Node Insert(Node node, int val){
        if(node==null){
            node = new Node(val);
            return node;
        }
        if(val<node.val){
            node.left = Insert(node.left,val);
        }
        if(val>node.val){
            node.right = Insert(node.right,val);
        }
        //when new node is inserted i.e the height will also increase.
        node.height = Math.max(height(node.left),height(node.right))+1;
        return node; 
    }
    public void insert2(int val){
        if(root==null){
            root = new Node(val);
        }
        insert2(root,val);
    }
    private void insert2(Node node,int val){
        if(val<node.val){
            if(node.left!=null){
                insert2(node.left,val);
            }else{
                node.left = new Node(val);
            }
        }else{
            if(val>node.val){
                if(node.right!=null){
                    insert2(node.right,val);
                }else{
                    node.right = new Node(val);
                }
            }
        }
        node.height = Math.max(height(node.left),height(node.right))+1;
    }
    public void display(){
        display(root,"Root Node: ");
    }
    private void display(Node node,String details){
        if(node==null){
            return;
        }
        System.out.println(details+node.getValue());
        display(node.left,"Left child of "+node.getValue()+" : ");
        display(node.right,"Right child of "+node.getValue()+" : ");
    }
    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if(node==null){
            return true;
        }
        int balancedfactor = Math.abs(height(node.left)-height(node.right));
        return balancedfactor<=1 && balanced(node.left) && balanced(node.right);
    }
    public void display_height(){
        display_height(root,"Root Node: ");
    }
    private void display_height(Node node,String det){
        if(node==null){
            return;
        }
        System.out.println(det+node.getValue()+" having height: "+height(node));
        display_height(node.left,"Left child of "+node.getValue()+" : ");
        display_height(node.right,"Left child of "+node.getValue()+" : ");
    }
    public static void main(String[] args) {
        BST tree = new BST();
        // tree.Insert(15);
        // tree.Insert(10);
        // tree.Insert(5);
        // tree.Insert(12);
        // tree.Insert(3);
        // tree.Insert(20);
        tree.insert2(15);
        tree.insert2(10);
        tree.insert2(5);
        tree.insert2(12);
        tree.insert2(3);
        tree.insert2(20);
        // int arr[] = {1,2,3,4,5,6,7};
        // for(int a: arr){
        //     tree.insert2(a);
        // }
        tree.display();
        System.out.println("\nIs the tree balanced: "+tree.balanced()+"\n");
        tree.display_height();
    }
}
