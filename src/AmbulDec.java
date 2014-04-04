// Implementing the Decorator Pattern to allow for the decoration of emergencies to require multiple
// types of responders
public class AmbulDec extends EmerDec{
	Emergency em;
	
	public AmbulDec(){
		
	}
	
	// Sets another one of the emergency types to true in this case Ambulance
	public void setAmbulanceType(Emergency em){
		this.em = em;
		em.setAmbulanceType(true);
	}
}