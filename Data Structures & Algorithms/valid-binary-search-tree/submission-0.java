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
    public boolean isValidBST(TreeNode root) {
        Integer min = Integer.MIN_VALUE;
        Integer max = Integer.MAX_VALUE;

        return checkValidBST(root, min, max);
    }

    private boolean checkValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return checkValidBST(root.left, min, root.val)
                && checkValidBST(root.right, root.val, max);
    }
}
