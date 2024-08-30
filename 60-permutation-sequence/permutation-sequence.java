class Solution {
    public String getPermutation(int n, int k) {
        int[] factorials = new int[n];
        factorials[0] = 1;
        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        k--;

        StringBuilder permutation = new StringBuilder();

        for (int i = n; i > 0; i--) {
            int fact = factorials[i - 1];
            int index = k / fact;
            k %= fact;
            permutation.append(numbers.get(index));
            numbers.remove(index);
        }
        return permutation.toString();
    }
}