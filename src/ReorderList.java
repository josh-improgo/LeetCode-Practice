/**
 * 143. Reorder List
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {
    /**
    // Find the middle

    // To do so, use the slow and fast pointer. Slow goes 1 step, fast goes 2 steps
    // When fast.next is null, the slow pointer is at it's middle, therefore slow will be our mid

    // Then, reverse list after the middle
    // Looking at the sublist, we use three variables
    // prev, curr, and temp
    // initialized:
    // prev: null, curr: 4, temp: curr.next
    // when current reaches null, we have reached the end of the list and we now have our reversed list
    // We then have two lists

    // change the first's next
    // temp = first.next
    // first.next = second
    // first = temp

    // change the second's next
    // temp = second.next
    // second.next = first;
    // second = temp;

    // 3 Main Steps:
         1. Find middle
            while fastPointer is not null and it's next is not null
            a) slow = slow.next
            b) fast = fast.next.next
            c) when fast comes to null, node at slow is mid
         2. Reverse List After Mid
            a) take 3 pointers, prev = null, curr = mid, temp = curr.next
            b) while curr != null
                # temp = curr.next
                # curr.next = prev
                # prev = curr
                # curr = temp
         3. Merge 2 Lists
            a) first = head; second = prev
            b) while second.next != null
                Make second as of next of first and move first
                # temp = first.next
                # first.next = second
                # first = temp

                Make second.next as first new and move second
                # temp = second.next
                # second.next = first
                # second = temp
     **/
    /** Solution 1: Time O(n) Space O(1) **/
    public void reorderList(ListNode head) {
        if ( head == null ) return;

        // Find the middle
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while ( fastPointer != null && fastPointer.next != null ) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        // Reverse the list after mid
        ListNode current = slowPointer; // slowPointer is the middle
        ListNode temp;
        ListNode previous = null;

        while ( current != null ) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        // Merge the 2 lists
        ListNode first = head;
        ListNode second = previous;

        while ( second.next != null ) {
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }

    }
}
