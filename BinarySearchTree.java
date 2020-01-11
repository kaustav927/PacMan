public class BinarySearchTree {
	private BinaryNode root;
	
	
	//constructor
	public BinarySearchTree() {
		root = new BinaryNode();
	}
	
	
		//helper method that returns a node object given the node and key;
	    private BinaryNode findNode(BinaryNode r, Location key){
	        if(r.isLeaf()){
	            return r;
	        }
	        
	        
	        int tempLocation = r.getData().getLocation().compareTo(key);
	            if(tempLocation == 0){
	                return r;
	            }
	            else if(tempLocation == 1){
	                return findNode(r.getLeft(), key);
	            }
	                
	            else{
	                return findNode(r.getRight(), key);
	            }
	                
	    }     
	          
	        
	    
	  //Returns the Pixel storing the given key, if
		//the key is stored in the tree; returns null otherwise
		public Pixel get(BinaryNode r, Location key) {
			if (findNode(r, key) == null) {
				return null;
			} else {
				return findNode(r, key).getData();
			}
		}
		
		//throws DuplicatedKeyException: Inserts the given data in the tree if no data item with the same key is already there.
		//If a node already stores the same key, the algorithm throws a DuplicatedKeyException.
		public void put(BinaryNode r, Pixel data) throws DuplicatedKeyException {
			
			
			if (r.isLeaf() != true) {
				Location y = data.getLocation();
				Location x = r.getData().getLocation();
				
				// if both keys are the same 
				if(y.compareTo(x) == 0){
					throw (new DuplicatedKeyException("Duplicated key"));
				}
				
				
				else if(y.compareTo(x) ==-1 ){
					
					// check if the node has left child 
					if (r.getLeft() == null) {
						r.setLeft(new BinaryNode(data, null, null, r));
					} else
						put(r.getLeft(), data);
				}
					
				else{
					
					// check if the node has right child 
					if (r.getRight() == null) {
						r.setRight(new BinaryNode(data, null, null, r));
					} else
						put(r.getRight(), data);
				}
					
			}
			
			else
			{
				r.setData(data);
				r.setLeft(new BinaryNode());
				r.getLeft().setParent(r);
				r.setRight(new BinaryNode());
				r.getRight().setParent(r);
			}
		}
		
		
		

		//throws InexistentKeyException: Removes the data item with the given key, 
		//if the key is stored in the tree; throws an InexistentKeyEx- ception otherwise.
		public void remove(BinaryNode r, Location key) throws InexistentKeyException {
			
			//initializing the children and parent of the node to remove 
			BinaryNode nodeRM = findNode(r, key);
			BinaryNode rightChild=nodeRM.getRight();
			BinaryNode leftChild=nodeRM.getLeft();
			BinaryNode parent =nodeRM.getParent();
		
			
			// checks if the node to remove is in the tree or if its an empty node
			if(nodeRM == null  || nodeRM.isLeaf()){
				throw new InexistentKeyException("BinaryNode r does not exist");
			}
			
			// checks if the left child is empty
			else if((leftChild).isLeaf()) { 
				rightChild.setParent(parent);
				
				if(parent == null) 
					root = rightChild; 
				else if(parent.getLeft() == nodeRM)
					(parent).setLeft(rightChild);
				else{
					(parent).setRight(rightChild);
				}
			}
			
			// checks if the right child is empty
			else if(rightChild.isLeaf()) {
				(leftChild).setParent(parent);
				
				if(parent == null)
					root = leftChild;
				else if (parent.getLeft() == nodeRM)
					(parent).setLeft(leftChild);
				else
					(parent).setRight(leftChild);
			}
			
			
			// if the node to remove has a right child 
			else{
			
				while (rightChild.isLeaf() != true){
					rightChild= rightChild.getLeft();
				}
				rightChild = rightChild.getParent();
				Pixel pixel2 =rightChild.getData();
				nodeRM.setData(pixel2);
				if (rightChild.getParent() != nodeRM) { 
					(rightChild.getParent()).setLeft(rightChild.getRight());
					(rightChild.getRight()).setParent(rightChild.getParent());
				}else{
					nodeRM.setRight(rightChild.getRight());
					rightChild.getRight().setParent(nodeRM);
				}
			}
		}
		
	
		
		//Returns the Pixel with the smallest
		//key larger than the given one 
		//Returns null if the given key has no successor
		@SuppressWarnings("unused")
		public Pixel successor(BinaryNode r, Location key) {
			
			
			//initializing the right child and parent of the node to find successor of
			BinaryNode nodeSUC = findNode(r, key);
			BinaryNode rightChild=nodeSUC.getRight();
			BinaryNode parent =nodeSUC.getParent();
			
			
			
			// if the given root is empty
			if (nodeSUC == null){
				return null;
			}
			
			
			
			else if (nodeSUC.isLeaf() !=true  && rightChild.isLeaf() !=true ) {
				
				while (rightChild.isLeaf() != true){
					rightChild = rightChild.getLeft();
				}
				
				rightChild = rightChild.getParent();
				return rightChild.getData();
			}
			
			
			
			
			else{
				// if the root has no successor
				if(parent == null){
					return null;
				}
				
				
				while((parent != null) && (parent.getLeft() != nodeSUC)){
					nodeSUC = parent;
					parent = parent.getParent();
				}
				
				
				
				if (parent == null){
					return null;
				}
				
				
				
				else{
					return parent.getData();
				}
			}
		}
		
		
		
		
		
		//Returns the Pixel with the
		//largest key smaller than the given one
		//Returns null if the given key has no predecessor.
		@SuppressWarnings("unused")
		public Pixel predecessor(BinaryNode r, Location key) {
			
			//initializing the left child and parent of the node to find predecessor of 
			BinaryNode nodePRED = findNode(r, key);
			BinaryNode parent = nodePRED.getParent();
			BinaryNode leftChild = nodePRED.getLeft();
			
			if (nodePRED == null){
				return null;
			}
			
			
			
			if (nodePRED.isLeaf() !=true && (leftChild).isLeaf() !=true) {

				while(leftChild.isLeaf() !=true)
				{
					leftChild = leftChild.getRight();
				}
				
				leftChild = leftChild.getParent();
				return leftChild.getData();
			}
			
			else
			{
				if(nodePRED.getParent() == null){
					return null;
				}
				
				while(( parent != null) && ( parent.getRight() != nodePRED))
				{
					nodePRED =  parent;
					 parent =  parent.getParent();
				}
				
				
				if( parent == null)
				{
					return null;
				}
				
				else
				{
					return  parent.getData();
				}
			}
		}
		
		
		
		
		//Returns the Pixel with the smallest key. 
		//Throws an EmptyTreeException if the tree does not contain any data
		public Pixel smallest(BinaryNode r) throws EmptyTreeException {
			//if the root is empty
			if (r.equals(null)){
				throw new EmptyTreeException("Tree is Empty");
			}
			
			else {
					while (r.getLeft() != null){
						r = r.getLeft();
					}
			}
			return r.getData();
		}
		
		
		//Returns the Pixel with the largest key. 
		//Throws an EmptyTreeException if the tree does not contain any data
		public Pixel largest(BinaryNode r) throws EmptyTreeException {
			//if the root is empty
			if (r.equals(null)){
				throw new EmptyTreeException("Tree is Empty");
			}
			else {
				while (r.getRight() != null)
					r = r.getRight();
				
			}
			return r.getData();
		}
		
		
		// Returns the root of the binary search tree
		public BinaryNode getRoot(){
			return root;
		}


		
		
		
}
