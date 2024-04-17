class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int column = matrix[0].length-1;

        for(int i=0;i<=row;i++){
            if(target == matrix[i][column]){
                return true;
            }
            else if(target<matrix[i][column]){
                row = i;
                break;
            }
        }

        for(int i=0;i<=column-1;i++){
            if(matrix[row][i]==target){
                return true;
            }
        }

        return false;
    }
}