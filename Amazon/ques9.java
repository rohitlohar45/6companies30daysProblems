import java.io.*;

class ques9{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for(int i = 0;i < 81;i++)
                mat[i/9][i%9] = Integer.parseInt(s1[i]);
            
            System.out.println(Solution.isValid(mat));
        }
    }
}
class Solution{
    static int isValid(int mat[][]){
       boolean[][] row = new boolean[mat.length+1][mat.length+1];
       boolean[][] col = new boolean[mat.length+1][mat.length+1]; 
       boolean[][] grid = new boolean[mat.length+1][mat.length+1];
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                
                int num = mat[i][j];
                if(num == 0) continue;
                int grid_idx = (i/3) * 3 + (j/3);
                
                if(row[i][num] || col[j][num] || grid[grid_idx][num])
                    return 0;
                
                row[i][num] = col[j][num] = grid[grid_idx][num] = true;
            }
        }
        return 1;
}
}
