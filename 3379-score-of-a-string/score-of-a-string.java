class Solution {
    public int scoreOfString(String s) {
        int total =0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                continue;
            }
            else if(s.charAt(i) > s.charAt(i+1)){
                total += s.charAt(i) - s.charAt(i+1);
            }
            else
                total +=(s.charAt(i+1) - s.charAt(i));
        }
        return total;
    }
}


