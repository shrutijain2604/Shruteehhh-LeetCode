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
    private int moves =0;

    private int dfs(TreeNode node){
        if(node==null) return 0;
        
        int extraLeft = dfs(node.left);
        int extraRight = dfs(node.right);
        moves += Math.abs(extraLeft) + Math.abs(extraRight);

        return node.val+ extraLeft + extraRight-1;
    }
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
}