import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * https://leetcode.com/problems/palindrome-partitioning/submissions/
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> validDecompositions = new ArrayList<>();

        List<String> decompInProgress = new ArrayList<>();

        decomposeString(s, 0, decompInProgress, validDecompositions);

        return validDecompositions;
    }

    private void decomposeString(String s, int buildPointer, List<String> decompInProgress, List<List<String>> validDecompositions) {
        if ( buildPointer == s.length() ) {
            // base case
            // if we reach the index of this length, this means that
            // we are at the end and everything before was a valid palindrome
            // this means we can now add the partition into the validdecompositions
            validDecompositions.add(new ArrayList<>(decompInProgress));

        } else {
            for ( int i = buildPointer; i < s.length(); i++ ) {
                // is the snippet a palindrome? if it is then add it to our progress
                if ( isPalindrome(buildPointer, i, s) ) {
                    String palindromicSnippet = s.substring(buildPointer, i+1);
                    decompInProgress.add(palindromicSnippet);
                    decomposeString(s, i+1, decompInProgress, validDecompositions); // explore all our options
                    decompInProgress.remove(decompInProgress.size() - 1); // return to our stack frame
                    // this means we remove the snippet that we were exploring and choose another snippet
                }
            }
        }
    }

    private boolean isPalindrome(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}