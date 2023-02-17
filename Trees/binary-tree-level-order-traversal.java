// LC 102. Binary Tree Level Order Traversal


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC102 {
    
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

    private void addToQueue


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> queue = new LinkedList<>();

        if(root == null) return result;

        List<Integer> subList = new ArrayList<>();

        queue.add(root);

        int newCount = 0;
        int oldCount = 1;

        while (!queue.isEmpty()) {
            TreeNode frontOfQueue = queue.remove(0);
            subList.add(frontOfQueue.val);
            if(frontOfQueue.left != null) {
                newCount += 1;
                queue.add(frontOfQueue.left);
            }

            if(frontOfQueue.right != null) {
                newCount += 1;
                queue.add(frontOfQueue.right);
            }

            oldCount--;

            if(oldCount == 0) {
                result.add(new ArrayList<>(subList));
                subList = new ArrayList<>();

                oldCount = newCount;
                newCount = 0;
            }
        }

        return result;
    }
}
