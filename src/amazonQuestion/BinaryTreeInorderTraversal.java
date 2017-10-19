package amazonQuestion;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by JiahengYu on 03/10/17.
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode temp = stack.pop();
                result.add(temp.val);
                root = temp.right;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        tranversal(root, result);
        return result;
    }

    public void tranversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        tranversal(root.left, list);
        list.add(root.val);
        tranversal(root.right, list);
    }
}
