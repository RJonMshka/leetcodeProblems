// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

public class LC606 {
    public static void main(String[] args) {
        int[] treeInput = new int[]{1,2,3,4};
        LC606 tree = new LC606();
        TreeNode root = tree.createTree(treeInput, 0);

        System.out.println(
                tree.tree2str(root)
        );
    }

    public TreeNode createTree(int[] treeValues, int rootIndex) {
        if(rootIndex < treeValues.length) {
            TreeNode node = new TreeNode();
            node.val = treeValues[rootIndex];
            node.left = this.createTree(treeValues, 2 * rootIndex + 1);
            node.right = this.createTree(treeValues, 2 * rootIndex + 2);
            return node;
        }

        return null;
    }

    public String preorderValues(TreeNode node) {
        if (node == null) {
            return "";
        }
        String str = "";
        Boolean isNotRoot = str != "";

        str += "(";

        str += node.val;
        if(node.right != null && node.left == null) {
            str += "()";
        }
        str += preorderValues(node.left);
        str += preorderValues(node.right);

        str += ")";

        return str;
    }

    public String tree2str(TreeNode root) {
        String result = this.preorderValues(root);
        return result.substring(1, result.length() - 1);
    }

}
