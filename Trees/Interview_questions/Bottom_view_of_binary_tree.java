import java.util.*;
public class Bottom_view_of_binary_tree {
    public static void main(String[] args) {
        
    }
}
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        class pair{
            Node node;
            int d;
            public pair(Node val,int d){
                this.node = val;
                this.d = d;
            }
        }
        Queue<pair> queue = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        queue.offer(new pair(root,0));
        while(!queue.isEmpty()){
            int n = queue.size();
            pair p = queue.poll();
                map.put(p.d,p.node.data);
            if(p.node.left!=null){
                queue.offer(new pair(p.node.left,p.d-1));
            }
            if(p.node.right!=null){
                queue.offer(new pair(p.node.right,p.d+1));
            }
        }
        for(int i: map.values()){
            res.add(i);
        }
        return res;
    }
}