class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor==-1)
        return Integer.MAX_VALUE;

        boolean negative = dividend < 0 ^ divisor < 0;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient =0, subQuo = 0;

        while(dividend - divisor >= 0){
            for(subQuo=0; dividend - (divisor << subQuo << 1) >=0; subQuo++);
            quotient = quotient + (1 << subQuo);
            dividend = dividend - (divisor << subQuo);
        }
        return negative ? -quotient : quotient;
    }
}