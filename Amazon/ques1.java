import java.util.*;

public class ques1{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        Solution s = new Solution();
        int profit = s.maxProfit(arr,k);
        System.out.println(profit);

    }
}

class Solution{
    public int maxProfit(int[]arr, int k){

        int[][] dp = new int[k+1][arr.length];

        for(int i=1;i<=k;i++){
            int max = Integer.MIN_VALUE;
            for(int day=1;day<arr.length;day++){
                if(dp[i-1][day-1]-arr[day-1]>max){
                    max = dp[i-1][day-1]-arr[day-1];
                }
                if(max+arr[day]>dp[i][day-1]){
                    dp[i][day]= max + arr[day];
                }else{
                    dp[i][day] = dp[i][day-1];
                }
            }
        }

        return dp[k][arr.length-1];
    }
}




