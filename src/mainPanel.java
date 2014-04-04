import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class mainPanel extends JPanel {
	static JPanel mapPanel;
	JPanel logPanel;
	JLabel instructions;
	JButton policeDispatch;
	JButton firemanDispatch;
	JButton ambulanceDispatch;
	JButton SWATDispatch;

	static DefaultListModel emerListModel;
	DefaultListModel patrolListModel;
	JList emerList;
	JList patrolList;
	JScrollPane emerScrollableList;
	JScrollPane patrolScrollableList;

	public Image title_image = new ImageIcon(
			mainFrame.class.getResource("title.png")).getImage();
	public Image policeSymbol = new ImageIcon(
			mainFrame.class.getResource("policeBadge.png")).getImage();
	public Image firemanSymbol = new ImageIcon(
			mainFrame.class.getResource("firemanSymbol.png")).getImage();
	public Image ambulanceSymbol = new ImageIcon(
			mainFrame.class.getResource("ambulanceShield.png")).getImage();
	int mouseX;
	int mouseY;
	public static road roads[];
	public static ArrayList<Emergency> emergencies = new ArrayList<Emergency>();
	public static ArrayList<Responder> patrollers = new ArrayList<Responder>();
	public static ArrayList<Emergency> emergenciesBeingRespondedTo = new ArrayList<Emergency>();
	
	public mainPanel() {
		setLayout(null);
		setBounds(0, 0, mainFrame.WIDTH, mainFrame.HEIGHT);
		setBackground(new Color(140, 140, 140));
		render.render(this);
		instructions = new JLabel(
				"<html><font color='purple'>Dispatch the appropriate "
						+ "units to respond to <br>emergencies or patrol by default. Patrolling <br>units "
						+ "will automatically respond to <br>emergencies.</font></html>");
		instructions.setFont(new Font("Arial", Font.PLAIN, 11));
		instructions.setSize(220, 67);
		instructions.setLocation(24, 145);
		add(instructions);

		policeSymbol = policeSymbol.getScaledInstance(
				policeSymbol.getWidth(null) / 3,
				policeSymbol.getHeight(null) / 3, Image.SCALE_FAST);
		policeDispatch = new JButton("Dispatch Police");
		policeDispatch.setIcon(new ImageIcon(policeSymbol));
		policeDispatch.setSize(220, 50);
		policeDispatch.setLocation(20, 220);
		policeDispatch.setFocusable(false);
		policeDispatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Responder x = PoliceDepartment.getInstance()
							.dispatchPoliceResponder();
					patrollers.add(x);
					patrolListModel.addElement("<HTML>Officer " + x.name);
				} catch (Exception e1) {

				}
			}
		});
		add(policeDispatch);

		firemanSymbol = firemanSymbol.getScaledInstance(
				firemanSymbol.getWidth(null) / 3,
				firemanSymbol.getHeight(null) / 3, Image.SCALE_FAST);
		firemanDispatch = new JButton("Dispatch Fireman");
		firemanDispatch.setIcon(new ImageIcon(firemanSymbol));
		firemanDispatch.setSize(220, 50);
		firemanDispatch.setLocation(20, 280);
		firemanDispatch.setFocusable(false);
		firemanDispatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Responder x = FireDepartment.getInstance()
							.dispatchFireResponder();
					patrollers.add(x);
					patrolListModel.addElement("<HTML>Fire Chief " + x.name);
				} catch (Exception e1) {

				}
			}
		});
		add(firemanDispatch);

		ambulanceSymbol = ambulanceSymbol.getScaledInstance(
				ambulanceSymbol.getWidth(null) / 3,
				ambulanceSymbol.getHeight(null) / 3, Image.SCALE_FAST);
		ambulanceDispatch = new JButton("Dispatch Ambulance");
		ambulanceDispatch.setIcon(new ImageIcon(ambulanceSymbol));
		ambulanceDispatch.setSize(220, 50);
		ambulanceDispatch.setLocation(20, 340);
		ambulanceDispatch.setFocusable(false);
		ambulanceDispatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Responder x = AmbulanceDepartment.getInstance()
							.dispatchAmbulanceResponder();
					patrollers.add(x);
					patrolListModel.addElement("<HTML>Paramedic " + x.name);
				} catch (Exception e1) {

				}
			}
		});
		add(ambulanceDispatch);

		// SWATSymbol = SWATSymbol.getScaledInstance(SWATSymbol.getWidth(null)
		// /3, SWATSymbol.getHeight(null) /3, Image.SCALE_FAST);
		SWATDispatch = new JButton("Dispatch SWAT");
		// SWATDispatch.setIcon();
		SWATDispatch.setSize(220, 50);
		SWATDispatch.setLocation(20, 400);
		SWATDispatch.setFocusable(false);
		SWATDispatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		add(SWATDispatch);

		roads = road.generateRoads();
		mapPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				road.drawRoads(roads, g2d);
				Emergency.drawEmergencies(emergencies, g2d);
				Emergency.drawEmergencies(emergenciesBeingRespondedTo, g2d);
				/*for (int i = 0; i < patrollers.size(); i++) {	
					if(patrollers.get(i).emergency != null){
						Emergency.drawEmergency(patrollers.get(i).emergency, g2d);
					}
				}*/
				PoliceDepartment.getInstance().drawDepartment(g2d);
				AmbulanceDepartment.getInstance().drawDepartment(g2d);
				FireDepartment.getInstance().drawDepartment(g2d);
				drawPatrols(g2d);
				if (mouseX > 0 && mouseX <= mapPanel.getWidth()) {
					g2d.setColor(Color.RED);
					g2d.setFont(new Font("Helvetica", Font.BOLD, 14));
					g2d.drawString(road.getRoads(roads, mouseX, mouseY), 20,
							mapPanel.getHeight() - 20);
				} else {
					g2d.drawString("", mouseX, mouseY + 20);
				}
			}

		};
		mapPanel.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				mouseX = 0;
				mouseY = 0;
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				mouseX = 0;
				mouseY = 0;
			}
		});
		mapPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

			}

			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		mapPanel.setBackground(new Color(239, 236, 229));
		mapPanel.setLayout(null);
		render.render(mapPanel);
		mapPanel.setFocusable(true);
		mapPanel.setVisible(true);
		mapPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		add(mapPanel);

		emerListModel = new DefaultListModel();
		emerList = new JList(emerListModel);
		emerScrollableList = new JScrollPane(emerList);
		emerScrollableList.setBounds(264, mainFrame.HEIGHT - 180,
				mainFrame.WIDTH - 280, 140);
		add(emerScrollableList);

		patrolListModel = new DefaultListModel();
		patrolList = new JList(patrolListModel);
		patrolList.setBackground(new Color(160, 160, 160));
		patrolScrollableList = new JScrollPane(patrolList);
		patrolScrollableList.setBounds(20, 465, 220, 248);
		patrolScrollableList.setBackground(new Color(140, 140, 140));
		TitledBorder titled = new TitledBorder("CURRENT PATROLS");
		patrolScrollableList.setBorder(titled);
		add(patrolScrollableList);

		setFocusable(true);
		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		mapPanel.setBounds(264, 10, mainFrame.WIDTH - 280,
				mainFrame.HEIGHT - 200);
		g2d.drawImage(title_image, 10, 0, null);

	}

	/*
	public static void notifyEmergencies(){
		for(int i = 0; i < patrollers.size(); i++){
			for(int j = 0; j < emergencies.size()-1; i++){
						if(patrollers.get(i).emergency == null){
		patrollers.get(i).emergency = emergencies.get(j);
		patrollers.get(i).respond(emergencies.get(j));
	}
		
				}
			}
		}
	}
	*/
	
	public void drawPatrols(Graphics2D g2d) {
		for (int i = 0; i < patrollers.size(); i++) {
			if (patrollers.get(i) instanceof PoliceResponder) {
				g2d.setColor(new Color(102, 178, 255));
				g2d.fillRect(patrollers.get(i).xLoc, patrollers.get(i).yLoc, 6,6);			
			}
			
			if (patrollers.get(i) instanceof FireResponder) {
				g2d.setColor(new Color(255,30,30));
				g2d.fillRect(patrollers.get(i).xLoc, patrollers.get(i).yLoc, 6, 6);
			}
			
			if (patrollers.get(i) instanceof AmbulanceResponder) {
				g2d.setColor(new Color(255,153,153));
				g2d.fillRect(patrollers.get(i).xLoc, patrollers.get(i).yLoc, 6, 6);
			}
			
			if (patrollers.get(i) instanceof SWATResponder) {
				g2d.setColor(Color.BLACK);
				g2d.fillRect(patrollers.get(i).xLoc, patrollers.get(i).yLoc, 6, 6);
			}
			
		
		}
	}
	
	public void drawPatrollerEmergencies(Graphics2D g2d) {
		for (int i = 0; i < patrollers.size(); i++) {	
			if(patrollers.get(i).emergency != null){
				System.out.println("inside");
				Emergency.drawEmergency(patrollers.get(i).emergency, g2d);
			}
		}
	}
	

}
