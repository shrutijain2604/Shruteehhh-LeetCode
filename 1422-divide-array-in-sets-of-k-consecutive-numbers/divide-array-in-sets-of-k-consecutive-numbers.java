class Solution {
    public boolean isPossibleDivide(int[] arr, int k) {
        int n = arr.length;
        if(n % k !=0){
            return false;
        }
        
        Arrays.sort(arr);
        
        ArrayList<Integer> a = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0;i<n; i++){
            a.add(arr[i]);
            hm.put(arr[i], hm.getOrDefault(arr[i],0)+1);
        }

        while(a.size()!=0){
            if(a.size()<k){
                return false;
            }

            int y = Integer.valueOf(a.get(0));
            for(int i=1; i<=k ;i++){
                if(hm.containsKey(y)){
                    hm.put(y,hm.get(y)-1);
                    if(hm.get(y)==0)
                    hm.remove(y);

                    int x = a.indexOf(y);
                    a.remove(x);
                }else{
                    return false;
                }
                y++;
            }
        }
        return true;
    }
}