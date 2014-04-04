import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

//The Police houses and serves as the starting location for all Police Responders and SWAT Responders
public class PoliceDepartment implements Department{
	
	// Random Generator to calculate the starting location
	Random generator = new Random();
	// The random starting location coordinates
	private int xLoc = 430; //random
	private int yLoc  = 470; //random
	
	// the unique instance of the FireDepartment for the Singleton Design pattern
	private static PoliceDepartment uniqueInstance;
	
	// Array for storing the responders of this department's type
	private ArrayList<PoliceResponder> policeResponders  = new ArrayList();
	private ArrayList<SWATResponder> swatResponders  = new ArrayList();

	// Private constructor for the Singleton Pattern
	private PoliceDepartment() {
		for(int i = 0; i < 10; i++){
			PoliceResponder pr = new PoliceResponder();
			this.policeResponders.add(pr);
		}
	}
	
	public PoliceResponder dispatchPoliceResponder(){
		PoliceResponder r = this.policeResponders.get(policeResponders.size()-1);
		r.setXLoc(xLoc-10);
		r.setYLoc(yLoc+10);
		this.policeResponders.remove(policeResponders.size()-1);
		return r;
	}
	// Method to create an responder of this department's type for the Factory Pattern
	public PoliceResponder makePoliceResponder(){
		return new PoliceResponder();
	}
	
	// Method to create an responder of this department's type for the Factory Pattern
	public SWATResponder makeSWATResponder(){
		return new SWATResponder();
	}
	
	// Singleton Pattern
	public static PoliceDepartment getInstance() {
		if(uniqueInstance == null){
			//synchronized used for threads
			synchronized (PoliceDepartment.class){
				//if there is not an instance already, create one
				if (uniqueInstance == null) {
					uniqueInstance = new PoliceDepartment();
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
	
	// Allows for the Police responders to be stored in the department's array
	public void addPoliceResponder(PoliceResponder responder){
		for(int i = 0; i < policeResponders.size(); i++){
			if(policeResponders.get(i) == null){
				policeResponders.add(i, responder);
			}		
		}
	}
	
	// Allows for the SWAT responders to be stored in the department's array
	public void addSWATResponder(SWATResponder responder){
		for(int i = 0; i < swatResponders.size(); i++){
			if(swatResponders.get(i) == null){
				swatResponders.add(i, responder);
			}		
		}
	}
	public void drawDepartment(Graphics g2d){
		Color c = g2d.getColor();
		g2d.setColor(new Color(102,178,255));
		g2d.fillRect(this.xLoc, this.yLoc, 40, 25);
		g2d.setColor(Color.BLACK);
		g2d.drawString("Police", this.xLoc, this.yLoc-2);
		g2d.drawString("*"+policeResponders.size(), this.xLoc, this.yLoc+16);
		g2d.setColor(c);
	}
}