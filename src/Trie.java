/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class Trie {
    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node('\0');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node current = root;
        for ( int i = 0; i < word.length(); i++ ) {
            char c = word.charAt(i);
            if ( current.children[ c - 'a' ] == null ) {
                current.children[ c - 'a' ] = new Node(c);
            }
            current = current.children[ c - 'a' ];
        }
        current.isWord = true;
    }

    private Node getNode(String word) {
        Node current = root;
        for ( int i = 0; i < word.length(); i++ ) {
            char c = word.charAt(i);
            if ( current.children[ c - 'a' ] == null ) return null;
            current = current.children[ c - 'a' ];
        }
        return current;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = getNode(word);

        return node != null && node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    // Create a node class to store individual letters
    public class Node {
        public char c;
        public boolean isWord;
        public Node[] children;

        public Node(char c) {
            this.c = c;
            this.isWord = false;
            this.children = new Node[26];
        }


    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */