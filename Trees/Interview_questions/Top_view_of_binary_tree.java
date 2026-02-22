public class Top_view_of_binary_tree {
    public static void main(String args[]){

    }
}
class Node{
    int data;
    Node next;
    
    public Node(int val){
        this.val = val;
        this.next = null;
    }
}
class Solution {
    class Pair {
        Node node;
        int hd;
        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        TreeMap<Integer,Integer> umap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            if(!umap.containsKey(curr.hd)){
                umap.put(curr.hd, curr.node.data);
            }
            if(curr.node.left != null){
                queue.offer(new Pair(curr.node.left, curr.hd - 1));
            }
            if(curr.node.right != null){
                queue.offer(new Pair(curr.node.right, curr.hd + 1));
            }
        }
        for(int val : umap.values()){
            res.add(val);
        }
        return res;
    }
}
