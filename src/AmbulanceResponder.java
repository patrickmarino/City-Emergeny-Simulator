// The AmbluanceRepsonder is a child of the Responder class and is the only unit able to solve Ambulance Emergencies
public class AmbulanceResponder extends Responder{
	
	// Standard Constructor the will create a random name for the unit
	public AmbulanceResponder(){
		this.name = generateName();
		this.genTargetLocation();
	}
	
	// The Respond method that will resolve an emergency of this responder's type
	public boolean respond(Emergency emergency){
		// Calculates the distance from the emergency
		//int xDiff = Math.abs(emergency.getXLoc() - this.getXLoc());
		//int yDiff = Math.abs(emergency.getYLoc() - this.getYLoc());
		
		// If the emergency is able to resolved by this unit then we check the distance
		if (emergency.getAmbulanceType()){
			// If the distance between the responder and emergency is small enough then the unit can resolve the emergency
			//if ((xDiff < 10) && (yDiff < 10)) {
			//	emergency = null;
				//System.out.println("The emergency has been resolved");
			this.targetXLoc = emergency.xLoc;
			this.targetYLoc = emergency.yLoc;
			
			return true;
			//}
			// If the emergency is too far away the responder moves to the emergency location and then will resolve
			//else
				//moveResponder(emergency);
		}
		// If the Ambulance attempts to solve an emergency that is not of it's type then it will print an error
		// That it cannot resolve this emergency
		else{
			System.out.println("EMTs cannot resolve this emergency");
		return false;
		}
	}
}