import java.util.Scanner;
class BinaryTree
{
	Node root ;
	BinaryTree()
	{
		root = null;
	}
	class Node
	{
		int data ;
		Node left ;
		Node right ;
		Node(int val)
		{
			data = val ;
			left = null ;
			right = null ;
			
		}	

	}
	public Node addNode(Node root ,int key)
	{
		
		if(root == null)
		{
			//Node newNode = new Node(key);
			//root = newNode ;
			root = new Node(key);
			return root ;
		}
		
		
			if(key <= root.data)
			{
				root.left = addNode(root.left , key);
			}
			else
			{
				root.right = addNode(root.right , key);
			}
			
		
		return root ;
	}
	public void insertData(int key)
	{
		root = addNode(root , key);
	}
	public Node deleteNode(Node root , int key)
	{
		if(root == null)
		{
			return root;
		}
		
		if(key < root.data)
		{
			root.left = deleteNode(root.left , key);
		}
		else if(key > root.data)
		{
			root.right = deleteNode(root.right , key);
		}
		else
		{
			if(root.left == null)
			{
				return root.right ;
			}
			else if(root.right == null)
			{
				return root.left ;
			
			}
			
			// if root has two noode we have to delete root , 
			// step - 1 : using inorder traversal
			// find successor of root then put successor in place of root
			
			root.data = minValue(root.right ); 
			// step - 2 :
			// find minimum to max 
			// call inorder method and replace with succesor node.
			// find the minimum of left of maximum right 
				
			root.right = deleteNode(root.right , root.data);
		}			
		return root ;
	}
	public int minValue(Node root )
	{
		int x = root.data ;
		while(root.left != null)
		{
			x = root.left.data ;
			root = root.right ;
		}
		return x ;
	}
	public void delete(int key)
	{
		root = deleteNode(root ,  key);
	}
	
	public void printPreOrder(Node root)
	{
		
		if(root == null)
		{
			return ;
		}
		
		System.out.print(root.data+"  ");
		printPreOrder(root.left);
		printPreOrder(root.right);
			
		
	}
	public void preOrder()
	{ 
		// it is called wrapping method  , it is done because we might face some problem
		// like exception , data collision , data loss in future 
		// we can directly called recursion method from main but due to above 
		// above reason we use wrapping technique i.e calling method which include recursion
		// printPreOrder() from another method like preOrder()	
		
		printPreOrder(root);
	}
	public void printInOrder(Node root)
	{
		
		if(root == null)
		{
			return ;
		}
		printInOrder(root.left);
		System.out.print(root.data+"  ");
		printInOrder(root.right);
	
	}
	public void inOrder()
	{	
		printInOrder(root);
	}
	
	public void printPostOrder(Node root)
	{
			
		if(root == null)
		{
			return ;
		}
		
			printPostOrder(root.left);
			printPostOrder(root.right);
			System.out.print(root.data+"  ");
		
	}
	public void postOrder()
	{
		
		printPostOrder(root);
	}
	
	public int countOfNode(Node root)
	{
		// if there is no node it return 0 
		if(root == null)
		{
			return 0 ;
		}
		
		// if there is node then traverse up to the last node then
		
		int rootLeft = countOfNode(root.left);
		int rootRight = countOfNode(root.right);
		return rootLeft + rootRight + 1 ;
	}
	public void countNode()
	{
		
		System.out.println("Number Of Node : "+ countOfNode(root) );
	}
	
	public int heightOfNOde(Node root)
	{
		// if there is no node it return 0 
		if(root == null)
		{
			return 0 ;
		}
		
		// if there is node then traverse up to the last node then
		
		int h1 = heightOfNOde(root.left);
		int h2 = heightOfNOde(root.right);
		int max = h1>h2 ? h1 : h2 ;
		return max + 1 ;
	}
	public void height()
	{
		System.out.println("Height of Tree : "+ heightOfNOde(root));
		
	}
	public int sumOfNode(Node root)
	{
		if(root == null)
		{
			return 0 ;
		}
		int leftSum = sumOfNode(root.left);
		int rightSum = sumOfNode(root.right);
		
		return leftSum + rightSum + root.data ;
	}
	public void sum()
	{
		System.out.println("Sum of node data : "+sumOfNode(root));
	}
	/*public boolean isSubtree(Node root)
	{
		
	}*/
}


class BinaryTreeOperation
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[])
	{
		BinaryTree t = new BinaryTree();
		int key = 0 ;
		int choice ;
		System.out.println(" 1) Add Node\n 2) Inorder Traversal\n 3) PreOrder Traversal");
		System.out.println(" 4) Post Order Traversal\n 5) Delete Node\n 6) Count Node present in Tree\n 7) Height Of Tree\n 8) Sum Of Data  ");
		do 
		{
			System.out.print("Enter choice : ");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1 :
						System.out.print("Enter key to insert : ");
						key = sc.nextInt();
						t.insertData(key);
						//t.addNode(t.root ,key);
					break ;
				case 2 :
						System.out.print("In Order traversal : ");
						t.inOrder();  
						System.out.println();	
					break ;
				case 3 :
						System.out.print("Pre Order traversal : ");
						t.preOrder();
						System.out.println();
					break ;
				case 4 :
						System.out.print("Post Order traversal : ");
						t.postOrder();
						System.out.println();
					break ;
				case 5 :
					
						System.out.println("Delete node :");
						System.out.println("Enter key to delete : ");
						key = sc.nextInt();
						t.delete(key);
						
					break ;
				case 6 :
						t.countNode();
						
					break ;
				case 7 :
						t.height();
						
					break ;
				case 8 :
						t.sum();
					break ;
			}
			
			
		}
		while(choice != 0);
	}

}