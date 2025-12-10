import java.util.*;
import java.util.LinkedList;
class BFSLevel_order_traversal{
    public static void main(String[] args) {
        System.out.println("Hello!!");
        BFSLevel_order_traversal obj = new BFSLevel_order_traversal();
        obj.insert(15);
        obj.insert(10);
        obj.insert(5);
        obj.insert(12);
        obj.insert(3);
        obj.insert(20);
        List<List<Integer>> sol = obj.levelorder(obj.root);
        int n = sol.size();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<sol.get(i).size();j++){
                System.out.print(sol.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    private TreeNode root;
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public void insert(int val){
        root = insert(root,val);
    }
    public TreeNode insert(TreeNode node,int val){
        if(node==null){
            node = new TreeNode(val);
            return node;
        }
        if(val<node.val){
            node.left = insert(node.left,val);
        }
        if(val>node.val){
            node.right = insert(node.right,val);
        }
        return node;
    }
    public List<List<Integer>> levelorder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentlevel = new ArrayList<>(levelSize);
            for(int i=0;i<levelSize;i++){
                TreeNode currentNode = queue.poll();
                currentlevel.add(currentNode.val);
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            res.add(currentlevel);
        }
        return res;
    }
}