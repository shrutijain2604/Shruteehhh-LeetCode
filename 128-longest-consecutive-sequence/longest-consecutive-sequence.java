class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if(n==0||n==1){
            return n;
        }
        
        HashSet<Integer> hm = new HashSet<>();
        int count = 1;
        int answer = 1;
        for(int i=0;i<n;i++){
            hm.add(nums[i]);
        }
        for(Integer i:hm){
            if(hm.contains(i-1)){
                continue;
            }
            int next = i+1;
            if(hm.contains(next)){
                count=1;
                while(hm.contains(next)){
                    count++;
                    next++;
                }
                answer = Math.max(answer, count);
            }
            else{
                count=1;
            }
        }
        return answer;
    }
}