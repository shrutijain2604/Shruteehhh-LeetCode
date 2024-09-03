class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int m = nums.length;

        for (int i = 0; i < m; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        
        for (int i = 0; i < m; i++) {
            if (hm.get(nums[i]) == 1) {
                return nums[i];
            }
        }

        return -1; 
    }
    
}