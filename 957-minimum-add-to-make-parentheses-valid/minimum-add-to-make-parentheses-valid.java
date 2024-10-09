class Solution {
    public int minAddToMakeValid(String str) {
        int n = str.length();
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (s.isEmpty()) {
                s.push(ch);
                continue;
            }
            if (ch == ')' && s.peek() == '(') {
                s.pop();
            } else {
                s.push(ch);
            }
        }
        return s.size();
    }
}