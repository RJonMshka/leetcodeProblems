// LC 199: binary tree right side view

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC199 {
    
      public class TreeNode {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        int levelMemberCount = 1;

        while(!q.isEmpty()) {

            int newLevelMemberCount = 0;

            result.add(q.peek().val);

            for(int i = 0; i < levelMemberCount; i++) {
                TreeNode node = q.remove();

                if(node.right != null) {
                    q.add(node.right);
                    newLevelMemberCount++;
                }
                if(node.left != null) {
                    q.add(node.left);
                    newLevelMemberCount++;
                }
            }

            levelMemberCount = newLevelMemberCount;

        }

        return result;

    }
}
