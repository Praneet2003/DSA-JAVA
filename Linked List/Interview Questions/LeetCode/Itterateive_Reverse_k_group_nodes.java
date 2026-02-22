public class Itterateive_Reverse_k_group_nodes {
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
        int n = 0;
        ListNode t = head;
        while(t!=null){
            n++;
            t = t.next;
        }
        int i = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr!=null && k<=(n-i)){
            int j =0;
            ListNode temp = curr;
            while(j<k){
                temp = temp.next;
                j++;
            }
            ListNode last = curr;
            ListNode next = temp;
            ListNode p1 = null;
            ListNode c1 = curr;
            for(int x =0;x<k;x++){
                ListNode n1 = c1.next;
                c1.next = p1;
                p1 = c1;
                c1 = n1;
            }
            prev.next = p1;
            last.next = next;
            prev = last;
            curr = prev.next;
            i = i+k;
        }
        return dummy.next;
    }
}