package amazonQuestion;

import java.util.Stack;

/**
 * Created by JiahengYu on 03/10/17.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        boolean smallest = false;
        int previousValue = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode temp = stack.pop();
                if (!smallest) {
                    smallest = true;
                    previousValue = temp.val;
                } else {
                    if (temp.val <= previousValue)
                        return false;
                    else
                        previousValue = temp.val;
                }
                root = temp.right;
            }
        }
        return true;
    }
}
