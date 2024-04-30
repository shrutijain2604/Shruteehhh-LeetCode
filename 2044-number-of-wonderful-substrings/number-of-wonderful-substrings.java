class Solution {
    public long wonderfulSubstrings(String word) {
        long result = 0;
        int[] count = new int[1024]; // 2^10 for all possible bitmasks

        count[0] = 1; // Initialize with the empty string

        int mask = 0;
        for (char c : word.toCharArray()) {
            mask ^= 1 << (c - 'a');
            result += count[mask];
            for (int i = 0; i < 10; i++) {
                result += count[mask ^ (1 << i)];
            }
            count[mask]++;
        }

        return result;
    }
}