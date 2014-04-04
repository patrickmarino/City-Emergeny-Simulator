import java.util.Random;
import java.util.TimerTask;

public class SimulationMonitor {
	Random rand = new Random();
	public static int pingSize = 10;
	public class genEmergency extends TimerTask
	{
		public void run() {
			int temp = rand.nextInt(10);
			if (temp < 9){
				Emergency emer;
				int emerInt = rand.nextInt(8-1) + 1;
				if(emerInt==1){
					emer  = new AmbulanceEmergency();
				}else if(emerInt==2){
					emer  = new FireEmergency();
				}/*else if(emerInt==3){
					emer  = new SWATEmergency();
				}*/else{
					emer  = new PoliceEmergency();
				}
				int roadNum = new Random().nextInt(mainPanel.roads.length);
				emer.setRoad(mainPanel.roads[roadNum]);
				emer.map();	
				mainPanel.emergencies.add(emer);	
				
			}else{
				
			}
				
		}
	}
	
	TimerTask task = new genEmergency();
	
	public class ping extends TimerTask
	{
		public void run() {
			if(pingSize >= 30){
				pingSize = 10;
			}
			pingSize++;
		}
	}
	
	TimerTask task2 = new ping();
	
	public class smartMove extends TimerTask
	{
		public void run() {
	

			for(int i = 0; i < mainPanel.patrollers.size(); i++){
				
					//if target x loc is greater than current x
					if(mainPanel.patrollers.get(i).targetXLoc > mainPanel.patrollers.get(i).xLoc){	
					//and if adding to current x still keeps us in bounds
						//if(road.getRoads(mainPanel.roads, mainPanel.patrollers.get(i).xLoc-3, mainPanel.patrollers.get(i).yLoc) != ""){
							//then add one to x
							mainPanel.patrollers.get(i).xLoc+=1;
						//}

					}
					
					//if target x loc is lower than current x
					if(mainPanel.patrollers.get(i).targetXLoc < mainPanel.patrollers.get(i).xLoc){
						//and if subtracting from current x still keeps us in bounds
						//if(road.getRoads(mainPanel.roads, mainPanel.patrollers.get(i).xLoc-3, mainPanel.patrollers.get(i).yLoc) != ""){
							//then subtract one from x
							mainPanel.patrollers.get(i).xLoc-=1;
						//}
					}
					
					
					
					//if target y loc is greater than current y
					if(mainPanel.patrollers.get(i).targetYLoc > mainPanel.patrollers.get(i).yLoc){
						//and if adding to current y still keeps us in bounds
						//if(road.getRoads(mainPanel.roads, mainPanel.patrollers.get(i).xLoc, mainPanel.patrollers.get(i).yLoc+3) != ""){
						//then add one to y
						mainPanel.patrollers.get(i).yLoc+=1;
						//}
					}
					
					//if target y loc is lower than current y
					if(mainPanel.patrollers.get(i).targetYLoc < mainPanel.patrollers.get(i).yLoc){
						//and if subtracting from current y still keeps us in bounds
						//if(road.getRoads(mainPanel.roads, mainPanel.patrollers.get(i).xLoc, mainPanel.patrollers.get(i).yLoc-3) != ""){
							//then subtract one from y
						mainPanel.patrollers.get(i).yLoc-=1;
						//}
					}
					
					if(mainPanel.patrollers.get(i).targetYLoc == mainPanel.patrollers.get(i).yLoc && mainPanel.patrollers.get(i).targetXLoc == mainPanel.patrollers.get(i).xLoc){	
						//mainPanel.notifyEmergencies();
						if(mainPanel.patrollers.get(i).emergency == null){
							mainPanel.patrollers.get(i).genTargetLocation();
						}else{
							
							if((mainPanel.patrollers.get(i).xLoc == mainPanel.patrollers.get(i).emergency.xLoc) && (mainPanel.patrollers.get(i).yLoc == mainPanel.patrollers.get(i).emergency.yLoc)){
								boolean emergencyExists = false;
								for(int j = 0; j < mainPanel.emergenciesBeingRespondedTo.size(); j++){
									if(mainPanel.emergenciesBeingRespondedTo.get(j) == mainPanel.patrollers.get(i).emergency){
										mainPanel.emergenciesBeingRespondedTo.remove(j);
										emergencyExists = true;
									}
								}
								if (emergencyExists == false){
									mainPanel.emergenciesBeingRespondedTo.add(mainPanel.patrollers.get(i).emergency);
								}
							}
						}
						
						mainPanel.patrollers.get(i).emergency = null;

					}
				
			}
		}
		
	}
	
	TimerTask task3 = new smartMove();
	
	
	public class notify extends TimerTask
	{
		public void run() {
			Random rand = new Random();
			for(int i = 0; i < mainPanel.patrollers.size(); i++){
				if(mainPanel.patrollers.get(i).emergency == null){
					try{
					Emergency emer = mainPanel.emergencies.get(rand.nextInt(mainPanel.emergencies.size()));
					if(mainPanel.patrollers.get(i).respond(emer)){
						mainPanel.patrollers.get(i).emergency = (emer);
						try{
						mainPanel.emergenciesBeingRespondedTo.add(i, emer);
						}catch(Exception e34){
							
						}
						mainPanel.emergencies.remove(emer);
					}
					
					}catch(Exception e23){
					}
				}
			}
		}
	}
	
	
	
	
	
	TimerTask task4 = new notify();
	
	
	public class spawnEmer1 extends TimerTask
	{
		public void run() {
			
		}
	}
	
	TimerTask task5 = new spawnEmer1();
	
	public class moveToEmer1 extends TimerTask
	{
		public void run() {
			
		}
	}
	
	TimerTask task6 = new notify();
	
	
	public void run(){		
    	render.timer.schedule(task, 1000, 7000);
    	render.timer.schedule(task2, 1000, 50);
    	render.timer.schedule(task3, 1000, 30);
    	render.timer.schedule(task4, 2000, 2000);
	}
}
