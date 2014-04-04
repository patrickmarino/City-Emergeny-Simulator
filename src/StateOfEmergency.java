//class using facade
public class StateOfEmergency extends Responder{	
	
	//button for this needs to deploy all remaining units.
	//calls this method.
	public StateOfEmergency(){
		//iterate through units in 
		deployallcops();
		deployallambulance();
		deployallswat();
		deployallfire();
	}
		
	public void deployallcops(){
			//iterate through police
		}
	public void	deployallambulance(){
			//iterate ambulance
		}
	public void	deployallswat(){
			//iterate swat
		}
	public void	deployallfire(){
			//iterate fire.
		}
}
