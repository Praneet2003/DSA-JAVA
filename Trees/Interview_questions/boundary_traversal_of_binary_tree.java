
/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/
class Solution {
    ArrayList<Integer> l_b = new ArrayList<>();
    ArrayList<Integer> leaf = new ArrayList<>();
    ArrayList<Integer> r_b = new ArrayList<>();
    ArrayList<Integer> boundaryTraversal(Node root) {
        if(root==null){
            return new ArrayList<>();
        }
        leftboundary(root);
        leaf_nodes(root);
        rightboundary(root);
        ArrayList<Integer> res = new ArrayList<>();
        res.add(root.data);
        for(int i:l_b){
            res.add(i);
        }
        for(int i:leaf){
            if(i!=root.data){
                res.add(i);
            }
        }
        for(int i=r_b.size()-1;i>=0;i--){
            res.add(r_b.get(i));
        }
        return res;
        
    }
    void leaf_nodes(Node root){
        if(root==null){
            return;
        }
        leaf_nodes(root.left);
        if(root.left==null && root.right==null){
            leaf.add(root.data);
        }
        leaf_nodes(root.right);
    }
    void rightboundary(Node root){
        if(root==null){
            return;
        }
        Node node = root.right;
        while(node!=null){
            if(!(node.left==null && node.right==null)){
                r_b.add(node.data);
            }
            if(node.right!=null){
                node = node.right;
            }else{
                node = node.left;
            }
        }
    }
    void leftboundary(Node root){
        if(root==null){
            return;
        }
        Node node = root.left;
        while(node!=null){
            if(!(node.left==null && node.right==null)){
                l_b.add(node.data);
            }
            if(node.left!=null){
                node = node.left;
            }else{
                node = node.right;
            }
        }
    }
}