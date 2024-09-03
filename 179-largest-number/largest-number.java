class Solution {
    public String largestNumber(int[] nums) {
        String[] numStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(numStrings, new Comparator<String>() {
            @Override
            public int compare(String n1, String n2) {
                String order1 = n1 + n2;
                String order2 = n2 + n1;
                return order2.compareTo(order1); 
            }
        });
        
        if (numStrings[0].equals("0")) {
            return "0";
        }
        StringBuilder largestNumber = new StringBuilder();
        for (String numString : numStrings) {
            largestNumber.append(numString);
        }
        
        return largestNumber.toString();
    }
}