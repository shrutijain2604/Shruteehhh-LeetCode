class Solution {
    public long wonderfulSubstrings(String word) {
        long result = 0;
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1); 

        int mask = 0;
        for (char c : word.toCharArray()) {
            mask ^= 1 << (c - 'a');
            result += count.getOrDefault(mask, 0);
            for (int i = 0; i < 10; i++) {
                result += count.getOrDefault(mask ^ (1 << i), 0);
            }
            count.put(mask, count.getOrDefault(mask, 0) + 1);
        }

        return result;
    }
}