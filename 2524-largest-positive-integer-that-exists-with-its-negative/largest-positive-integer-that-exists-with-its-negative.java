class Solution {
    public int findMaxK(int[] nums) {
        int result=-1;
        HashSet<Integer> ht = new HashSet<>();
        for(int i:nums){
            ht.add(i);
            int k = i*(-1);
            if(ht.contains(k))
            result = Math.max(result,Math.abs(i));
        }

        return result;
    }
}