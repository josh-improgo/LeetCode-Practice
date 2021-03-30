import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // value, count

        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> map.get(n1) - map.get(n2) );


        for ( int num : nums ) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for ( int num : map.keySet() ) {
            heap.add(num);
            if ( heap.size() > k) heap.poll();
        }

        int[] ans = new int[k];
        for ( int i = 0; i < k; i++ ) {
            ans[i] = heap.poll();
        }

        return ans;

    }
}
