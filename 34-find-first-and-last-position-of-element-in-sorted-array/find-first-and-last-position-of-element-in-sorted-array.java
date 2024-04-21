class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = {-1, -1};
        if (n == 0) {
            return ans;
        }
        int start = 0;
        int end = n - 1;
        // Binary search for the target
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans[0] = mid;
                ans[1] = mid;
                // Update the search range for finding the upper bound
                int left = mid - 1;
                while (left >= 0 && nums[left] == target) {
                    ans[0] = left;
                    left--;
                }
                int right = mid + 1;
                while (right < n && nums[right] == target) {
                    ans[1] = right;
                    right++;
                }
                return ans;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}