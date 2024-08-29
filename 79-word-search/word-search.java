class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        int [][] visit=new int [m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    visit[i][j]=1;
                    if(word.length()==1){
                        return true;
                    }
                    if(solve(1,board,visit,word,i,j)==true){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean solve(int index,char[][] board,int [][] visit, String word,int row,int col){
        if(index==word.length()){
            return true;
        }
        int [] rowMatrix={-1,0,1,0};
        int [] colMatrix={0,1,0,-1};

        for(int i=0;i<4;i++){
            int nrow=row+rowMatrix[i];
            int ncol=col+colMatrix[i];

            if(nrow>=0 && nrow<board.length && ncol>=0 && ncol<board[0].length && visit[nrow][ncol]==0 && board[nrow][ncol]==word.charAt(index)){
                visit[nrow][ncol]=1;
                if(solve(index+1,board,visit,word,nrow,ncol)==true){
                    return true;
                }
                visit[nrow][ncol]=0;
            }
            
        }
        visit[row][col]=0;
        return false;
    }
}