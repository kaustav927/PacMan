
public class BinaryNode {
	// This class represents the nodes of the binary search tree. Each node 
	// will store an object of the class Pixel and it will have references 
	// to its left child, its right child, and its parent


		private Pixel value;
		private BinaryNode left;
		private BinaryNode right;
		private BinaryNode parent;
		
		
		// A constructor for the class that initializes a leaf node. The data, children
		// and parent are set to null
		public BinaryNode() {
			value = null;
			left = null;
			right = null;
			parent = null;
		}
		
		//A constructor for the class. Stores the Pixel in the node and sets left child, right child, and parent to
		//the specified values
		public BinaryNode(Pixel value, BinaryNode left, BinaryNode right, BinaryNode parent) {
			this.value = value;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}



		//Returns the parent of this node
		public BinaryNode getParent() {
			return parent;
		}

		//Sets the parent of this node to the specified value
		public void setParent(BinaryNode p) {
			this.parent = p;
		}

		//Sets the left child of this node to the specified value
		public void setLeft(BinaryNode p) {
			this.left = p;
		}

		//Sets the right child of this node to the specified value
		public void setRight(BinaryNode p) {
			this.right = p;
		}
		
		//Stores the given Pixel in this node
		public void setData(Pixel value) {
			this.value = value;
		}

		//Returns true if this node is a leaf; returns false otherwise
		public boolean isLeaf() {
			return (value == null);
		}

		//Returns the Pixel object stored in this node
		public Pixel getData() {
			return value;
		}

		//Returns the left child of this node
		public BinaryNode getLeft() {
			return left;
		}

		//Returns the right child of this node
		public BinaryNode getRight() {
			return right;
		}
	}



