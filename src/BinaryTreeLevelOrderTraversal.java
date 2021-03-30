import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    /** Solution 1: Use a Queue then iterate through the queue w/ for loop **/
    public List<List<Integer>> levelOrder(TreeNode root) {
        /* BST is using a Queue */
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<List<Integer>> levelOrder = new ArrayList<>();
        if ( root == null ) return levelOrder;
        queue.add(root);

        // level.add(root.val);
        // levelOrder.add(level);

        // basically, how do we know we are in a new different level?
        while ( !queue.isEmpty() ) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();

            for ( int i = 0; i < size; i++ ) {
                TreeNode current = queue.remove();
                level.add(current.val);
                if ( current.left != null ) {
                    queue.add(current.left);
                }
                if ( current.right != null ) {
                    queue.add(current.right);
                }
            }

            levelOrder.add(level);

        }

        return levelOrder;
    }
}
