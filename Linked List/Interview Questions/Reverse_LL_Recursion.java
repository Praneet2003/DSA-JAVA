class Reverse_LL_Recursion{
    Node head;
    Node tail;
    int size;
    public Reverse_LL_Recursion(){
        this.size = 0;
    }
    private void Reverse(Node node){
        if(node==tail){
            head = tail;
            return;
        }
        Reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
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
            System.out.println("THE LL IS EMPTY!!");
            return;
        }
        Node temp = head; 
        while(temp!=null){
            System.out.print(temp.val+" ->");
            temp = temp.next;
        }
        System.out.println(" Null");
    }
    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        Reverse_LL_Recursion obj = new Reverse_LL_Recursion();
        obj.Insert_end(51);
        obj.Insert_end(4);
        obj.Insert_end(3);
        obj.Insert_end(2);
        obj.Insert_end(1);
        obj.display();
        obj.Reverse(obj.head);
        obj.display();
    }
}
// Original: 51 ->4 ->3 ->2 ->1 -> Null
// Reversed: 1 ->2 ->3 ->4 ->51 -> Null