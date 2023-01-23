public class LC100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;

        if(p == null || q == null || p.val != q.val) return false;

        return this.isSameTree(p.left, q.left) && this.isSameTree(p.right, q.right)
    }
}
