package brickBuster;

import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Wall {
	
	//wall bounds/attributes

	private int xLeft = 20;
	private int xRight = 520;
	private int yTop = 20;
	private int yBottom = 630;
	private Color color = Color.gray;

	public Wall() { }

	public int getXLeft() {return xLeft;}
	public int getXRight() {return xRight;}
	public int getYTop() {return yTop;}
	public int getYBottom() {return yBottom;}

	
	public void paintComponent(Graphics g){	//draw wall
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(color);
		g2.drawLine(xLeft, yTop, xRight, yTop);
		g2.drawLine(xLeft, yTop, xLeft, yBottom);
		g2.drawLine(xRight, yTop, xRight, yBottom);
		

	}

}
