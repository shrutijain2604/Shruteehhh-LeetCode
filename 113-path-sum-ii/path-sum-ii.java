class Solution {
    public void backtrack(TreeNode root,int target, List<List<Integer>> ans, List<Integer> list){
        if(root==null){
            return;
        }
        list.add(root.val);
        if(root.left ==null && root.right==null && root.val==target){
            ans.add(new ArrayList<>(list));
        }else{
            backtrack(root.left,target-root.val,ans,list);
            backtrack(root.right,target-root.val,ans,list);
        }
        list.remove(list.size()-1);        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(root,targetSum,ans, new ArrayList<>());
        return ans;
    }
}