import java.util.*;
public class ques12
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

class Solution
{
    String colName (long n){
        
        StringBuffer str = new StringBuffer();
         while(n>0){
            if(n%26==0){
                str.append('Z'); 
            }else{
                str.append((char)(64+(n%26))); 
            }
            n=(n-1)/26;
        }
        str.reverse();
        return (str.toString());
    }  
}
