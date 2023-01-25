// LC 572: Subtree of another tree

public class LC572 {
      //Definition for a binary tree node.
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

    private boolean isSameTree(TreeNode t1, TreeNode t2){
          if(t1 == null && t2 == null) return true;

          if( (t1 == null || t2 == null || t1.val != t2.val ) return false;

          return this.isSameTree(t1.left, t2.left) && this.isSameTree(t1.right, t2.right);
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;

        if( root == null || subRoot == null) return false;
          if(!this.isSameTree(root, subRoot)) {
              return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
          } else {
              return true;
          }
        //return this.isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    
}
