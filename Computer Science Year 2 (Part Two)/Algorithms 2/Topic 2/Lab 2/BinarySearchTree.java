import java.util.Scanner;

//Class data structure for storing binary search tree elements
class Node { 
	int data; 
	Node left;
	Node right;
	static int spacingBuffer = 0;

	//Enum for identifying node type when printing
	public enum NodeType {
		LeftNode,
		RightNode,
		RootNode
	}

	/**
	 * Constructs a new node.
	 * @param d The data value of the new node.
	 */
	Node(int d){
		data = d; 
		left=null;
		right=null;
	}
	
	//Prints spacing based on the current spacing buffer. Used to make printed nodes easier to read.
	void printSpacing(){
		for (int i = 0; i < spacingBuffer; i++) {
			System.out.print("  ");
		}
	}

	//Helper function for printing nodes in a readable format
	void PrintNodeType(NodeType ntype){
		switch(ntype){
			case LeftNode:
				System.out.print("Left:");
				break;
			case RightNode:
				System.out.print("Right:");
				break;
			case RootNode:
				System.out.print("Root:");
				break;
		}
	}
	
	/**
	 * Inserts a new node into the correct place in the node hierarchy
	 * @param newNode The node to be inserted
	 */
	public void insert(Node newNode) 
	{ 
		if(data>=newNode.data)
		{
			if(left != null){
				//If the new node should be inserted to the left and there is already a node to the left then call insert recursively on that left node
				left.insert(newNode);
			}
			else{
				//If the new node should be inserted to the left and the left is empty then insert it there
				left = newNode;
			}
		}
		else
		{
			if(right != null){
				//If the new node should be inserted to the right and there is already a node to the left then call insert recursively on that right node
				right.insert(newNode);
			}
			else{
				//If the new node should be inserted to the right and the right is empty then insert it there
				right = newNode;
			}
		}
	} 
  
	//Display the content of the tree in pre-order format
	public void preOrder(NodeType ntype) 
	{
		PrintNodeType(ntype);
		//Print data before children
		System.out.println(data);
		//Increment spacing buffer for nicer printing when printSpacing is called
		spacingBuffer++;
		//If there is a node to the left then print its contents
		if(left!=null)
		{
			printSpacing();
			left.preOrder(NodeType.LeftNode);
		}
		//If there is a node to the right then print its contents
		if(right != null)
		{
			printSpacing();
			right.preOrder(NodeType.RightNode);
		}
		spacingBuffer--;
	} 
	
	//Display the content of the tree in post-order format
	public void postOrder(NodeType ntype) 
	{
          //WRITE YOUR CODE HERE
		//If there is a node to the left then print its contents
		if(left!=null)
		{
			left.postOrder(NodeType.LeftNode);
		}
		//If there is a node to the right then print its contents
		if(right != null)
		{
			right.postOrder(NodeType.RightNode);
		}
		PrintNodeType(ntype);
		//Print data after children
		System.out.println(data);
		spacingBuffer++;
		spacingBuffer--;


		
	} 
	
	//Display the content of the tree in in-order format
	public void inOrder(NodeType ntype) 
	{
		//WRITE YOUR CODE HERE
		//Print data in between visiting left and right children

		if(left!=null)
		{
			left.inOrder(NodeType.LeftNode);
		}

		PrintNodeType(ntype);
		System.out.println(data);

		if(right != null)
		{
			right.inOrder(NodeType.RightNode);
		}
	}

	/**
	 * Removes a node with a specific data value from the node hierarchy.
	 * @param x	The data value of the node we want to remove.
	 * @return This node if this node should not be removed, left if this node should be removed.
	 */
	Node remove(int x){

		//WRITE YOUR CODE HERE

		return null;
	}
	
	/**
	 * Gets the leftmost child of the right node
	 * @return 	The leftmost child node.
	 * 			Will be this.right if this.right has no children to the left, or it will be null if this.right is null.
	 */
	Node getRMin()
	{
		//WRITE YOUR CODE HERE
		return null;
        }

}

//An implementation of a binary search tree data structure
class BinarySearchTree{ 

	Node root;
	
	/**
	 * Inserts a new value into the binary search tree.
	 * @param data The data value of the new node to be inserted.
	 */
	public void insert(int data){
		// We create the new node 
		Node newNode = new Node(data); 
		//if root is null then we can insert it into the root
		if(root==null)
		{
			root=newNode;
			System.out.println("adding to an empty tree");
		}
		else
		{
			//if tree is not empty then we need to navigate deeper to place it in the correct position in the tree
			root.insert(newNode);
		}
	}
	
