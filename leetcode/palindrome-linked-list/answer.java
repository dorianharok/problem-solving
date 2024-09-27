/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        ListNode next = head;
        while(next != null) {
            stack.add(next);
            next = next.next;
        }

        while(!stack.isEmpty()) {
            ListNode pop = stack.pop();
            if (head.val != pop.val) {
                return false;
            }
            head = head.next;
        }

        return true;
    }
}