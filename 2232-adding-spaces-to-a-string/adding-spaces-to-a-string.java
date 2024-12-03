class Solution {
    public String addSpaces(String s, int[] spaces) {
        int index = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (index < spaces.length && i == spaces[index]) {
                sb.append(" ");
                index++;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}