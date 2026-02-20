class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // base case
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // if both sides returned something -> LCA
        if (left != null && right != null) {
            return root;
        }

        // otherwise return whichever is not null
        return left != null ? left : right;
    }
}