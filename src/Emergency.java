import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

// The emergency class outlines what the types of emergencies that will occur on the map
public class Emergency {

	// Two ints to store the location on the map
	int xLoc;
	int yLoc;
	road road;
	Random rand = new Random();
	
	// 	
	public void setRoad(road road){
		this.road = road;
	}
	
	// 
	public road getRoad(){
		return this.road;
	}
	
	public void map(){
		while(true){
			this.xLoc = (int) (Math.random() * mainPanel.mapPanel.getWidth());
			this.yLoc = (int) (Math.random() * mainPanel.mapPanel.getHeight());
			if(road.getRoads(mainPanel.roads, xLoc, yLoc) != ""){
				if(this.getFireType()){
					mainPanel.emerListModel.addElement("<html>A <font color = 'red'>fire</font> has been called in at <u>"+ road.getRoads(mainPanel.roads, xLoc, yLoc)+"</u>. Fire Responders are needed.");
				}
				if(this.getPoliceType()){
					mainPanel.emerListModel.addElement("<html>A <font color = #CCCC00>shooting</font> has been called in at <u>"+ road.getRoads(mainPanel.roads, xLoc, yLoc)+"</u>. Police Responders are needed.");
				}
				if(this.getAmbulanceType()){
					mainPanel.emerListModel.addElement("<html>A <font color = 'blue'>heart attack</font> has been called in at <u>"+ road.getRoads(mainPanel.roads, xLoc, yLoc)+"</u>. Ambulance Responders are needed.");
				}
				if(this.getSwatType()){
					mainPanel.emerListModel.addElement("<html>A <font color = 'gray'>bank robbery</font> has been called in at <u>"+ road.getRoads(mainPanel.roads, xLoc, yLoc)+"</u>. Swat Responders are needed.");
				}
				break;			
			}
		}
	}
	// Accessor for the X Location
	public int getXLoc(){
		return xLoc;
	}
	
	// Accessor for the Y Location
	public int getYLoc(){
		return yLoc;
	}
	
	// Mutator for the X Location
	public void setXLoc(int xLoc){
		this.xLoc = xLoc;
	}
	
	// Mutator for the X Location
	public void setYLoc(int yLoc){
		this.yLoc = yLoc;
	}
	//Responder[] responders;  2 max.
	
	// Boolean that when that type is activated will change the type of the emergency
	private boolean fireType;
	private boolean policeType;
	private boolean swatType;
	private boolean ambulanceType;
	
	// Mutators for the emergency types
	public void setFireType(boolean fireType){
		this.fireType = fireType;
	}
	public void setPoliceType(boolean policeType){
		this.policeType = policeType;
	}
	public void setSwatType(boolean swatType){
		this.swatType = swatType;
	}
	public void setAmbulanceType(boolean ambulanceType){
		this.ambulanceType = ambulanceType;
	}
	
	// Accessors for the emergency types
	public boolean getFireType(){
		return fireType;
	}
	public boolean getPoliceType(){
		return policeType;
	}
	public boolean getSwatType(){
		return swatType;
	}
	public boolean getAmbulanceType(){
		return ambulanceType;
	}
	
	
	public static void drawEmergencies(ArrayList<Emergency> emergencies, Graphics2D g2d){	
		for (int i=0; i < emergencies.size(); i++) 
		{ 
			Color c = g2d.getColor();
			if(emergencies.get(i).getPoliceType()){
				g2d.setColor(new Color(204,204,0));
			}
			if(emergencies.get(i).getFireType()){
				g2d.setColor(Color.RED);
			}
			if(emergencies.get(i).getAmbulanceType()){
				g2d.setColor(Color.BLUE);
			}
			if(emergencies.get(i).getSwatType()){
				g2d.setColor(Color.BLACK);
			}
			g2d.drawOval(emergencies.get(i).xLoc-(SimulationMonitor.pingSize/2), emergencies.get(i).yLoc-(SimulationMonitor.pingSize/2), SimulationMonitor.pingSize, SimulationMonitor.pingSize);
			g2d.setColor(c);
		}
	}
	
	public static void drawEmergency(Emergency emergency, Graphics2D g2d){	
			Color c = g2d.getColor();
			if(emergency.getPoliceType()){
				g2d.setColor(new Color(204,204,0));
			}
			if(emergency.getFireType()){
				g2d.setColor(Color.RED);
			}
			if(emergency.getAmbulanceType()){
				g2d.setColor(Color.BLUE);
			}
			if(emergency.getSwatType()){
				g2d.setColor(Color.BLACK);
			
			g2d.drawOval(emergency.xLoc-(SimulationMonitor.pingSize/2), emergency.yLoc-(SimulationMonitor.pingSize/2), SimulationMonitor.pingSize, SimulationMonitor.pingSize);
			g2d.setColor(c);
			System.out.println("inside both");
		}
	}
}
