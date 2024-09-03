class Solution {
    public int getLucky(String s, int k) {
        int num = 0;
        for (char ch : s.toCharArray()) {
            int val = ch - 'a' + 1;
            int sum = 0;
            while (val != 0) {
                sum += val % 10;
                val /= 10;
            }
            num += sum;
        }
        int ans = num;
        for (int i = 0; i < k - 1; i++) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            ans = sum;
            num = sum;
        }

        return ans;
    }
}