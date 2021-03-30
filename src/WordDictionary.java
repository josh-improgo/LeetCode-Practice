/**
 * 211. Design Add and Search Words Data Structure
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 */
public class WordDictionary {
    private Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new Node('\0');
    }

    public void addWord(String word) {
        Node current = root;
        for ( int i = 0; i < word.length(); i++ ) {
            char c = word.charAt(i);
            if ( current.children[ c - 'a' ] == null ) current.children[ c - 'a' ] = new Node(c);
            current = current.children[ c - 'a' ];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        // implement backtracking?
        return find(word, root, 0);
    }

    private boolean find(String word, Node current, int index) {
        if ( index == word.length() ) return current.isWord;
        char c = word.charAt(index);
        if ( c == '.' ) {
            for ( int i = 0; i < 26; i++ ) {
                if ( current.children[i] != null && find(word, current.children[i], index + 1) ) return true;
            }
            return false;
        } else {
            return current.children[ c - 'a' ] != null && find( word, current.children[ c - 'a'], index + 1 );
        }
    }

    public class Node {
        public char c;
        public boolean isWord;
        public Node[] children;

        public Node (char c) {
            this.c = c;
            this.isWord = false;
            this.children = new Node[26];
        }
    }
}
