class Palindrome_Linked_list{
    Node head;
    Node tail;
    int size;
    public Palindrome_Linked_list(){
        this.size = 0;
    }
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
    public boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = null;
        // when fast or fast.next ->null then slow points to the mid node
        Node current = slow;//mid
        while(current!=null){
            Node nextnode = current.next;
            current.next = prev;
            prev = current;
            current = nextnode;
        }
        Node f= head;
        Node s = prev;
        while(s!=null){
            if(f.val!=s.val){
                return false;
            }
            f = f.next;
            s = s.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Palindrome_Linked_list obj = new Palindrome_Linked_list();
        obj.Insert_end(1);
        obj.Insert_end(2);
        obj.Insert_end(3);
        obj.Insert_end(2);
        obj.Insert_end(1);
        obj.display();
        if(obj.isPalindrome(obj.head)){
            System.out.println("The Linked List is Palindrome");
        }else{
            System.out.println("The Linked List is not Palindrome");
        }
    }
}