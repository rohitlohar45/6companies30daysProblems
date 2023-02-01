import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class ques14 {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		Node root = new Node(Integer.parseInt(ip[0]));

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			Node currNode = queue.peek();
			queue.remove();

            String currVal = ip[i];

			if (!currVal.equals("N")) {

				currNode.left = new Node(Integer.parseInt(currVal));
				queue.add(currNode.left);
			}

			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			if (!currVal.equals("N")) {

            currNode.right = new Node(Integer.parseInt(currVal));
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);
			System.out.println(Solution.minTime(root, target));
			t--;

		}
	}
}


class Solution
{
    
    public static boolean rootPath(Node node , int target , ArrayList<Node> path){
        
        if(node == null) return false;
        
        if(node.data == target){
            path.add(node);
            return true;
        }
        
        boolean L = rootPath(node.left , target , path);
        boolean R = rootPath(node.right , target , path);
        
        if( L|| R){
            path.add(node);
            return true;
        }
        
        return false;
    }
    static int timer;
    
    public static int minTime(Node root, int target) {
        ArrayList<Node> path = new ArrayList<>();
        
        timer = 0;
        int burntime = 0;
        rootPath(root, target , path);
        
        for(int i=0 ; i< path.size(); i++){
            
            Node node = path.get(i);
            Node block = i > 0 ? path.get(i-1):null;
            
            BurnTree(node ,block , burntime);
            
            burntime++;
        }
        
        return timer;
     
    }
    public static void BurnTree(Node node , Node block , int btime){
        
        if(node == null) return;
        
        timer= Math.max(timer , btime);
        
        if(node.left != block) BurnTree(node.left , block , btime + 1);
        if(node.right != block) BurnTree(node.right , block , btime + 1);
        
    }
}