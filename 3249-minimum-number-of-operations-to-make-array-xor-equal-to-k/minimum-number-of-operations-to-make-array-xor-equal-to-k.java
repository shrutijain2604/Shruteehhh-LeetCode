class Solution {
    public int minOperations(int[] nums, int k) {
        int finalXOR = 0;
        for(int n: nums){
            finalXOR = finalXOR ^ n;
        }

        int count=0;
        while(k>0 || finalXOR > 0){
            if((k % 2)!=(finalXOR % 2))
            count++;

        k/=2;
        finalXOR/=2;
        }
        return count;
    }
}