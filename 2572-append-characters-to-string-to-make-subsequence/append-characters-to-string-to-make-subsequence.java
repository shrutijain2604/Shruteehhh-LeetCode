class Solution {
    public int appendCharacters(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int i=0,j=0;

        while(i<n1 && j< n2){
            if(s.charAt(i)==t.charAt(j))
            j++;

            i++;
        }
        return n2-j;
    }
}