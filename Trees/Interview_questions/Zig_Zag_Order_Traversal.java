import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
public class Zig_Zag_Order_Traversal{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Zig_Zag_Order_Traversal tree = new Zig_Zag_Order_Traversal();
        tree.insert(sc);
        List<List<Integer>> res = tree.zigzagtaversal(tree.root);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
    public List<List<Integer>> zigzagtaversal(Node root){
        List<List<Integer>> outer = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> inner = new ArrayList<>();
            for(int i=0;i<len;i++){
                Node current = queue.poll();
                inner.add(current.val);
                if(current.left!=null){
                    queue.offer(current.left);
                }
                if(current.right!=null){
                    queue.offer(current.right);
                }
            }
            outer.add(inner);
        }
        for(int i=1;i<outer.size();i+=2){
            reverse(outer.get(i));
        }
        return outer;
    }
    public void reverse(List<Integer> arr){
        int s = 0;
        int e = arr.size()-1;
        while(s<=e){
            int temp = arr.get(s);
            arr.set(s,arr.get(e));
            arr.set(e,temp);
            s++;
            e--;
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
// 4
// Do you want to insert left of 4
// true
// Enter the value:
// 8
// Do you want to insert left of 8        
// false
// Do you want to insert right of 8       
// false
// Do you want to insert right of 4       
// true
// Enter the Value:
// 9
// Do you want to insert left of 9        
// false
// Do you want to insert right of 9       
// false
// Do you want to insert right of 2       
// true
// Enter the Value:
// 5
// Do you want to insert left of 5        
// false
// Do you want to insert right of 5       
// false
// Do you want to insert right of 1       
// true
// Enter the Value:
// 3
// Do you want to insert left of 3        
// true
// Enter the value:
// 6
// Do you want to insert left of 6        
// true
// Enter the value:
// 10
// Do you want to insert left of 10       
// false
// Do you want to insert right of 10      
// false
// Do you want to insert right of 6       
// true
// Enter the Value:
// 11
// Do you want to insert left of 11       
// false
// Do you want to insert right of 11      
// false
// Do you want to insert right of 3       
// true
// Enter the Value:
// 7
// Do you want to insert left of 7        
// false
// Do you want to insert right of 7       
// false
// [1]
// [3, 2]
// [4, 5, 6, 7]
// [11, 10, 9, 8]