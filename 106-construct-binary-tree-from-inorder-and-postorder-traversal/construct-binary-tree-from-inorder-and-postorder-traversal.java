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

    private Map<Integer, Integer> valueIndexMapping = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valueIndexMapping.put(inorder[i], i);
        }
        return build(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int root, int start, int end) {
        if (start > end)
            return null;
        TreeNode rootNode = new TreeNode(postorder[root]);
        int rootIndexInorder = valueIndexMapping.get(postorder[root]);
        rootNode.left = build(inorder, postorder, root - (end - rootIndexInorder + 1), start, rootIndexInorder - 1);
        rootNode.right = build(inorder, postorder, root - 1, rootIndexInorder + 1, end);
        return rootNode;
    }
}