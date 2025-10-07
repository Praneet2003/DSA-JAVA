class Merge_sort_Linked_list{
    private Node head;
    private Node tail;
    private int size;
    public Merge_sort_Linked_list() {
        this.size=0;
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
    private static class Node{
        private int val;
        private Node next;
        public Node(int val){
            this.val = val;
            this.next = next;
        }
        public Node(int val,Node next){
            this.val = val;
            this.next = next;
        }
    }
    public static Node merge_sort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node mid = middle_node(head);
        Node right = mid.next;
        mid.next=null;
        Node leftSorted = merge_sort(head);
        Node rightSorted = merge_sort(right);
        return Merge(leftSorted,rightSorted);
    }
    public static Node middle_node(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Node Merge(Node list1, Node list2){
        Node ans = new Node(-1);
        Node current = ans;
        while(list1!=null &&  list2!=null){
            if(list1.val < list2.val){
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if(list1!=null){
            current.next = list1;
        }else{
            current.next = list2;
        }
        return ans.next;
    }
    public void display(){
        Node temp = head;
        if(head==null){
            System.out.println("Linked List is Empty!!");
            return;
        }
        while(temp!=null){
            System.out.print(temp.val+" ->");
            temp =temp.next;
        }
        System.out.println("NUll");
    }
    public static void main(String args[]){
        Merge_sort_Linked_list obj = new Merge_sort_Linked_list();
        obj.Insert_end(4);
        obj.Insert_end(2);
        obj.Insert_end(671);
        obj.Insert_end(31);
        obj.Insert_end(5);
        obj.head = merge_sort(obj.head);
        obj.display();
    }
}