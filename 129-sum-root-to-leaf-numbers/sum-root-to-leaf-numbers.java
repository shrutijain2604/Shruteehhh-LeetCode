/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    static int ans;

    static void helper(TreeNode root, int currSum) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            ans = ans + ((currSum * 10) + root.val);
            return;
        }
        int a = currSum * 10 + root.val;
        helper(root.left, a);
        helper(root.right, a);
    }

    public int sumNumbers(TreeNode root) {
        ans = 0;
        helper(root, 0);
        return ans;
    }
}