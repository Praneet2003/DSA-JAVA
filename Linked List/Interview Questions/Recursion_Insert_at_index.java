class Recursion_Insert_at_index{
    private Node head;
    private int size;
    private Node tail;
    public void Recur_insert(int index,int val){
        if((head==null && index!=1)||index<1){
            System.out.println("\nError: Invalid Position");
            return;
        }
        head = insert_pos(val, index, head);//starting with head.
    }
    private Node insert_pos(int val,int index,Node node){
        if(index==1){
            Node newnode = new Node(val,node);//here the next ref variable is passed as current node beacause newnode will point to it.
            size++;
            return newnode;
        }
        node.next = insert_pos(val, index-1, node.next);
        return node;
    }
    public void Insert_end(int val){
        Node newnode = new Node(val);
        if(head==null){
            head = newnode;
            tail = newnode;
        }else{
            tail.next = newnode;
            tail = newnode;
        }
        size++;
    }
    public void display(){
        if(head==null){
            System.out.println("\nERROR: Linked List is Empty!!");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }
    private class Node{
        private int val;
        private Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
        public Node(int val,Node next){
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        Recursion_Insert_at_index obj = new Recursion_Insert_at_index();
        // obj.Insert_end(3);
        // obj.Insert_end(5);
        // obj.Insert_end(9);
        // obj.Insert_end(1);
        obj.Recur_insert(2, 69);
        obj.display();
        System.out.println("The size of Linked List is: "+obj.size);
    }
}