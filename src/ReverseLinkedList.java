/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
    /** Solution 1: Iterative Approach **/
    /** Time Complexity: O(n)
     *  Space Complexity: O(1)
     **/
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        // set current's next to previous
        // set previous to current
        // set current to next
        while ( current != null ) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        return previous;

    }

    /** Solution 2: Recursive Approach **/

    public ListNode reverseList2(ListNode head) {
        if ( head == null || head.next == null ) return head;
        ListNode previous = reverseList(head.next);
        head.next.next = head; // set head.next's next to head
        head.next = null;
        return previous;
    }
}
