import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

// The AmbulanceDepartment houses and serves as the starting location for all Ambulance Responders
public class AmbulanceDepartment implements Department{

	// Random Generator to calculate the starting location
	Random generator = new Random();
	// The random starting location coordinates
	private int xLoc = 550; //random
	private int yLoc  = 200; //random
	// the unique instance of the AmbulanceDepartment for the Singleton Design pattern
	private static AmbulanceDepartment uniqueInstance;
	// Array for storing the responders of this department's type
	private ArrayList<AmbulanceResponder> ambulanceResponders  = new ArrayList();
	
	
	// Private constructor for the Singleton Pattern
	private AmbulanceDepartment() {
		for(int i = 0; i < 8; i++){
			AmbulanceResponder pr = new AmbulanceResponder();
			this.ambulanceResponders.add(pr);
		}
	}
	
	public AmbulanceResponder dispatchAmbulanceResponder(){
		AmbulanceResponder r = this.ambulanceResponders.get(ambulanceResponders.size()-1);
		r.setXLoc(xLoc-10);
		r.setYLoc(yLoc+10);
		this.ambulanceResponders.remove(ambulanceResponders.size()-1);
		return r;
	}
	// Method to create an responder of this department's type for the Factory Pattern
	public AmbulanceResponder makeAmbulanceResponder(){
		return new AmbulanceResponder();
	}
	
	// Singleton Pattern's get instance method that will allow us access to the AmbulanceDepartment
	public static AmbulanceDepartment getInstance() {
		if(uniqueInstance == null){
			//synchronized used for threads
			synchronized (AmbulanceDepartment.class){
				//if there is not an instance already, create one
				if (uniqueInstance == null) {
					uniqueInstance = new AmbulanceDepartment();
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
	
	// Allows for the ambulance responders to be stored in the department's array
	public void addAmbulanceResponder(AmbulanceResponder responder){
		for(int i = 0; i < ambulanceResponders.size(); i++){
			if(ambulanceResponders.get(i) == null){
				ambulanceResponders.add(i, responder);
			}		
		}
	}
	
	public void drawDepartment(Graphics g2d){
		Color c = g2d.getColor();
		g2d.setColor(new Color(255,153,153));
		g2d.fillRect(this.xLoc, this.yLoc, 40, 25);
		g2d.setColor(Color.BLACK);
		g2d.drawString("Hospital", this.xLoc, this.yLoc-2);
		g2d.drawString("*"+ambulanceResponders.size(), this.xLoc, this.yLoc+16);
		g2d.setColor(c);
	}
}