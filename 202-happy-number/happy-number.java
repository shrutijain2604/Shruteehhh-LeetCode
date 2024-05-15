class Solution {
    public boolean isHappy(int n) {
        // declare maximum iterations
        int iter = 10;
        // iterate in while loop until conditions met
        while(n != 0 && iter > 0) {
            // declare array list and call helper function to split number to digits
            ArrayList<Integer> l = numToDigits(n, 10);
            // drop n to zero
            n = 0;
            // iterate over array list
            for(int i = 0; i < l.size(); i++){
                // calculate sum of pow of each digit
                n += (int) Math.pow(l.get(i), 2);
            }
            // decrement iterations
            iter--;
            // check if we found happy number, if yes return true
            if(n == 1) return true;
        }
        // if no happy number found return false
        return false;
    }
    // declare helper function to split number to digits array
    public ArrayList<Integer> numToDigits(int n, int base) {
        // declare array list to hold digits
        ArrayList<Integer> d = new ArrayList<>();
        // iterate until number is split
        while(n != 0) {
            // add last digit of number into array list
            d.add(n % base);
            // calculate remainder, discarding last digit
            n = Math.floorDiv(n, base);
        }
        // return digits array list
        return d;
    } 
}