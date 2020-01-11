
public class Pixel {
	//This class represents the data items to be stored in the binary search tree. 
	//Each data item consists of two parts: a Location and an int color


		private Location location;
		private int color;

		//A constructor which initializes the new Pixel with the
		//specified coordinates and color. Location p is the key for the Pixel.
		Pixel(Location p, int color) {
			this.location = p;
			this.color = color;
		}

		//Returns the Location of the Pixel
		public Location getLocation() {
			return this.location;
		}

		//Returns the color of the Pixel
		public int getColor () {
			return this.color;
		}
	}

