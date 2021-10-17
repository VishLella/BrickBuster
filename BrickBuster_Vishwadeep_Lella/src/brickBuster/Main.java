package brickBuster;

import java.awt.Color;  
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel{

	private JFrame frame;
	private Wall wall = new Wall();
	private Deflector deflector = new Deflector((int)(Math.random()*400)+50, 610);  //spawn deflector in random area
	private Ball ball;
	BrickManager[] bMs;
	private Brick[] bricks;
	
	public Main(){

		setBackground(Color.WHITE);
		frame = new JFrame();
		frame.setTitle("Brick Buster");
		frame.setSize(540, 700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().add(this);
		frame.setVisible(true);

		
		
		frame.addKeyListener(deflector);
		frame.addMouseListener(deflector);
		frame.addMouseMotionListener(deflector);

		ball = new Ball((int)(Math.random()*450)+80, 450, 2, 1, Color.blue);
		
		int numOfColumns = 10;					
		int brickHeight = 20;
		int brickWidth = (wall.getXRight()-wall.getXLeft())/numOfColumns;
		int[] numOfBricks = new int[]{20, 10, 18, 5, 15, 20, 12, 6, 21, 18, 13, 7}; //can make random
		bMs = new BrickManager[numOfColumns];
		for(int i=0; i<numOfColumns; i++){   //implements bricks

			bMs[i] = new BrickManager(wall.getXLeft()+i*brickWidth, wall.getYTop(), brickWidth, brickHeight, numOfBricks[i]);


		}
		

		javax.swing.Timer t = new javax.swing.Timer(5, new ActionListener() 
		{   
			public void actionPerformed(ActionEvent e) 
			{
				frame.repaint(); 
			}

		}); 
		t.start();

	}

	public void paintComponent(Graphics g){



		Graphics2D g2 = (Graphics2D) g;

		super.paintComponent(g2);

		wall.paintComponent(g2); //paint wall
		deflector.paintComponent(g2);//paint deflector

		
		
		int numOfColumns = 10;  
		for(int i=0; i<numOfColumns; i++){

			bMs[i].checkCollision(ball);  //removes bricks if ball hit them

		}		
		
		ball.setWall(wall);
		ball.setDeflector(deflector);
		ball.move();
		ball.paintComponent(g2);
		

		for(int i=0; i<bMs.length; i++) bMs[i].paintComponent(g2); //draws bricks
	}

	public static void main(String[] args) {

		new Main();

	}

}
