/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        // sum of depth of left and right trees
        if(root == null) {
            return 0;
        }
        
        int leftDia = this.diameterOfBinaryTree(root.left);
        int rightDia = this.diameterOfBinaryTree(root.right);
        int rootDia = this.depth(root.left) + this.depth(root.right) + 2;
        
        return Math.max(rootDia, Math.max(leftDia, rightDia));
        
    }
    
    public int depth(TreeNode node) {
        if(node == null) {
            return -1;
        }
        
        return Math.max(this.depth(node.left), this.depth(node.right)) + 1;
    }
}