class Solution {
    public int maxProduct(int[] arr) {
        int pre=1,suff=1;int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(pre==0)
            pre=1;
            if(suff==0)
            suff=1;
            pre=pre*arr[i];
            suff=suff*arr[arr.length-i-1];
            max=Math.max(max,Math.max(pre,suff));
    }
    return max;
    }
}