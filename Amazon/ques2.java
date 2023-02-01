import java.util.Scanner;

public class ques2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i]= scn.nextInt();
        }
        
        int res = Solution.longestMountain(arr);
        System.out.println(res);
    }
}
class Solution{
    static int longestMountain(int[] arr) {
        
        int count = 0;
        int i = 0, j = 0;
        boolean upwards = false, downwards = false;
        
        while(i < arr.length - 2) {
            while(i < arr.length - 1 && arr[i] >= arr[i + 1]) {
                i++;
            }
            upwards = false; 
            downwards = false;
            
            j = i;
            while(j < arr.length - 1 && arr[j] < arr[j + 1]) {
                upwards = true;
                j++;
            }
            
            while(j < arr.length - 1 && arr[j] > arr[j + 1]) {
                downwards = true;
                j++;
            }
            
            if(upwards && downwards){
                count = Math.max(count, j - i + 1);
            }    
            i = j;
        }
        if(upwards && downwards){
            count = Math.max(count, j - i + 1);
        }
        
        return count >= 3 ? count : 0;
        
    }
}
