class Solution {
    public int trap(int[] height) {
        int wallBars = 0;
        for(int i = 0; i < height.length; i++) {
            wallBars += height[i];
        }

        int left = 0;
        int right = height.length-1;
        int target = 1;
        int totalArea = 0;
        while(left <= right) {
            if(height[left] < target) {left++; continue;}
            if(height[right] < target) {right--; continue;}

            totalArea += (right-left)+1;
            target++;
        }
        return totalArea - wallBars;
    }
}