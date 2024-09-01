class Solution {
    public String reverseWords(String s) {
        String[] w = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for(int i = w.length - 1; i >= 0; i--){
            sb.append(w[i]);
            if(i != 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}