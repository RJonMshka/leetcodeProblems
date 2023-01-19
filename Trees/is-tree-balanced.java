// Leetcode 110: Balanced Binary Tree

public class LC110 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Tuple {
        int heightLeft;
        int heightRight;

        boolean balanced;

        public Tuple(int heightLeft, int heightRight, boolean balanced) {
            this.heightLeft = heightLeft;
            this.heightRight = heightRight;
            this.balanced = balanced;
        }
    }

    private Tuple isNodeBalanced(TreeNode node) {
        if(node == null) {
            return new Tuple(0, 0, true);
        }

        Tuple leftNodeBalance = isNodeBalanced(node.left);
        Tuple rightNodeBalance = isNodeBalanced(node.right);

        int leftHeight = 1 + Math.max(leftNodeBalance.heightLeft, leftNodeBalance.heightRight);
        int rightHeight = 1 + Math.max(rightNodeBalance.heightLeft, rightNodeBalance.heightRight);

        return new Tuple(leftHeight, rightHeight, (Math.abs(leftHeight - rightHeight) <= 1 && leftNodeBalance.balanced && rightNodeBalance.balanced))
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        return isNodeBalanced(root).balanced;
    }
}
