class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        if(s.charAt(n-1)=='(' || s.charAt(0)==')') {
            return false;
        }

        int leftMin = 0, leftMax = 0;

        for(int i =0;i< n;i++) {
            if(s.charAt(i)== '(') {
                leftMin++;
                leftMax++;
            }
            else if(s.charAt(i)==')') {
                leftMax--;
                leftMin--;
            }
            else if(s.charAt(i)=='*') {
                leftMin--;
                leftMax++;
            }

            if(leftMax<0) {
                return false;
            }

            leftMin = Math.max(0,leftMin);
        }

        if(leftMin == 0) {
            return true;
        }

        return false;
    }
}