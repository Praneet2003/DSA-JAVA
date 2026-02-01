class Vales_Node_Deletion_from_LL{
    private Node head;
    private Node tail;
    private int size;
    public Vales_Node_Deletion_from_LL(){
        this.size =0;
    }
    private class Node{
        private int data;
        private Node next;
        public Node(int val){
            this.data = val;
            this.next = null;
        }
        public Node(int val, Node next){
            this.data = val;
            this.next = next;
        }
    }
    public void Insert_At_first(int val){
        Node newnode = new Node(val);
        newnode.next = head;
        head = newnode;
        if(tail==null){//if the LL was empty updating tail.
            tail = head;
        }
        size++;
    }
    public void Insert_In_Middle(int pos,int val){
        Node newnode = new Node(val);
        if(pos<1){
            System.out.println("Invalid position");
            return;
        }
        if(pos==1){
            newnode.next = head;
            head = newnode;
            if(tail==null){
                tail = head;
            }
            size++;
            return;
        }
        Node temp = head;
        int i=1;
        while(i<pos-1 && temp!=null){
            temp = temp.next;
            i++;
        }
        if(temp==null){
            System.out.println("Invalid Position");
            return;
        }
        newnode.next = temp.next;
        temp.next = newnode;
        if(newnode.next==null){
            tail = newnode;
        }
        size++;
    }
    public void Insert_At_End(int val){
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
            System.out.println("Linked List is empty.");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ->");
            temp = temp.next;
        }
        System.out.println("Null");
    }
    public void Delete_from_first(){
        if(head==null){
            tail = null;
            return;
        }
        head = head.next;
        if(head==null){
            tail = null;
        }
        size--;
        return;
    }
    public void Deletion_from_Middle(int pos){
        if(head==null || pos<1){
            System.out.print("Invalid Position");
            return;
        }
        if(pos==1){
            head = head.next;
            if(head==null){
                tail = null;
            }
            size--;  
            return;     
        }
        Node temp = head;
        int i=1;
        while(i<pos-1 && temp!=null){
            temp = temp.next;
        }
        if(temp.next==null||temp.next.next==null){
            System.out.print("Invalid position");
            return;
        }
        temp.next = temp.next.next;
        if(temp.next==null){
            tail = temp;
        }
        size--;
    }
    public void Delete_from_End(){
        if(head==null){
            tail = null;
            System.out.println("LL is empty");
            return;
        }
        if(head.next==null){
            head = null;
            tail = null;
            size--;
            return;
        }
        Node temp = head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }
    public static void main(String[] args) {
        Vales_Node_Deletion_from_LL obj = new Vales_Node_Deletion_from_LL();
        obj.Insert_At_first(10);
        obj.Insert_At_End(20);
        obj.Insert_In_Middle(1, 30);
        obj.Insert_In_Middle(4,50);
        // 30 ->10 ->20 ->50 ->Null
        // Size of LL is: 4

        obj.Delete_from_first();
        obj.Delete_from_End();
        obj.Deletion_from_Middle(1);
        obj.display();
        System.out.println("Size of LL is: "+obj.size);
    }
}