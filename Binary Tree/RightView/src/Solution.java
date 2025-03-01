import java.util.*;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
	}
}
public class Solution {
	public static void main(String[] args) {
        TreeNode root = new TreeNode(1);      
        /* Construct the following binary tree 
                  1 
                /   \ 
               2     3 
              /  \ 
             4    5 
            / 	/   \
           7   8	 9
           			  \
           			   10
        */
        root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.left.right.right.right = new TreeNode(10);
        root.left.left.left = new TreeNode(7); 

        List<Integer> rightViewNodes = rightView(root);
        for(Integer val : rightViewNodes) {
        	System.out.print(val + " ");
        }
	}
	
	public static List<Integer> rightView(TreeNode root) {
		if(root == null) {
			return null;
		}
		
		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while(queue.isEmpty() == false) {
			TreeNode temp = queue.poll();
			if(temp != null) {
				if(queue.peek() == null) {
					result.add(temp.data);
				}
				if(temp.left != null) {
					queue.add(temp.left);
				}
				if(temp.right != null) {
					queue.add(temp.right);
				}
			}
			else {
				if(queue.isEmpty() == false) {
					queue.add(null);
				}
			}
		}
		
		return result;
	}
}