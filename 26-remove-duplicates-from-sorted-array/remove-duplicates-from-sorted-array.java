class Solution {
    public int removeDuplicates(int[] nums) {
        int size = nums.length; 
        int k=0;

        if(size<=1){
            return size;
        }
        for(int i=1;i<size;i++){        
            if(nums[k]!=nums[i]){      
                k++;   
                nums[k] = nums[i];
            }
        }
        return k+1;
    }
}