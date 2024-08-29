class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int startIndex = -1;
        int minLength = Integer.MAX_VALUE;
        int cnt = 0;
        int hash[] = new int[256];
        for(int i=0 ; i<t.length(); i++){
            hash[t.charAt(i)] ++;
        }

        while(right < s.length()){
            if(hash[s.charAt(right)] > 0){
                cnt++; 
            }
            hash[s.charAt(right)] --;

            while(cnt == t.length()){
                if(right - left + 1 < minLength){
                    minLength = right - left + 1;
                    startIndex = left;
                }

                hash[s.charAt(left)]++;
                if(hash[s.charAt(left)] > 0){
                    cnt--;
                }
                left++;
            }
            right += 1;
        }
        return startIndex == -1 ? "" : s.substring(startIndex , startIndex + minLength);
    }
}