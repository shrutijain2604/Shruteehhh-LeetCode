class Solution {
    public boolean isNumber(String s) {
        boolean digitSeen = false, eSeen = false, dotSeen = false;
        int countSign = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                digitSeen = true;
            } else if (c == '+' || c == '-') {
                if (countSign == 2) {
                    return false;
                }
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
                if (i == len - 1) {
                    return false;
                }
                countSign++;
            } else if (c == '.') {
                if (eSeen || dotSeen) {
                    return false;
                }
                if (i == len - 1 && !digitSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (c == 'e' || c == 'E') {
                if (eSeen || !digitSeen || i == len - 1) {
                    return false;
                }
                eSeen = true;
            } else {
                return false;
            }
        }
        return true;
    }
}