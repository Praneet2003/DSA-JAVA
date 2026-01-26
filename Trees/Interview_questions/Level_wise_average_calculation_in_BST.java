import java.util.*;
public class Level_wise_average_calculation_in_BST {
    public static void main(String[] args) {
        Level_wise_average_calculation_in_BST obj = new Level_wise_average_calculation_in_BST();
        obj.insert(15);
        obj.insert(10);
        obj.insert(5);
        obj.insert(12);
        obj.insert(3);
        obj.insert(20);
        obj.preorder();
        System.out.println("Level wise average is: ");
        List<Double> res = obj.Average(obj.root);
        System.out.print(res);
        System.out.println("\n END!!");
    }
    private ListNode root;
    class ListNode{
        int val;
        ListNode left;
        ListNode right;
        public ListNode(int val){
            this.val = val;
            this.left =null;
            this.right = null;
        } 
    }
    public void insert(int val){
        root = insert(root,val);
    }
    public ListNode insert(ListNode root,int val){
        if(root ==null){
            root = new ListNode(val);
            return root;
        }
        if(root.val<val){
            root.right = insert(root.right,val);
        }
        if(root.val>val){
            root.left = insert(root.left,val);
        }
        return root;
    }
    public void preorder(){
        preorder(root);
    }
    private void preorder(ListNode node){
        if(node==null){
            return;
        } 
        System.out.println(node.val);
        preorder(node.left);
        preorder(node.right);
    }
    public List<Double> Average(ListNode root){
        List<Double> avg = new ArrayList<>();
        Queue<ListNode> queue = new LinkedList<>();
        if(root==null){
            return avg;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            double sum = 0.0f;
            int length = queue.size();
            for(int i=0;i<length;i++){
                ListNode current = queue.poll();
                sum+=current.val;
                if(current.left!=null){
                    queue.offer(current.left);
                }
                if(current.right!=null){
                    queue.offer(current.right);
                }
            }
            avg.add(sum/length);
        }
        return avg;
    }
}