package amazonQuestion;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by JiahengYu on 01/10/17.
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue1 = new ArrayDeque<TreeNode>();
        Queue<TreeNode> queue2 = new ArrayDeque<TreeNode>();

        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null)
            return result;

        queue1.add(root);

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> temp = new LinkedList<Integer>();
            while (!queue1.isEmpty()) {
                TreeNode treeNode = queue1.poll();
                temp.add(treeNode.val);
                if (treeNode.left != null)
                    queue2.add(treeNode.left);
                if (treeNode.right != null)
                    queue2.add(treeNode.right);
            }
            if (!temp.isEmpty())
                result.add(temp);

            temp = new LinkedList<Integer>();
            while (!queue2.isEmpty()) {
                TreeNode treeNode = queue2.poll();
                temp.add(treeNode.val);
                if (treeNode.left != null)
                    queue1.add(treeNode.left);
                if (treeNode.right != null)
                    queue1.add(treeNode.right);
            }
            if (!temp.isEmpty())
                result.add(temp);
        }
        return result;
    }
}
