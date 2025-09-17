class Deletion_without_tail_in_DLL{
    private Node head;
    private int size;
    public Deletion_without_tail_in_DLL(){
        this.size = 0;
    }
    public void Delete_form_pos(int pos){
        if((head==null && pos!=1)||pos<1){
            System.out.println("Invalid Position");
            return;
        }
        if(pos==1){
            Delete_first();
            return;
        }
        Node temp = head;
        int i=1;
        while(i<pos-1 && temp!=null){
            temp = temp.next;
            i++;
        }
        if(temp==null || temp.next==null){
            System.out.println("Invalid position, Out of bound");
            return;
        }
        if(temp.next.next!=null){
            temp.next = temp.next.next;
            temp.next.prev = temp;
            size--;
            return;
        }else{
            temp.next = null;
            size--;
            return;
        }
    }
    public void Delete_end(){
        if(head==null){
            System.out.println("\nError: The DLL is empty");
            return;
        }
        if(head.next==null){
            head = null;
            size--;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.prev.next = null;
        temp.prev = null;
        size--;
        return;
    }
    public void Delete_first(){
        if(head==null){
            System.out.println("\nERROR: Doubly Linked List is Empty");
            return;
        }
        if(head.next == null){
            head=null;
            size--;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }
    public void Insertfirst(int val){
        Node newnode = new Node(val);
        newnode.next = head;
        newnode.prev = null;
        if(head!=null){
            head.prev = newnode;
        }
        head = newnode;
        size++;
    }
    public void insert_end(int val){
        Node newnode = new Node(val);
        if(head==null){
            newnode.next = head;
            newnode.prev = null;
            if(head!=null){
                head.prev = newnode;
            }
            head = newnode;
            size++;
            return;
        }else{
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            newnode.prev = temp;
            newnode.next = null;
            temp.next = newnode;
            size++;
        }
    }
    public void insert_pos(int pos,int val){
        Node newnode = new Node(val);
        if((head==null&&pos!=1)|| pos<1){
            System.out.println("\nERROR: Invalid Position");
            return;
        }if(pos==1){
            Insertfirst(val); 
            return;
        }
        Node temp = head;
        int i=1;
        while(i<pos-1 && temp!=null){
            temp = temp.next;
            i++;
        }
        if(temp==null){
            System.out.println("\nERROR: Invalid Position, Out of Bound");
            return;
        }
        newnode.prev = temp;
        newnode.next = temp.next;
        if(temp.next!=null){
            temp.next.prev= newnode;
        }
        temp.next = newnode;
        size++;
    }
    public void display(){
        Node temp = head;
        Node last = null;
        while(temp!=null){
            System.out.print(temp.val+" ->");
            last = temp;
            temp = temp.next;
        }
        System.out.println("End Null");
        System.out.println("Printing in Reverse: ");
        while(last!=null){
            System.out.print(last.val+" ->");
            last = last.prev;
        }
        System.out.println("Start Null");
    }
    private class Node{
        private int val;
        private Node prev;
        private Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
            this.prev = null;
        }
        public Node(int val,Node next,Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
    public static void main(String[] args) {
        Deletion_without_tail_in_DLL obj = new Deletion_without_tail_in_DLL();
        obj.insert_end(10);
        obj.insert_end(20);
        obj.Insertfirst(1);
        obj.insert_pos(2, 24);
        obj.Delete_first();
        obj.Delete_form_pos(3);
        obj.Delete_end();
        obj.display();
        System.out.println("size of the Doubly Linked List is: "+obj.size);
    }
}