public class GraphicalFigure implements GraphicalFigureADT {
		
		//empty bst where pixels are stored
		private BinarySearchTree bst;
		//initializing id, width, height, type and location for the constructor
		private int id, width, height;
		private String type;
		private Location pos;

		// this is the constructor which the pixels of the figure are stored in a binary search tree
		public GraphicalFigure(int id, int width, int height, String type, Location pos){
			this.bst = new BinarySearchTree();
			this.id = id;
			this.width = width;
			this.height = height;
			this.pos = pos;
			this.type = type;
			
			
		}
		
		
		public void setType(String type) {
			this.type = type;
		} 
		
		
		public int getWidth() {
			return width;
		}
		
		
		public int getHeight() {
			return height;
		}
		
		
		public String getType() {
			return type;
		}
		
		
		public int getId() {
			return id;
		}
		
		
		public Location getOffset() {
			return pos;
		}
		
		
		public void setOffset(Location value) {
			this.pos = value;
		}
		
		
		//Inserts pix into the binary search tree associated with this graphical object. 
		//Throws a DuplicatedKeyException if an error occurs when inserting the Pixel 
		//into the tree.
		public void addPixel(Pixel pix) throws DuplicatedKeyException {
			
				bst.put(bst.getRoot(), pix);
		}
		
		
		//helper method to find the bst for graphical gobj
		  private BinarySearchTree getTree() {
				return bst;
			    }

		// Returns true if this graphical object intersects the one specified in the parameter.
		// It returns false otherwise.
	    public boolean intersects(GraphicalFigure gobj) {
		
	    	    BinarySearchTree comaprisonBST = gobj.getTree();
	    		try {
	    			
	    			BinaryNode bstNode= bst.getRoot();
	    			Pixel pixel = bst.smallest(bstNode);
	    			while (pixel != null) {
	    				
	    				Location newLocation = new Location(this.getOffset().xCoord() + pixel.getLocation().xCoord() - gobj.getOffset().xCoord(), this.getOffset().yCoord() + pixel.getLocation().yCoord() - gobj.getOffset().yCoord());
	    				// if the new location results in a bst, they intersect 
	    				if (comaprisonBST.get(comaprisonBST.getRoot(), newLocation) != null) 
	    				{
	    					return true;
	    				}
	    				pixel = bst.successor(bstNode, pixel.getLocation());
	    			}
	    			
	    			//else the method returns false 
	    			return false;
	    			
	    			
	    			
	    		} 
	    		catch (EmptyTreeException e) {
	    			return false;
	    		}
	    	
		}

	    
	    
	    
		}
		
	


