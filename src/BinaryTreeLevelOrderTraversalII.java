import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if ( root == null ) return levelOrder;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while ( !queue.isEmpty() ) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            for ( int i = 0; i < size; i++ ) {
                TreeNode current = queue.remove();
                level.add(current.val);
                if ( current.left != null ) queue.add(current.left);
                if ( current.right != null ) queue.add(current.right);
            }
            levelOrder.add(0, level);
        }

        return levelOrder;
    }
}
