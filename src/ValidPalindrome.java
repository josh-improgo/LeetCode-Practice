/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if ( s.length() == 0 ) return true;

        int pointerA = 0;
        int pointerB = s.length()-1;

        s = s.toLowerCase();

        while ( pointerA < pointerB ) {
            while ( !Character.isLetterOrDigit(s.charAt(pointerA)) ) {
                pointerA++;
                if ( pointerA > pointerB ) return true;
            }

            while ( !Character.isLetterOrDigit(s.charAt(pointerB)) ) {
                pointerB--;
                if ( pointerB < pointerA ) return true;

            }

            char a = s.charAt(pointerA);
            char b = s.charAt(pointerB);

            if ( a != b ) return false;
            pointerA++;
            pointerB--;
        }
        return true;
    }
}
