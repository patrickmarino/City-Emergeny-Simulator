import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

//The FireDepartment houses and serves as the starting location for all Fire Responders
public class FireDepartment implements Department{

	// Random Generator to calculate the starting location
	Random generator = new Random();
	// The random starting location coordinates
	private int xLoc = 190; //random
	private int yLoc = 200; //random
	
	// the unique instance of the FireDepartment for the Singleton Design pattern
	private static FireDepartment uniqueInstance;
	
	// Array for storing the responders of this department's type
	private ArrayList<FireResponder> fireResponders  = new ArrayList();
	
	// Private constructor for the Singleton Pattern
	private FireDepartment() {
		for(int i = 0; i < 4; i++){
			FireResponder pr = new FireResponder();
			this.fireResponders.add(pr);
		}
	}
	
	// Method to create an responder of this department's type for the Factory Pattern
	public FireResponder makeFireResponder(){
		return new FireResponder();
	}
	
	public FireResponder dispatchFireResponder(){
		FireResponder r = this.fireResponders.get(fireResponders.size()-1);
		r.setXLoc(xLoc-10);
		r.setYLoc(yLoc+10);
		this.fireResponders.remove(fireResponders.size()-1);
		return r;
	}
	
	// Singleton Pattern
	public static FireDepartment getInstance() {
		if(uniqueInstance == null){
			//synchronized used for threads
			synchronized (FireDepartment.class){
				//if there is not an instance already, create one
				if (uniqueInstance == null) {
					uniqueInstance = new FireDepartment();
				}
			}
		}
		return uniqueInstance;
	}
	
	// Accessor's for the X Location
	public int getXLoc(){
		return xLoc;
	}
	
	// Accessor's for the Y Location
	public int getYLoc(){
		return yLoc;
	}
	
	// Allows for the fire responders to be stored in the department's array
	public void addFireResponder(FireResponder responder){
		for(int i = 0; i < fireResponders.size(); i++){
			if(fireResponders.get(i) == null){
				fireResponders.add(i, responder);
			}		
		}
	}
	
	public void drawDepartment(Graphics g2d){
		Color c = g2d.getColor();
		g2d.setColor(new Color(255,30,30));
		g2d.fillRect(this.xLoc, this.yLoc, 40, 25);
		g2d.setColor(Color.BLACK);
		g2d.drawString("Fire Station", this.xLoc, this.yLoc-2);
		g2d.drawString("*"+fireResponders.size(), this.xLoc, this.yLoc+16);
		g2d.setColor(c);
	}
}