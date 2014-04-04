// Departments will get a random starting location upon creation an will be able to move, they will house the Responders
import java.util.Random;

// Interface that defines the what the departments can do
public interface Department{
	//private static Department onlyInstance = null;

/*	public static Department getInstance(){
		if(onlyInstance == null){
			onlyInstance = new Department();
		}else{
			System.out.println("Department already exists.");
		}
		return onlyInstance;
	}
*/
	// Methods to return the coordinates of the departments location
	public int getXLoc();
	public int getYLoc();
}
