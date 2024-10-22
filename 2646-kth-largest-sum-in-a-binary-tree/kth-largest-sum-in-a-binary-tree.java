class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public void helper(TreeNode root, List<Long> num) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);

        while (!Q.isEmpty()) {
            int sz = Q.size();
            long sum = 0;

            for (int i = 0; i < sz; i++) {
                TreeNode temp = Q.poll();
                sum += temp.val;

                if (temp.left != null) {
                    Q.add(temp.left);
                }

                if (temp.right != null) {
                    Q.add(temp.right);
                }
            }
            num.add(sum);
        }
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> sum = new ArrayList<>();
        helper(root, sum);

        if (sum.size() < k) {
            return -1;
        }

        Collections.sort(sum, Collections.reverseOrder());
        return sum.get(k - 1);
    }
};