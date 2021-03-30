import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    /** Solution 1: Sorted Array Time: O(nlogn), Space: O(1) **/
    public boolean isAnagram(String s, String t) {
        // What my immediate thought is: put both into char array
        // Sort them, then compare both at each index
        // if one is not the same, then return false

        int length = s.length();

        if ( length != t.length() ) return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);


        for ( int i = 0; i < length; i++ )
            if ( sArray[i] != tArray[i] ) return false;

        return true;
        /*
            Can do:
            Arrays.equals(sArray, tArray);
         */
    }

    /** Solution 2: HashMap **/
    public boolean isAnagram2(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        int length = s.length();
        if ( length != t.length() ) return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        for ( char c : sArray ) {
            if ( map.containsKey(c) ) {
                int val = map.get(c) + 1;
                map.put(c, val);
            } else {
                map.put(c, 1);
            }
        }

        for ( char c : tArray ) {
            if ( !map.containsKey(c) ) return false;
            else {
                int val = map.get(c);
                if ( val-- == 0 ) return false;
                else {
                    map.put(c, val);
                }
            }
        }

        for ( Character c : map.keySet() ) {
            if ( map.get(c) != 0 ) return false;
        }

        return true;
    }

    /** Solution 3: HashTable, using ASCII positioning Time: O(n), Space: O(1) **/
    public boolean isAnagram3(String s, String t) {
        // since they are all lowercase, you can just do an array of 26 lower letters
        int length = s.length();
        if ( length != t.length() ) return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        char[] chars = new char[26];

        for ( int i = 0; i < length; i++ ) {
            chars[ sArray[i] - 'a' ] ++;
            chars[ tArray[i] - 'a' ] --;
        }

        for ( int i = 0; i < chars.length; i++ ) {
            if ( chars[i] != 0 ) return false;
        }

        return true;
    }

}
