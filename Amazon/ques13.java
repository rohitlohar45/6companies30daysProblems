import java.util.*;

public class ques13{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] grid = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j] = scn.nextInt();
            }
        }
        Solution s = new Solution();
        int res = s.orangesRotting(grid);
    
        System.out.println(res);
    }
    
}

class Solution {
    public void timeStamp(int [][]grid, int r, int c, int mins){
         if(grid[r][c] == 1){
                grid[r][c] = mins;
                rotting(grid, r, c, mins);
            }
            if(grid[r][c] != 1 && mins < grid[r][c] ){
                grid[r][c] = mins;
                rotting(grid, r, c, mins);
            }
    }
    public void rotting(int[][] grid, int r, int c, int m){
        int numRow = grid.length;
        int numCol = grid[0].length;
        int mins = m+1;
        if(r < 0 || c < 0 || r >= numRow || c >= numCol || grid[r][c] == 0 ){
            return;
        }
        if(r-1 >= 0 && grid[r-1][c] != 0 && grid[r-1][c] != 2 ){
            timeStamp(grid, r-1, c, mins);
        }
        if(r+1 < numRow && grid[r+1][c] != 0 && grid[r+1][c] != 2 ){
            timeStamp(grid, r+1, c, mins);
        }
        if(c-1 >= 0 && grid[r][c-1] != 0 && grid[r][c-1] != 2){
            timeStamp(grid, r, c-1, mins);
        }
        if(c+1 < numCol && grid[r][c+1] != 0 && grid[r][c+1] != 2){
            timeStamp(grid, r, c+1, mins);
        }
    }
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return -1;
        }
        int numRow = grid.length;
        int numCol = grid[0].length;
        int maxMin = 2;
        for(int i = 0; i < numRow; i++){
            for(int j = 0; j < numCol; j++){
                if(grid[i][j] == 2) rotting(grid, i, j, maxMin);
            }
        }
        for(int i = 0; i < numRow; i++){
            for(int j = 0; j < numCol; j++){
                if(grid[i][j] == 1){
                    return -1;
                }else{
                    maxMin = Math.max(maxMin, grid[i][j]);
                }
            }
        }
        return maxMin-2;
    }
}