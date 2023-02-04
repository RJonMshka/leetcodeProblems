// LC 235 - Lowest Common Ancestor for Binary Search Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode currentNode = root;

        while(currentNode != null) {
            System.out.println(currentNode.val);
            if(p.val < currentNode.val && q.val < currentNode.val) {
                // check the left subtree
                currentNode = currentNode.left;
            } else if(p.val > currentNode.val && q.val > currentNode.val) {
                // check the right subtree
                currentNode = currentNode.right;
            } else {
                return currentNode;
            }
        }

        return currentNode;
    }
}