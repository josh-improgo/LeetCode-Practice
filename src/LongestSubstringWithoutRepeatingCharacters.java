import java.util.HashSet;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /** Solution 1: Sliding Window **/
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if ( length == 0 )
            return 0;

        HashSet<Character> set = new HashSet<>();

        char[] sArray = s.toCharArray();

        int max = 0;
        int currentLength = 0;

        int left = 0;
        int right = 0;

        while ( right < length ) {
            if ( set.contains(sArray[right]) ) {
                set.remove(sArray[left]);
                left++;
                currentLength--;
            } else {
                set.add(sArray[right]);
                right++;
                currentLength++;
            }
            max = Math.max(currentLength, max);
        }

        return max;
    }
}
