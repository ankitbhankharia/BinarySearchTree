public class BinaryTree {

	Node root;

	public BinaryTree() {
		root = null;
	}

	public void addNode(int key, String name) {
		Node newNode = new Node(key, name);
		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (newNode.key < current.key) {
					current = current.left;
					if (current == null) {
						parent.left = newNode;
						break;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = newNode;
						break;
					}
				}
			}
		}

	}

	public Node findNode(int key) {
		Node current = root;
		while (current.key != key) {
			if (key < current.key) {
				current = current.left;
			} else {
				current = current.right;
			}

			if (current == null) {
				return null;
			}
		}
		return current;
	}
	
	public void inOrderTraversal(Node current) {
		if(current != null) {
			inOrderTraversal(current.left);
			System.out.println(current);
			inOrderTraversal(current.right);
		}
	}
	
	public void preOrderTraversal(Node current) {
		if(current != null) {
			System.out.println(current);
			inOrderTraversal(current.left);
			inOrderTraversal(current.right);
		}
	}
	
	public void postOrderTraversal(Node current) {
		if(current != null) {
			inOrderTraversal(current.left);
			inOrderTraversal(current.right);
			System.out.println(current);
		}
	}
	
	public boolean removeNode(int key) {
		
		Node current = root;
		Node parent = root;
		boolean isLeft = true;
		
		while(current.key != key) {
			parent = current;
			
			if(key < current.key) {
				isLeft = true;
				current = current.left;
			}
			else {
				isLeft = false;
				current = current.right;
			}
			
			if(current == null) {
				return false;
			}
			
		}
		
		if(current.left == null && current.right == null) {
			if(current == root) {
				root = null;
			}
			else if(isLeft) {
				parent.left = null;
			}
			else {
				parent.right = null;
			}
		}
		
		else if(current.right == null) {
			if(current == root) {
				root = current.left;
			}
			else if(isLeft) {
				parent.left = current.left;
			}
			else {
				parent.right = current.left;
			}
		}
		else if(current.left == null) {
			if(current == root) {
				root = current.right;
			}
			else if(isLeft) {
				parent.left = current.right;
			}
			else {
				parent.right = current.right;
			}
		}
		else {
			Node replacement = getReplacement(current);
			if(current == root) {
				root = replacement;
			}
			else if(isLeft) {
				parent.left = replacement;
			}
			else {
				parent.right = replacement;
			}
			
			replacement.left = current.left;
		}
		
		
		return true;
	}
	
	public Node getReplacement(Node replacedNode) {
		Node replaceParent = replacedNode;
		Node replacement = replacedNode;
		Node current = replacedNode.right;
		
		while(current != null) {
			replaceParent = replacement;
			replacement = current;
			current = current.left;
		}
		
		if(replacement != replacedNode.right) {
			replaceParent.left = replacement.right;
			replacement.right = replacedNode.right;
		}
		
		
		return replacement;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.addNode(50, "Ankit");
		bt.addNode(60, "Omey");
		bt.addNode(30, "Rahul");
		bt.addNode(40, "Uday");
		bt.addNode(70, "Rohan");
		bt.addNode(35, "Avi");
		bt.addNode(55, "Ankita");
		bt.addNode(45, "Swati");
		System.out.println("In Order traversal");
		System.out.println();
		bt.inOrderTraversal(bt.root);
		System.out.println("Pre Order traversal");
		System.out.println();
		bt.preOrderTraversal(bt.root);
		System.out.println("Post Order traversal");
		System.out.println();
		bt.postOrderTraversal(bt.root);
		bt.removeNode(35);
		System.out.println("Removed key 35");
		System.out.println();
		bt.inOrderTraversal(bt.root);
		
		
		

	}

}
