package brickBuster;

import java.awt.Color;  
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Ball {

	private int x, y; // center
	private static int radius = 10;
	private int vx, vy;
	private Color color;
	private Wall wall = new Wall();
	private Deflector deflector;
	private BrickManager[] bMs;
	
	
	public Ball(int _x, int _y, int _vx, int _vy, Color _color){  
		x = _x;
		y = _y;
		vx = _vx;
		vy = _vy;
		color = _color;
		
	}
	
	
	public int getX(){ return x; }
	public int getY(){ return y; }
	public int getVX(){ return vx; }
	public int getVY(){ return vy; }
	public int getRadius(){ return radius; }
	
	public void setX(int _x){ x = _x; }
	public void setY(int _y){ y = _y; }
	public void setVX(int _vx){ vx = _vx; }
	public void setVY(int _vy){ vy = _vy; }
	
	
	
	public void setBrickManagers(BrickManager[] _bMs){		//methods that call a class (used in Main)
		bMs = _bMs;
	}
	
	
	public void setWall(Wall _wall){
		wall = _wall;
	}
	
	
	public void setDeflector(Deflector _deflector){
		deflector = _deflector;
	}
	
	
	public void move(){		//method for ball to move + bounce logic (uses/changes velocities of ball
		x += vx;
		y += vy;
				
		if(x<=wall.getXLeft()+radius){
			x = wall.getXLeft()+radius;
			vx = -vx;
		}
		else if(x>=wall.getXRight()-radius){
			x = wall.getXRight()-radius;
			vx = -vx;
		}
	
		
		if(y<=wall.getYTop()+radius){
			y = wall.getYTop()+radius;
			vy = -vy;
		}
		
		
		if(x>=deflector.getX()-radius &&							//when ball bounces of deflector
		   x<=deflector.getX()+deflector.getWidth()+radius &&
		   y>=deflector.getY()-radius &&
		   y<=deflector.getY()+deflector.getHeight() ){
			
			y = deflector.getY()-radius;
			vy = -vy;
		}
		
		
		
	}
	
	
	
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.fillOval(x-radius, y-radius, 2*radius, 2*radius); 
	}
	
}