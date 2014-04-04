// Implementing the Decorator Pattern to allow for the decoration of emergencies to require multiple
// types of responders
public class FireDec extends Emergency{
	Emergency em;
	
	public FireDec(){
		
	}
	
	// Sets another one of the emergency types to true in this case Fire
	public void setFireType(Emergency em){
		this.em = em;
		em.setFireType(true);
	}
}