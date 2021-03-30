/**
 *
 */
public class MaximumDepthOfBinaryTree {
    /** Solution 1: Recurse through left and right subtree **/
    public int maxDepth(TreeNode root) {
        if ( root == null ) return 0;

        // traverse through left subtree
        // traverse through right subtree

        // go through the max of the two
        int leftLength = maxDepth(root.left);
        int rightLength = maxDepth(root.right);

        return Math.max(leftLength, rightLength) + 1;
    }
}
