class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ll=new ArrayList<>();
        rec(n,k,new ArrayList<>(),1);
        return ll;
    }
    static List<List<Integer>> ll;
    public static void rec(int n,int k,List<Integer> result,int idx){
        if(result.size()==k){
            ll.add(new ArrayList<>(result));
            return;
        }
        for(int i=idx;i<=n;i++){
            result.add(i);
            rec(n,k,result,i+1); 
            result.remove(result.size()-1);
        }
    }
}