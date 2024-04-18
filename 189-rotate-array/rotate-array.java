class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; 

        if (k == 0) return; // No rotation needed

        int count = 0; // Tracks the number of elements that have been shifted
        int start = 0; // Starting index for each cycle of rotation
        
        while (count < n) {
            int current = start;
            int prev = nums[start]; // Store the value to be moved
            do {
                int next = (current + k) % n; // Calculate the next position
                int temp = nums[next]; // Store the value at the next position
                nums[next] = prev; // Move the value
                prev = temp; // Update prev to the stored value
                current = next; // Move to the next position
                count++; // Increment the count
            } while (current != start); // Stop when we return to the starting index
            start++; // Move to the next starting index for the next cycle
        }
    }
}