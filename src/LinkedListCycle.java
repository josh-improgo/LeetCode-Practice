import java.util.HashSet;

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    /** Solution 1: Hashset Solution **/
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        while ( head != null ) {
            if ( set.contains(head) ) return true;
            else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }

    /** Solution 2: Fast and Slow Pointer **/
    public boolean hasCycle2(ListNode head) {
        if ( head == null ) return false;
        ListNode pointerA = head;
        ListNode pointerB = head.next;

        while ( pointerA != pointerB ) { // check while they are not equal to each other
            if ( pointerB == null || pointerB.next == null ) return false; // return false if we reached the end and there was never a cycle
            pointerA = pointerA.next;
            pointerB = pointerB.next.next;

        }
        return true; // break out of loop means they are equal to each other
    }

    public boolean hasCycle3(ListNode head) {
        if ( head == null ) return false;
        ListNode slow = head;
        ListNode fast = head;

        while ( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
            if ( slow == fast) return true;
        }

        return false;
    }
}
