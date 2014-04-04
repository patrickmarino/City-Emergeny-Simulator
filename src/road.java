import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Random;


public class road {
	String name;
	int x;
	int y; 
	int width;
	int height;
	
	public road(int x, int y, int width, int height, String name){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.name = name;
	}

	public static road[] generateRoads() {
		road[] roadArray;
		ArrayList<road> roads = new ArrayList();
		for(int i = 0; (i*90 + 50) < mainFrame.WIDTH - 280; i++){
			roads.add(new road(0, (i*90 + 50), (mainFrame.WIDTH - 280), 16, genRoadName()));	
		}
		for(int i = 0; i < mainFrame.HEIGHT - 200; i++){
			roads.add(new road((i*120 + 50), 0, 16, (mainFrame.HEIGHT - 200), genRoadName()));	
		}
		roadArray = roads.toArray(new road[roads.size()]);
		return roadArray;
	}
	public static void drawRoads(road[] roads, Graphics2D g2d){
		for(int i = 0; i < roads.length; i++){
			//g2d.setColor(new Color(254,250,131)); Old Yeller
			g2d.setColor(Color.WHITE);
			g2d.fillRect(roads[i].x, roads[i].y, roads[i].width, roads[i].height);
		}
		for(int i = 0; i < roads.length; i++){
			g2d.setColor(new Color(180, 180, 180));
			g2d.setFont(new Font("Arial", Font.PLAIN, 10));
			if(roads[i].width > roads[i].height){
				 g2d.drawString(roads[i].name, roads[i].x+(i*114)+66, roads[i].y+11);
			}else{
			 AffineTransform fontAT = new AffineTransform();
			 Font theFont = g2d.getFont();
			 fontAT.rotate(90 * java.lang.Math.PI/180);
			 Font theDerivedFont = theFont.deriveFont(fontAT);
			 g2d.setFont(theDerivedFont);
			 g2d.drawString(roads[i].name, roads[i].x+4, roads[i].y+(i/300)+66);
			 g2d.setFont(theFont);
			}
			g2d.setFont(new Font("Arial", Font.PLAIN, 12));
		}
	}
	public static String getRoads(road[] roads, int x, int y){
		String roadNames = "";
		String roadNameNoNum = "";
		String streetNum = "";
		road roadX;
		road roadY;
		for(int i = 0; i < roads.length; i++){
			if(x <= 15 || y <= 15){
				
			}else if(x >= roads[i].x && x <= (roads[i].x + 15)){
				roadX = roads[i];
				if(roadNames == ""){
					streetNum = ((y+200)/20)+" ";
					roadNames = streetNum + roadX.name;
					roadNameNoNum = roadX.name;
				}else{
					roadNames = "Intersection of "+ roadX.name +" and "+ roadNameNoNum ;
				}
			}else if(y >= roads[i].y && y <= (roads[i].y + 15)){
				roadY = roads[i];
				if(roadNames == ""){
					streetNum = ((x+200)/20)+" ";
					roadNames = streetNum + roadY.name;
					roadNameNoNum = roadY.name;
				}else{
					roadNames = "Intersection of "+ roadY.name +" and "+ roadNameNoNum ;
				}
			}
		}
		return roadNames;
	}
	public static String genRoadName(){
		String roadName = "";
		String[] road = {"Main","Oak","Pine","Maple","Cedar",
						"Elm","View","Washington","Lake","Hill",
						"Woodland","Park","Market","Union","Water",
						"North","First","Central","Franklin","Broad",
						"Jefferson","Lincoln","Church","Grove","Green",
						"Madison","Ridge","Pine","Vine","River",
						"Liberty","Meadow","Delaware","Cherry","Clinton",
						"Brook","Spring","Pony","Admiral","Fair",
						"Summit","Valley","Colonial","Laurel","King"};
		
		String[] ending = {"Road","Street","Ridge","Avenue","Lane",
						"Place","Boulevard","Way","Crossing","Drive",
						"Circle"};
		
		int rnd = new Random().nextInt(road.length);
		int rnd2 = new Random().nextInt(ending.length);
		roadName = road[rnd]+" "+ending[rnd2];
		return roadName;
	}
}
