class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int length = nums.length;

        for (int i = 0; i < k; i++) {
            int minIndex = 0;
            for (int j = 0; j < length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            nums[minIndex] *= multiplier;
        }
        return nums;
    }
}