/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedNode = new ListNode(-1);
        ListNode currentNode = mergedNode;

        while ( l1 != null && l2 != null ) {
            if ( l1.val < l2.val ) {
                currentNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                currentNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }

            currentNode = currentNode.next;
        }

        if ( l1 != null ) {
            currentNode.next = l1;
        } else {
            currentNode.next = l2;
        }

        return mergedNode.next;
    }
}
