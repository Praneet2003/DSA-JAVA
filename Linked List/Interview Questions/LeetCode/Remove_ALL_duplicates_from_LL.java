// Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
// Example 1:
// Input: head = [1,2,3,3,4,4,5]
// Output: [1,2,5]
public class Remove_ALL_duplicates_from_LL {
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr!=null && curr.next!=null){
            if(curr.val==curr.next.val){
                ListNode temp = curr;
                while(temp.next!=null && temp.val==temp.next.val){
                    temp = temp.next;
                }
                prev.next = temp.next;
                curr = prev.next;
            }else{
                prev= curr;
                curr = curr.next;
            }
        }
        return dummy.next;
        //we are not returning the head because it always contains the ll
        //what if the head points to the duplicates itself
    }
}