import java.io.*;

class Node
{
    int data;
    Node next;
    
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

public class ques15
{
    static Node insert(Node head, int data)
    {
        Node temp = new Node(data);
        if(head == null)
        {
          head = temp;
          return head;
        }
        else{
                Node t = head;
            while(t.next != null)
            {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }
    
    static void printList(Node head)
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        
    }
   public static void main (String[] args)throws IOException {
       BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
       int t = Integer.parseInt(read.readLine());
       
       while(t-- > 0)
       {
           int listSize = Integer.parseInt(read.readLine());
           String str[] = read.readLine().trim().split(" ");
           
           int m = Integer.parseInt(str[0]);
           int n = Integer.parseInt(str[1]);
           
           Node head = null;
           str = read.readLine().trim().split(" ");
           for(int i = 0; i < listSize; i++)
           {
               head = insert(head, Integer.parseInt(str[i]));
           }
          new Solution();
        Solution.linkdelete(head, m, n); 
          printList(head); 
          System.out.println();
       }
   } 
}

class Solution
{
    static void linkdelete(Node head, int M, int N)
    {
        Node temp = head;
        int mul = 1, count =1;
        int x =N;
            
        while(temp != null && temp.next != null){
            if(count==M*mul){
                Node prev=temp;
                while(x>0&&temp.next!=null){
                    temp=temp.next;
                    x--;
                }
                prev.next=temp.next;
                mul++;
                x=N;
            }
            count++;
            temp=temp.next;
        }
    }
}



