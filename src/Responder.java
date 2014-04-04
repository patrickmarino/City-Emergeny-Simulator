// The responder will be stored in their respective departments. The responder's job is to patrol around the map and
// resolve the emergencies that pop up of their type
import java.util.Random;

//Using Factory Pattern
public class Responder{
	// String variable to store a responder name to be able to differentiate differentiate multiple responders
	public String name;
	
	// These two int variables are used to store the responder's x and y coordinates to allow them to 
	// move around the map
	int xLoc;
	int yLoc;
	int targetXLoc;
	int targetYLoc;
	Emergency emergency;
	
	// Array to hold the possible names of the responders
	public String names[] = {"Ramirez" , "Smith" ,"Hall" , "Johnson",
			"Jackson", "Black", "Lee", "Palmer",
			"Miller", "Wilson", "Thomas", "Harris",
			"Garcia", "Martinez", "Lewis", "Clark",
			"Allen", "Young", "King", "Wright",
			"Hill", "Scott", "Green", "Adams",
			"Baker", "Nelson", "Carter", "Mitchell",
			"Perez", "Lopez", "Parker", "Evans",
			"Edwards", "Collins", "Sanchez", "Morris",
			"Rogers", "Reed", "Cook", "Morgan",
			"Bell", "Murphy", "Bailey", "Cooper",
			"Richardson", "Cox", "Ward", "Howard",
			"Peterson", "Grey", "Watson", "Brooks",
			"Dale", "Kinsey", "Wood", "Ross",
			"Marino", "Rossi", "Lombardi", "Romano",
			"Wang", "Zhao", "Huang", "Chen",
			"Khan", "Gupta", "Singh", "Patel",
			"Gordon", "Hunt", "Williams", "Davis"
	};

	// Standard Constructor that randomly generates a name
	public Responder(){
		this.name = generateName();
	}	
	
	// Accessor for the x coordinates
	public int getXLoc(){
		return this.xLoc;
	}
	
	// Accessor for the y coordinates
	public int getYLoc(){
		return this.yLoc;
	}
	
	// Mutator for the x coordinates
	public void setXLoc(int xLoc){
		this.xLoc = xLoc;
	}
	
	// Mutator for the y coordinates
	public void setYLoc(int yLoc){
		this.yLoc = yLoc;
	}
	
	// Method to randomly generate a name for the responder
	public String generateName(){
		// Creates a random generator
		Random r = new Random();
		// Creates a custom name for the responder by taking a first initial and randomly picking a last name from the names array
		return (Character.toString((char) (r.nextInt(26) + 'a')).toUpperCase() + ". "+ names[r.nextInt(names.length)]);	
	}

	// Accessor for the responder's name
	public String getName(){
		return this.name;
	}
	
	public void genTargetLocation(){
		while(true){
			this.targetXLoc = (int) (Math.random() * mainPanel.mapPanel.getWidth());
			this.targetYLoc = (int) (Math.random() * mainPanel.mapPanel.getHeight());
			if(road.getRoads(mainPanel.roads, targetXLoc, targetYLoc) != ""){
				break;			
			}
		}
	}

	// Method to calculate the distance to an emergency and move if necessary
	public void moveResponder(Emergency emergency) {
		// Calculate the difference in both the x and y coordinates of the responder's location and the emergency's location
		int xDiff = Math.abs(emergency.getXLoc() - this.getXLoc());
		int yDiff = Math.abs(emergency.getYLoc() - this.getYLoc());
		
		// Finds out if the emergency is to the right or left of the responder's current location
		for (int i = 0; i < xDiff; i++) {
			// If the emergency is to the right of the responder then the x coordinates will increment and move to the right
			if (this.getXLoc() < emergency.getXLoc()) {
				this.setXLoc(this.getXLoc() + 1);
				System.out.println("X Location: " + this.getXLoc());
			} else {
				// If the emergency is to the left of the responder then the x coordinates will decrement and move to the left
				this.setXLoc(this.getXLoc() - 1);
				System.out.println("X Location: " + this.getXLoc());
			}
		}
		
		// Finds out if the emergency is to the above or below of the responder's current location
		for (int i = 0; i < yDiff; i++) {
			// If the emergency is above the responder's current location it will increment and move up
			if (this.getYLoc() < emergency.getYLoc()) {
				this.setYLoc(this.getYLoc() + 1);
				System.out.println("Y Location: " + this.getYLoc());
			} else {
				// If the emergency is below the responder's current location it will decrement and move down
				this.setYLoc(this.getYLoc() - 1);
				System.out.println("Y Location: " + this.getYLoc());
			}
		}
		// Once the responder has moved (if necessary) it marks the emergency for deletion and reports that it has been resolved
		emergency = null;
		System.out.println("The emergency has been resolved");
	}
	
	public boolean respond(Emergency emergency){
		this.targetXLoc = emergency.xLoc;
		this.targetYLoc = emergency.yLoc;
		return true;
	}


}
