class Inplace_reverse_LL{
    Node head;
    Node tail;
    int size;
    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
        public Node(int val,Node next){
            this.val = val;
            this.next = next;
        }
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
            System.out.println("LL is empty.");
            return;
        }else{
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.val+" ->");
                temp = temp.next;
            }
            System.out.println(" Null");
        }
    }
    public void Reverse_inplace(){
        Node prev = null;
        Node current = head;
        while(current!=null){
            Node nextnode = current.next;
            current.next = prev;
            prev = current;
            current = nextnode;
        }
        head = prev;
    }
    public static void main(String[] args) {
        Inplace_reverse_LL obj = new Inplace_reverse_LL();
        obj.Insert_end(43);
        obj.Insert_end(32);
        obj.Insert_end(56);
        obj.Insert_end(32);
        obj.Insert_end(123);
        obj.display();
        obj.Reverse_inplace();
        obj.display();
    }
}
// 43 ->32 ->56 ->32 ->123 -> Null
// 123 ->32 ->56 ->32 ->43 -> Null