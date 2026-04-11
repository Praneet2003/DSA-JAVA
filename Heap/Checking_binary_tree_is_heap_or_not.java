public class Checking_binary_tree_is_heap_or_not {
    public static void main(String[] args) {
        
    }
}
class Node {
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
class Solution {
    public boolean isHeap(Node tree) {
        // code here
        return (isCBT(tree) && isMaxHeap(tree));
    }
    public boolean isCBT(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean seennull = false;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node==null){
                seennull = true;
            }else{
                if(seennull){
                    return false;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }
    public boolean isMaxHeap(Node root){
        if(root==null){
            return true;
        }
        if(root.left==null && root.right==null){
            return true;
        }
        if(root.right==null){
            return root.data>=root.left.data && isMaxHeap(root.left);
        }
        if(root.data>=root.left.data && root.data>=root.right.data){
            boolean left = isMaxHeap(root.left);
            boolean right = isMaxHeap(root.right);
            return left && right;
        }
        return false;
    }
}