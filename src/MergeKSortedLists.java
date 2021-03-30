import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    /** Solution 1: Put everything into a minheap (Means put it into PriorityQueue) O(n log k) **/
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode(-1); // set a dummy node
        ListNode current = merged; // have a reference to head of list to start adding things to it

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for ( int i = 0; i < lists.length; i++ )
            while ( lists[i] != null ) {
                queue.add(lists[i].val);
                lists[i] = lists[i].next;
            }

        while ( !queue.isEmpty() ) {
            int min = queue.remove();
            current.next = new ListNode(min);
            current = current.next;

        }


        return merged.next;
    }

    /** Solution 2: Brute Force Solution, Put everything into an ArrayList, sort, and merge into one list  O(n)**/
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode merged = new ListNode(-1);
        ListNode current = merged;
        ArrayList<Integer> nodes = new ArrayList<>();

        for ( ListNode list : lists) {
            while ( list != null ) {
                nodes.add(list.val);
                list = list.next;
            }
        }

        Collections.sort(nodes);

        for ( int val : nodes ) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return merged.next;
    }

    /** Solution 3: Merge lists one by one (Using mergeTwoLists) **/
    public ListNode mergeKLists3(ListNode[] lists) {
        if ( lists.length == 0 ) return null;
        ListNode mergedList = lists[0];
        for ( int i = 1; i < lists.length; i++ ) {
            mergedList = mergeTwoLists(mergedList, lists[i]);
        }

        return mergedList;
    }

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
