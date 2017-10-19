package amazonQuestion;

/**
 * Created by JiahengYu on 02/10/17.
 */
public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;
        if ((p.val >= root.val && root.val >= q.val) || (p.val <= root.val && root.val <= q.val))
            return root;
        else if (p.val <= root.val && q.val <= root.val)
            return lowestCommonAncestor(root.left, p, q);
        else
            return lowestCommonAncestor(root.right, p, q);
    }

    public static void main(String args[]) {
        TreeNode one = new TreeNode(0);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);

        six.left = two;
        six.right = eight;
        eight.left = seven;
        eight.right = nine;
        two.left = one;
        two.right = four;
        four.left = three;
        four.right = five;

        System.out.print(new LowestCommonAncestorofaBinarySearchTree().lowestCommonAncestor(six,two, eight).val);
    }
}
