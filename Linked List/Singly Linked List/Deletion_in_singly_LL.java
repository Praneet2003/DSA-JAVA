class Deletion_in_singly_LL{
    private Node head;
    private Node tail;
    private int size;
    public Deletion_in_singly_LL(){
        this.size=0;//initially LL is empty.
    }
    public void Insert_At_first(int val){
        Node newnode = new Node(val);
        newnode.next = head;
        head = newnode;
        if(tail==null){
            tail = head;
        }
        size+=1;
    }
    public void Insert_In_Middle(int pos,int val){
        if((head==null && pos!=1) || (pos<1 || pos>size+1)){
            System.out.println("Invalid Position");
            return;
        }
        Node newnode = new Node(val);
        if(pos==1){//handles insertion at first node.
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
        size+=1;
    }
    public void deletion_first(){
        if(head == null){
            tail = null;
            return;
        }
        head = head.next;
        if(head == null){//if after deletion list becomes empty it makes sures to null tail too.
            tail = null;
        }
        size-=1;
    }
    public void deletion_end(){
        Node temp = head;
        if(head ==null){//LL is empty.
            return;
        }
        if(head.next ==null){//only single node is present.
            head = null;
            tail = null;
            size--;
            return;
        }
        while(temp.next.next!=null){
            temp = temp.next;
        }
        tail = temp;
        temp.next = null;
        size--; 
    }
    public void deletion_from_mid(int pos){
        if(head==null || pos<1){
            return;
        }
        if(pos==1){
            head = head.next;
            if(head==null){//if after deletion LL becomes empty.
                tail = null;
            }
            size--;
            return;
        }
        Node temp = head;
        int i=1;
        while(i<pos-1 && temp!=null){
            temp = temp.next;
            i++;
        } 
        if(temp.next==null){
            System.out.print("Invalid position");
            return;
        }
        temp.next =  temp.next.next;
        if(temp.next==null){
            tail = temp;
        }
        size--;
    }
    public void display(){
        Node temp = head;
        System.out.println("");
        while(temp!=null){
            System.out.print(temp.data+" ->");
            temp = temp.next;
        }
        System.out.print("Null");
    }
    private class Node{
        private int data;
        private Node next;
        public Node(int val){
            this.data = val;
            this.next = null;
        }
        public Node(int val,Node next){
            this.data = val;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        Deletion_in_singly_LL obj = new Deletion_in_singly_LL();
        obj.Insert_At_End(10);
        obj.Insert_At_first(5);
        obj.Insert_At_End(15);
        obj.Insert_At_first(20);
        obj.Insert_At_End(25);
        obj.Insert_In_Middle(3, 12);
            // 20 ->5 ->12 ->10 ->15 ->25 ->Null
           // No of element in the LL is: 6
        obj.deletion_first();
        obj.deletion_end();
        // 5 ->12 ->10 ->15 ->Null
        // No of element in the LL is: 4
        
        obj.deletion_from_mid(4);
        // 5 ->12 ->10 ->Null
        // No of element in the LL is: 3
        obj.deletion_from_mid(1);
        obj.display();
        System.out.println("\nNo of element in the LL is: "+obj.size);
    }
}
