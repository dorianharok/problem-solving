/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var node1 = l1
        var node2 = l2

        var list = ListNode(0)
        var remainder = 0
        var up = 0
        var next = list
        while(node1 != null || node2 != null || up != 0) {
            var sum = 0
            if(node1 != null) {
                sum += node1.`val`
                node1 = node1.next
            }

            if(node2 != null) {
                sum += node2.`val`
                node2 = node2.next
            }

            remainder = (sum + up) % 10
            up = (sum + up) / 10

            next.next = ListNode(remainder)
            next = next.next
        }

        return list.next
    }
}