public class Recursive_Reverse_k_groups_in_LL {
    public static void main(String[] args) {
        
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        int count = 0;
        ListNode temp = head;
        while(count<k){
            if(temp==null){
                return head;
            }
            temp = temp.next;
            count++;
        }
        ListNode prev = reverseKGroup(temp,k);
        temp = head;
        count=0;
        while(count<k){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
            count++;
        }
        return prev;
    }
}