	//Displays the content of the tree in pre-order format
	public void preOrder() { 
		System.out.println();
		if(root!=null)
		{
			root.preOrder(Node.NodeType.RootNode);
		}
		else
		{
			System.out.println("\nThe tree is empty.");	
		}  
		System.out.println();
	}
	
	//Displays the content of the tree in post-order format
	public void postOrder() {
		System.out.println();
		if(root!=null)
		{
			root.postOrder(Node.NodeType.RootNode);
		}
		else
		{
			System.out.println("\nThe tree is empty.");	
		}
		System.out.println();
	}
	
	//Displays the content of the tree in in-order format
	public void inOrder() { 
		System.out.println();
		if(root!=null)
		{
			root.inOrder(Node.NodeType.RootNode);
		}
		else
		{
			System.out.println("\nThe tree is empty.");
		}
		System.out.println();
	}
	
	/**
	 * Removes a node with a specific data value from the node hierarchy.
	 * @param x	The data value of the node we want to remove.
	 */
	public void remove(int x)
	{
		//Handle empty tree
		if(root == null){
			System.out.println("The tree is empty.");
		}
		//If tree is not empty then we can do removal via the node class
		else{
			root = root.remove(x);
		}
		System.out.println();
	}

	public boolean search(Node node, int x) {
		if (node == null) {
			return false;
		}
		if (node.data == x) {
			return true;
		}
		if (x < node.data) {
			return search(node.left, x);
		} else {
			return search(node.right, x);
		}
	}


	public int sum(Node node){

		if(node == null){

			return 0;
		}

		int sum = node.data;


		sum += sum(node.left);
		sum += sum(node.right);

		return sum;

	}

	public Node remove(Node node, int key){
		if (root == null) {
			return null;
		}
		if (key < node.data) {
			node.left = remove(node.left, key);
		} else if (key > node.data) {
			node.right = remove(node.right, key);
		} else {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			}
			Node minNode = findMin(node.right);
			node.data = minNode.data;
			node.right = remove(root.right, minNode.data);
		}
		return node;
	}

	private Node findMin(Node node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}



    public static void main(String[] args) 
    { 
        //create a new bst
        BinarySearchTree bst = new BinarySearchTree();

        //Create variable to read from keyboard
        Scanner in=new Scanner(System.in);
		int option, x;
		
		int[] testNodes = {
			5,
			2,
			4, 
			9, 
			11,
			6,
			8
		};

		for (int i = 0; i < testNodes.length; i++) {
			bst.insert(testNodes[i]);
		}

		//bst.remove(5); not implemented yet
		bst.preOrder();

        do
		{
			System.out.println("Select your option:");
			System.out.println("0: Quit the programe");
			System.out.println("1: Insert number in the bst");
			System.out.println("2: Traverse pre order");
			System.out.println("3: Traverse in order");
			System.out.println("4: Traverse post order");
			System.out.println("5: Remove a number in the bst");
			System.out.println("6: Check if number exists in tree");
			System.out.println("7: Print the sum of all values in the Binary Search Tree");
			System.out.println("8: Remove an Element from the BST");
			
			option=in.nextInt();
			switch(option){
				case 0:
					System.out.println("Good bye!");
					break;
				case 1:
					System.out.println("What number do you want to insert?");
					x=in.nextInt();
					bst.insert(x);
					break;
				case 2:
					bst.preOrder();
					break;
				case 3:
					bst.inOrder(); 
					break;
				case 4:
					bst.postOrder();
					break;
				case 5:
					System.out.println("What number do you want to remove?");
					x=in.nextInt();
					bst.remove(x);
					break;
				case 6:
					System.out.println("What number do you want to check?");
					x=in.nextInt();
					var check = bst.search(bst.root, x);
					System.out.println(check);
					break;
				case 7:
					int sum = bst.sum(bst.root);
					System.out.println("The Sum of values in the Binary Search tree: " + sum);
					break;
				case 8:

					System.out.println("What number do you want to remove?");
					x=in.nextInt();
					if(bst.search(bst.root, x)){

						var b = bst.remove(bst.root, x);
						System.out.println("The value " + x + " has been deleted");
					}
					else{

						System.out.println("The value isn't in the binary search tree");
					}

					break;
				default:
					System.out.println("That is not an option");
					break;
			}
			
       } while(option!=0);

	   in.close();
    } 
} 
