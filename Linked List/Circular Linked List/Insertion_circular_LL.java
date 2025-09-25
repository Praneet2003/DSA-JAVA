class Insertion_circular_LL{
    private Node head;
    private int size;
    private Node tail;
    public Insertion_circular_LL(){
        this.size = 0;
    }
    public void Insert_first(int val){
        Node newnode = new Node(val);
        if(head==null){
            head = newnode;
            tail = newnode;
        }else{
            newnode.next = head;
            head = newnode;
        }
        tail.next = head;
        size++;
    }
    public void Insert_end(int val){
        Node newnode = new Node(val);
        if(head==null){
            head = newnode;
            tail=newnode;
        }else{
            tail.next = newnode;
            tail = newnode;
        }
        tail.next = head;
        size++;
    }
    public void insert_pos(int pos,int val){
        Node newnode = new Node(val);
        if((head==null && pos!=1)||pos<1){
            System.out.println("\n ERROR: Invalid Position");
            return;
        }
        if(pos==1){
            if(head==null){
                head = newnode;
                tail = newnode;
            }else{
                newnode.next = head;
                head = newnode;
            }
            tail.next = head;
            size++;
            return;
        }
        Node temp = head;
        int i =1;
        while(i<pos-1){//here i didn't added temp!=null because in circular LL, node can never point to null.
            temp = temp.next;
            i++;
            if(temp==head){
                System.out.println("\nERROR: Invalid Position,Out of bounds");
                return;
            }
        }
        if(i<pos-1){
            System.out.println("\nERROR: Invalid position");
            return;
        }
        newnode.next = temp.next;
        temp.next = newnode;
        if(temp==tail){
            tail = newnode;
        }
        tail.next = head;
        size++;
    }
    public void display(){
        Node temp = head;
        if(head==null){
            System.out.println("The Circular Linked List is Empty.");
            return;
        }else{
            do { 
                System.out.print(temp.val+" ->");
                temp = temp.next;
            } while (temp!=head);
        }
        System.out.println("Head");
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
        Insertion_circular_LL obj = new Insertion_circular_LL();
        obj.Insert_end(10);
        obj.Insert_end(20);
        obj.Insert_first(13);
        obj.Insert_end(30);
        obj.insert_pos(1, 26);
        obj.display();
        System.out.println("The Size of ArrayList is: "+obj.size);
    }
}