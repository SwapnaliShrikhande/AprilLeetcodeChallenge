/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null)
            return new ListNode(-1);
        
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        
        int midPoint = length/2;
        temp = head;
        while (midPoint > 0) {
            midPoint--;
            temp = temp.next;
        }
        
        return temp;
    }
}