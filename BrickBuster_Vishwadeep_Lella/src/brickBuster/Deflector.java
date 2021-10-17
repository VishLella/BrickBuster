package brickBuster;

import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Deflector implements KeyListener, MouseListener, MouseMotionListener {

	private int x, y; // left top
	private int width = 100;
	private int height = 15;
	private Color color = Color.black;
	private Wall wall;
	

	public Deflector(int _x, int _y){
		x = _x;
		y = _y;
		wall = new Wall();
	}

		

	public int getX(){ return x; }
	public int getY(){ return y; }
	public int getWidth(){ return width; }
	public int getHeight(){ return height; }



	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.fillRect(x, y, width, height); 
	}


	public void keyTyped(KeyEvent e) {
		//System.out.println("keyTyped");
	}


	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		if(keyCode==KeyEvent.VK_LEFT){ //if left key is pressed, move left
			x = x-10;
		}
		else if(keyCode==KeyEvent.VK_RIGHT){ //if right key is pressed, move right
			x = x+10;
		}
		
	
		if(x<wall.getXLeft()){	// makes sure to keep deflecter in bounds
			x = wall.getXLeft();
		}
		else if(x>wall.getXRight()-width){
			x = wall.getXRight()-width;
		}
		
	}


	
	public void keyReleased(KeyEvent e) {
		//System.out.println("keyReleased");
	}


	
	public void mouseDragged(MouseEvent e) {
		int mouseX = e.getX();
		x = mouseX - width/2;
		
		if(x<wall.getXLeft()){		// makes sure to keep deflector in bounds
			x = wall.getXLeft();
		}
		else if(x>wall.getXRight()-width){
			x = wall.getXRight()-width;
		}
	}
	
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}


	
	public void mousePressed(MouseEvent e) {
		int mouseX = e.getX();
		x = mouseX - width/2;
		
		if(x<wall.getXLeft()){	// makes sure to keep deflector in bounds
			x = wall.getXLeft();
		}
		else if(x>wall.getXRight()-width){
			x = wall.getXRight()-width;
		}
	}

	
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}


}

