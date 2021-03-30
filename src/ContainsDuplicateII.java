import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 219. Contains Duplicate II
 * https://leetcode.com/problems/contains-duplicate-ii/submissions/
 */
class ContainsDuplicateII {
    /** Solution 1: Using HashMap and Object **/
    public class Info {
        public ArrayList<Integer> indices;
        public int count;

        public Info(int count) {
            this.indices = new ArrayList<>();
            this.count = count;
        }

        public void addIndex(int index) {
            indices.add(index);
        }
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Info> map = new HashMap<>();

        for ( int i = 0; i < nums.length; i++ ) {
            if ( map.containsKey(nums[i]) ) {
                Info info = map.get(nums[i]);
                info.count++;
                info.addIndex(i);
            } else { // this is a new number
                Info info = new Info(1);
                info.addIndex(i);
                map.put(nums[i], info);
            }
        }


        for ( int key : map.keySet() ) {
            if ( map.get(key).count > 1 ) {// contains duplicate
                ArrayList<Integer> indices = map.get(key).indices;
                for ( int i = 0; i < indices.size(); i++ ) {
                    for ( int j = i+1; j < indices.size(); j++ ) {
                        if ( indices.get(j) - indices.get(i) <= k ) return true;
                    }
                }
            }
        }

        return false;
    }

    /** Solution 2: Brute Force **/
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        int left = 0;
        int right = left+1;

        while ( left < nums.length ) {
            if ( right >= nums.length ) {// reset pointers
                left++;
                right = left + 1;
            } else {
                if ( nums[left] == nums[right] ) {
                    if ( right - left <= k ) return true;
                }
                right++;
            }

        }

        return false;
    }

    /** Solution 3: HashMap, store value and most recent index **/
    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // value, index

        for ( int i = 0; i < nums.length; i++ ) {
            if ( map.containsKey(nums[i]) ) {
                int difference = i - map.get(nums[i]);
                if ( difference <= k ) return true;
                else map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }

        return false;
    }

    /** Solution 4: HashSet Solution, look within "K" window **/
    public boolean containsNearbyDuplicate4(int[] nums, int k) {
        // you check only within a "k" window
        // if you have seen a number within a k window, then you return true
        // you remove numbers past k window, don't look outside that range
        HashSet<Integer> set = new HashSet<>();
        for( int i = 0; i < nums.length; i++ ) {
            if( !set.add(nums[i]) )
                return true; // if it already is in the hashset, then you return true
            if( i >= k ) // if the index is greater than k then
                set.remove(nums[i-k]);
        }
        return false;
    }
}