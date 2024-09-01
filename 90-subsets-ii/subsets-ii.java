

class Solution {
    public Set<List<Integer>> set;

    public void fun(int[] arr, List<List<Integer>> list, List<Integer> dummy, int i){
        if(i == arr.length){
            List<Integer> sortedDummy = new ArrayList<>(dummy);
            if(!set.contains(sortedDummy)){
                list.add(new ArrayList<>(sortedDummy));
                set.add(sortedDummy);
            }
            return;
        }
        dummy.add(arr[i]);
        fun(arr, list, dummy, i+1);
        dummy.remove(dummy.size() - 1);
        fun(arr, list, dummy, i+1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        set = new HashSet<>();
        fun(nums, list, new ArrayList<>(), 0);
  
        return list;
    }
}