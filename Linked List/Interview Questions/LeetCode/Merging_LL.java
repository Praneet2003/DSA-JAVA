class Node{
    public int val;
    public Node next;
    public Node(int val){
        this.val= val;
    }
    public Node(int val,Node next){
        this.val = val;
        this.next = next;
    }
}
class LinkedList{
    Node head;
    Node tail;
    public void Insert_end(int val){
        Node newnode = new Node(val);
        if(head==null){
            head = newnode;
            tail = newnode;
        }else{
            tail.next = newnode;
            tail = newnode;
        }
    }
    public void display(){
        if(head==null){
            System.out.println("LL is empty!!");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ->");
            temp = temp.next;
        }
        System.out.println(" End");
    }
}
class Merging_LL{
    public static Node Merge(Node list1, Node list2){
        Node ans = new Node(-1);
        Node tail = ans;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        if(list1!=null){
            tail.next = list1;
        }else{
            tail.next = list2;
        }
        return ans.next;
    }
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list1.Insert_end(1);
        list1.Insert_end(3);
        list1.Insert_end(5);

        list2.Insert_end(2);
        list2.Insert_end(4);
        list2.Insert_end(9);
        list2.Insert_end(14);
        Node ans = Merge(list1.head,list2.head);
        LinkedList obj = new LinkedList();
        obj.head = ans;
        obj.display();
    }
}