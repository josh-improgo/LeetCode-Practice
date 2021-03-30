/**
 * 424. Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        // do the window but giving leniency dependent on k
        // if the letter is the same, continue and increase the longest count variable
        // if it is different, decrement k, continue on

        // j - i + 1 - maxCount: the number of characters in the window that aoccurred the most = number of replacements needed
        int length = s.length();

        int left = 0, right = 0, maxCount = 0, maxLength = 0;
        char[] counter = new char[26];

        while ( right < length ) {
            int index = s.charAt(right) - 'A' ; // because we have capital letters only, we can get the index here
            counter[index]++; // increment the counter here

            maxCount = Math.max(maxCount, counter[index]);
            // right - left is the length, + 1 to include the current letter, - maxCount
            while ( right - left + 1 - maxCount > k ) {
                counter[ s.charAt(left) - 'A' ]--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1 );
            right++;

        }
        // System.out.println(s.charAt(right));
        // System.out.println(counter[s.charAt(right)] - 'A');
        // System.out.println((int)'A');
        // System.out.println((int)counter[right]);

        return maxLength;
    }
}
