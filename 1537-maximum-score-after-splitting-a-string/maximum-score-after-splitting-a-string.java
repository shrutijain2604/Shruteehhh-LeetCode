class Solution {
    public int maxScore(String s) {
        int length = s.length();
        int ans = 0;

        for (int i = 0; i < length - 1; i++) {
            int curr = 0;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == '0') {
                    curr++;
                }
            }
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(j) == '1') {
                    curr++;
                }
            }
            ans = Math.max(curr, ans);
        }
        return ans;
    }
}