/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {
    /* O(n) Space complexity O(n) */
    /** Solution 1: Recursion **/
    public boolean isValidBST(TreeNode root) {
        /*

         */
        if ( root == null ) return true;
        return validate(root, null, null);
    }

    public boolean validate(TreeNode root, Integer min, Integer max) {
        if ( root == null ) return true;
        if ( ( min != null && root.left.val <= min ) || ( max != null && root.right.val >= max ) ) return false;
        return validate( root.left, min, root.val) && validate ( root.right, root.val, max );
    }

    // cannot just go to every root node and compare the left and right subtrees because that doesn't mean it is a BST
    // BST is EVERY NODE ON LEFT is LOWER THAN THE ROOT and EVERY NODE ON RIGHT is HIGHER THAN ROOT
    // Therefore, introduce a min and max variable
    // Have a min and max
    // set them both to null
    // when you go to the left node, you find that the min of that left node is null, and the max is the root node
    // when you go to the right node, you find that the min of that left node is the root node, and the max is null (because it can be anything)
    //  ddd
}
