import java.util.Random;

//Patrick class decorator pattern

public class FireEmergency extends Emergency{
	// Random generator that will randomize the starting location
	Random generator = new Random();

	// Ints to hold the random starting location
	int xLoc = generator.nextInt(1000);
	int yLoc = generator.nextInt(1000);
	
	// Sets the emergency type out of the 4 possible to Fire
	public FireEmergency(){
		setFireType(true);
	}		
}