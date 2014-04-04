public class Driver {
	public static void main(String []args){
		/*Emergency e1  = new AmbulanceEmergency();
		Emergency e2  = new FireEmergency();
		Emergency e3  = new PoliceEmergency();
		Emergency e4  = new SWATEmergency();
	
		// Factory Pattern and Singleton Pattern
		AmbulanceResponder ar1 = AmbulanceDepartment.getInstance().makeAmbulanceResponder();
		//add to ambulance responder array 
		//Ar.add(ar1);
		FireResponder fr1 = FireDepartment.getInstance().makeFireResponder();
		PoliceResponder pr1 = PoliceDepartment.getInstance().makePoliceResponder();
		SWATResponder sr1 = PoliceDepartment.getInstance().makeSWATResponder();
		
		//object to use state of emergency
		StateOfEmergency soe = new StateOfEmergency();
		
		
		// Place an ambulanceresponder and an ambulance emergency within resolving range and check to see if it is resolved
		ar1.setXLoc(105);
		ar1.setYLoc(105);
		e1.setXLoc(100);
		e1.setYLoc(100);
		ar1.respond(e1);
		
		System.out.println("-------------------");

		
		// Place an fireresponder and an fire emergency outside of resolving range and check to see if it will move and resolve
		fr1.setXLoc(105);
		fr1.setYLoc(105);
		e2.setXLoc(90);
		e2.setYLoc(90);
		fr1.respond(e2);
		
		System.out.println("-------------------");
		
		// Make a SWATresponder try to resolve an police emergency and have it fail
		sr1.setXLoc(100);
		sr1.setYLoc(100);
		e3.setXLoc(100);
		e3.setYLoc(100);
		sr1.respond(e3);
		
		System.out.println("-------------------");
		
		// Adapt a Swatresponder and make it resolve the police emergency
		SWATAdaptor sa1 = new SWATAdaptor(sr1, sr1.getXLoc(), sr1.getYLoc());
		sa1.respond(e3);
		
		System.out.println("-------------------");

		// Show that the emergencies can decorate to different types
		System.out.println("Ambulance Type?: " + e4.getAmbulanceType());
		System.out.println("Fire Type?: "+ e4.getFireType());
		System.out.println("Police Type?: "+ e4.getPoliceType());
		System.out.println("SWAT Type?: " + e4.getSwatType());
		
		FireDec fd = new FireDec();
		fd.setFireType(e4);
		
		System.out.println("-------------------");

		
		System.out.println("Ambulance Type?: " + e4.getAmbulanceType());
		System.out.println("Fire Type?: "+ e4.getFireType());
		System.out.println("Police Type?: "+ e4.getPoliceType());
		System.out.println("SWAT Type?: " + e4.getSwatType());
		
		System.out.println("-------------------");
		*/
		
		SimulationMonitor x = new SimulationMonitor();
		x.run();
		new mainFrame();
	}
}
