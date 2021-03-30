public class RemoveNthNodeFromEndOfList {

    /** Solution 1: Modified Slow and Fast Pointer **/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slowPointer = dummy;
        ListNode fastPointer = dummy;

        int distance = 0;
        while ( fastPointer.next != null ) {
            // keep incrementing the fast pointer
            // increment the slow pointer only if the distance between fast and slow is greater than n
            fastPointer = fastPointer.next;
            distance++;
            if ( distance > n ) {
                slowPointer = slowPointer.next;
            }

        }
        slowPointer.next = slowPointer.next.next;
        return dummy.next;

    }
    /** Brute Force Solution **/
    /** Brute Force Solution **/
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int length = 0;

        ListNode firstPass = head;
        while ( firstPass != null ) {
            length++;
            firstPass = firstPass.next;
        }

        length -= n;

        firstPass = dummy;
        while ( length > 0 ) {
            length--;
            firstPass = firstPass.next;
        }

        firstPass.next = firstPass.next.next;
        return dummy.next;

    }
}
