class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length; 
        int k=0;

        if(n<=1){
            return n;
        }
        for(int i=1;i<n;i++){        
            if(nums[k]!=nums[i]){      
                k++;   
                nums[k] = nums[i];
            }
        }
        return k+1;
    }
}

