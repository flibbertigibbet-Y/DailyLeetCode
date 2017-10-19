package amazonQuestion;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 01/10/17.
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        return rightSide(root);
    }

    public List<Integer> rightSide(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        if (root.left == null && root.right == null) {
            return result;
        } else if (root.left == null) {
            result.addAll(rightSide(root.right));
        } else if (root.right == null) {
            result.addAll(rightSide(root.left));
        } else {
            List<Integer> left = rightSideView(root.left);
            List<Integer> right = rightSideView(root.right);
            if (left.size() <= right.size())
                result.addAll(right);
            else {
                result.addAll(right);
                List<Integer> rest = left.subList(right.size(), left.size());
                result.addAll(rest);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        one.left = two;
        two.right = five;
        one.right = three;
        three.right = four;

        System.out.print(new BinaryTreeRightSideView().rightSideView(one));
    }

}
