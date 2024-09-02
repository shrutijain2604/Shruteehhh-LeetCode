class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
        }

        k = (int) (k % sum);

        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            } else {
                k = k - chalk[i];
            }

        }

        return 0;

    }
}