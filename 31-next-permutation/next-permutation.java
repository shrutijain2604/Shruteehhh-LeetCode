class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: Find the first element from the right that is smaller than its next element
        int i = n - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }

        // Step 2: Once found, swap this element with the next greater element from the right
        if (i > 0) {
            int j = n - 1;
            while (nums[j] <= nums[i - 1]) {
                j--;
            }
            swap(nums, i - 1, j);
        }

        // Reverse the elements after the pivot to get the next permutation
        reverse(nums, i, n - 1);
    }

    // Helper function to swap two elements in an array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper function to reverse a subarray
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}