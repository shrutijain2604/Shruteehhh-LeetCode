class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        Stack<Integer> ts = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                st.push(s.charAt(i));
                ts.push(i);
            }
            else if(s.charAt(i) == ')'){
                if(!st.isEmpty() && st.peek() == '('){
                    st.pop();
                    ts.pop();
                }
                else{
                    st.push(')');
                    ts.push(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder(s);
        while(!ts.isEmpty()){
            int ind = ts.pop();
            sb.deleteCharAt(ind);
        }
        return sb.toString();
    }
}