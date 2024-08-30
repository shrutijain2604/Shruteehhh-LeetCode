class Solution {
    Integer[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        memo=new Integer[n][n];
        return sol(triangle,0,0);
    }
    public int sol(List<List<Integer>> triangle,int r,int c){
        if(r==triangle.size()) return 0;
        if(memo[r][c]!=null) return memo[r][c];
        int ans=Math.min(sol(triangle,r+1,c),sol(triangle,r+1,c+1));
        return memo[r][c]=triangle.get(r).get(c)+ans;
    }
}