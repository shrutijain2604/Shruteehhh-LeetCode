class Solution {
    public int findComplement(int num) {
        int arr[] = new int[35];
        int count = 0;
        while (num > 0) {
            arr[count] = num % 2;
            count++;
            num = num / 2;
        }
        int newarr[] = new int[count];
        int a = 0;
        for (int i = count - 1; i >= 0; i--) {
            newarr[a] = arr[i];
            if (newarr[a] == 1) {
                newarr[a] = 0;
            } else {
                newarr[a] = 1;
            }
            a++;
        }
        a = a - 1;
        int b = 0;
        num = 0;
        int c = 0;
        for (int i = a; i >= 0; i--) {
            num += newarr[c] * (int) Math.pow(2, i);
            c++;
        }
        return num;
    }
}