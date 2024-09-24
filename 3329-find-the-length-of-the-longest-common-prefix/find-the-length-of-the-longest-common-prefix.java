class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefix = new HashSet<>();
        int result = 0;
        
        for (int num : arr1) {
            while (num > 0) {
                prefix.add(num);
                num = num / 10;
            }
        }
        
        for (int num : arr2) {
            int currentLen = String.valueOf(num).length();
            while (num > 0 && currentLen > result) {
                if (prefix.contains(num)) {
                    result = currentLen;
                }
                num = num / 10;
                currentLen -= 1;
            }
        }
        
        return result;
    }
}