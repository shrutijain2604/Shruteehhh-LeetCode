class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) 
        return Collections.emptyList();

        String[] phone = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> output = new ArrayList<>();
        getCombinations("", digits, phone, output);
        return output;
    }
    public static void getCombinations(String combination, String nextDigit, String[] phone, List<String> output){
        if(nextDigit.isEmpty())
        output.add(combination);
        else{
            String letters = phone[nextDigit.charAt(0)- '2'];
            for(char ch:letters.toCharArray()){
                getCombinations(combination+ch, nextDigit.substring(1),phone, output);
            }
        }
    }
}