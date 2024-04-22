class Solution {
    public int romanToInt(String s) {
        int length = s.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        int number=hm.get(s.charAt(0));
        for(int i=1;i<length;i++){
            int currValue = hm.get(s.charAt(i));
            int prevValue = hm.get(s.charAt(i-1));
            if(prevValue<currValue) {
                number = (number + currValue) - 2*prevValue;
            }
            else{
                number += currValue; 
            }
        }
        return number;
    }
}