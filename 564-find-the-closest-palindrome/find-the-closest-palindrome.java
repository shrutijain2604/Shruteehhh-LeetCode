public final class Solution {

    public static String nearestPalindromic(String n) {
        int length = n.length();
        if (length == 1) {
            int target = n.charAt(0) - '0';
            int nearestPalindrome = target - 1;
            return Integer.toString(nearestPalindrome);
        }

        long halfPalindrome = n.charAt(0) - '0';
        long smallestNumForLength = 1;

        int halfLength = (length + 1) / 2;
        for (int index = 1; index < halfLength; index++) {
            int digit = n.charAt(index) - '0';
            halfPalindrome = halfPalindrome * 10 + digit;
            smallestNumForLength *= 10;
        }

        long target = halfPalindrome;
        for (int index = halfLength; index < length; index++) {
            int digit = n.charAt(index) - '0';
            target = target * 10 + digit;
            smallestNumForLength *= 10;
        }
        long minPalindromeForLength = smallestNumForLength + 1;
        long maxPalindromeForLength = smallestNumForLength * 10 - 1;

        boolean isOddLength = length % 2 == 1;
        long palindrome = finishPalindrome(halfPalindrome, isOddLength);

        if (target < palindrome) {
            if (palindrome == minPalindromeForLength) {
                long nearestPalindrome = palindrome - 2;
                return Long.toString(nearestPalindrome);
            }

            long prevPalindrome = finishPalindrome(halfPalindrome - 1, isOddLength);
            long nearestPalindrome = (target - prevPalindrome <= palindrome - target) ? prevPalindrome : palindrome;
            return Long.toString(nearestPalindrome);
        }

        if (target > palindrome) {
            long nextPalindrome = finishPalindrome(halfPalindrome + 1, isOddLength);
            long nearestPalindrome = (target - palindrome <= nextPalindrome - target) ? palindrome : nextPalindrome;
            return Long.toString(nearestPalindrome);
        }

        if (palindrome == minPalindromeForLength) {
            long nearestPalindrome = palindrome - 2;
            return Long.toString(nearestPalindrome);
        }

        if (palindrome == maxPalindromeForLength) {
            long nearestPalindrome = palindrome + 2;
            return Long.toString(nearestPalindrome);
        }

        long prevPalindrome = finishPalindrome(halfPalindrome - 1, isOddLength);
        long nextPalindrome = finishPalindrome(halfPalindrome + 1, isOddLength);
        long nearestPalindrome = (target - prevPalindrome <= nextPalindrome - target) ? prevPalindrome : nextPalindrome;
        return Long.toString(nearestPalindrome);
    }

    private static long finishPalindrome(long halfPalindrome, boolean isOddLength) {
        long palindrome = halfPalindrome;
        if (isOddLength) {
            halfPalindrome /= 10;
        }
        for (; halfPalindrome > 0; halfPalindrome /= 10) {
            long digit = halfPalindrome % 10;
            palindrome = palindrome * 10 + digit;
        }
        return palindrome;
    }
}