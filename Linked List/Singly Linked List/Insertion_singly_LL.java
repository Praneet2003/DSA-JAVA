public class Insertion_singly_LL{
    private Node head;
    private Node tail;
    private int size;
    public Insertion_singly_LL(){
        this.size=0;
    }
    private class Node{
        private int value;
        private Node next;
        public Node(int data){
            this.value = data;
            this.next = null;//initially it is null.
        }
        public Node(int data, Node next){
            this.value = data;
            this.next=next;
        }
    }
    public void Insert_first(int val){
        Node newnode = new Node(val);
        newnode.next = head;
        head = newnode;
        if(tail==null){
            tail=head;
        }
        size+=1;
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
        size+=1;
    }
    public void Insert_In_Middle(int pos,int val){
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
        if(head==null){//handles insertion in an empty LL
            if(pos!=1){
                System.out.println("Invalid position to insert");
                return;
            }
        }
        Node temp = head;
        int i=1;
        while(i<pos-1 && temp!=null){
            temp = temp.next;
            i++;
        }
        if(temp==null){
            System.out.println("Invalid position to insert");
            return;
        }
        newnode.next = temp.next;
        temp.next = newnode;
        if(newnode.next==null){//i.e newnode is the last node hence we should need to update the tail.
            tail = newnode;
        }
        size++;
    }
    public void display(){
        Node temp = head;
        System.out.println("");
        while(temp!=null){
            System.out.print(temp.value+"->");
            temp = temp.next;
        }
        System.out.print("Null");
    }
    public static void main(String[] args){
        Insertion_singly_LL obj = new Insertion_singly_LL();
        obj.Insert_first(10);
        obj.Insert_first(20);
        obj.Insert_first(13);
        obj.Insert_first(2);
        obj.Insert_first(23);
        obj.Insert_end(16);//23->2->13->20->10->16->Null
        obj.Insert_In_Middle(3, 100);
        obj.Insert_In_Middle(6, 40);
        obj.display();
        System.out.println("\n No of elements in the Linked List is: "+obj.size);
    }
}