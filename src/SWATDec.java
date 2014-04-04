// Implementing the Decorator Pattern to allow for the decoration of emergencies to require multiple
// types of responders
public class SWATDec extends EmerDec{
	Emergency em;
	
	public SWATDec(){
		
	}
	
	// Sets another one of the emergency types to true in this case SWAT
	public void setSwatType(Emergency em){
		this.em = em;
		em.setSwatType(true);
	}

}