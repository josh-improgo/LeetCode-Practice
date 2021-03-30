import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {
    /** Solution 1: Recursive Solution **/
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null; // check for base case

        TreeNode right = invertTree(root.right); // invert the right tree
        TreeNode left = invertTree(root.left); // invert the left tree

        root.left = right; // set the left subtree to the right subtree
        root.right = left; // set the right subtree to the left subtree
        return root;
    }

    /** Iterative **/
    public TreeNode invertTree2(TreeNode root) {
        if ( root == null ) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // swap the children
            TreeNode current = ((LinkedList<TreeNode>) queue).pop();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if ( current.left != null ) queue.add(current.left);
            if ( current.right != null ) queue.add(current.right);
        }

        return root;
    }

}
