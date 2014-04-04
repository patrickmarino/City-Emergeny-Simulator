// Implementing the Adaptor Design Pattern this will allow for a SWAT Unit to adapt and resolve police units
public class SWATAdaptor extends Responder{
	// SWAT Responder variable to hold the responder that will be adapted
	SWATResponder swat;
	
	// Constructor
	public SWATAdaptor(SWATResponder swat, int xLoc, int yLoc){
		this.swat = swat;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
	}
	
	// Changes the SWAT's respond method to also be able to resolve police emergencies as well as SWAT ones
	public boolean respond(Emergency emergency){
			int xDiff = Math.abs(emergency.getXLoc() - this.getXLoc());
			int yDiff = Math.abs(emergency.getYLoc() - this.getYLoc());
			if((emergency.getPoliceType()) || (emergency.getSwatType())){	
				if ((xDiff < 10) && (yDiff < 10)) {
					emergency = null;
					System.out.println("The emergency has been resolved");
				}
				else
					this.moveResponder(emergency);
				return true;
			}
			else{
				System.out.println("SWAT cannot resolve this emergency");
			return false;}
	}
}

