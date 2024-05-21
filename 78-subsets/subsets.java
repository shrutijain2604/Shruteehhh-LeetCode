import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        backTrack(nums, 0, new ArrayList<>(), output);
        return output;
    }

    private void backTrack(int[] nums, int start, List<Integer> path, List<List<Integer>> output){
        output.add(new ArrayList<>(path));
        for(int i =start;i<nums.length;i++){
            path.add(nums[i]);
            backTrack(nums, i+1,path,output);
            path.remove(path.size()-1);
        }
    }
}