
public class Location {
	//This class represents the position (x, y) of a pixel


		private int x, y;

		//constructor, innitializes the location object with the specified coordinates
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}

	


		//Returns the x coordinate of this Location
		public int xCoord () {
			return this.x;
		}

		//Returns the y coordinate of this Location
		public int yCoord () {
			return this.y;
		}

		
		//Compares current Location with p
		public int compareTo (Location p) {
			int result = 0;
			
		    if (x == p.xCoord() && y == p.yCoord())
		    	result= 0;
			else if ((x == p.xCoord() && y > p.yCoord())  || x > p.xCoord())
				result = 1;
			else if ((x == p.xCoord() && y < p.yCoord())  || x < p.xCoord())
				result = -1;
		
			return result;
		}
	}

