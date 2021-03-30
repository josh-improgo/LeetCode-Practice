/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/
 */
public class SameTree {

    /** Solution 1: Preorder Traversal Helper Method **/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return preOrder(p, q);
    }

    public boolean preOrder(TreeNode p, TreeNode q) {
        // pre order is the root goes first, then left, then right
        if ( p != null && q != null ) {
            if ( p.val == q.val ) {
                return preOrder(p.left, q.left) && preOrder(p.right, q.right);
            } else return false;
        } else if ( p == null && q == null ) return true;
        return false;
    }
}
