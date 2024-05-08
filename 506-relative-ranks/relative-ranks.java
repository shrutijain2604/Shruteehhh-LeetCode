class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] answer = new String[n];
        
        // Create a map to store original indices
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(score[i], i);
        }
        
        // Sort the score array in descending order
        Arrays.sort(score);
        for (int i = n - 1; i >= 0; i--) {
            int originalIndex = indexMap.get(score[i]);
            if (i == n - 1) {
                answer[originalIndex] = "Gold Medal";
            } else if (i == n - 2) {
                answer[originalIndex] = "Silver Medal";
            } else if (i == n - 3) {
                answer[originalIndex] = "Bronze Medal";
            } else {
                answer[originalIndex] = String.valueOf(n - i);
            }
        }
        
        return answer;
    }
}