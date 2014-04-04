// Implementing the Decorator Pattern to allow for the decoration of emergencies to require multiple
// types of responders
public class PoliceDec extends Emergency{
	Emergency em;
	
	public PoliceDec(){
		
	}
	
	// Sets another one of the emergency types to true in this case Police
	public void setPoliceType(Emergency em){
		this.em = em;
		em.setPoliceType(true);
	}
}