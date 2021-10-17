package brickBuster;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Brick {

	private int x, y; // left, top
	private int width;
	private int height;
	private Color color;

	private boolean isBottomOne;



	public Brick(int _x, int _y, int _width, int _height, boolean _isBottomOne){
		x = _x;
		y = _y;
		width = _width;
		height = _height;
		isBottomOne = _isBottomOne;

		color = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));

	}


	public void shiftUp(){ y -= height; } //when a brick that isn't the bottom brick is hit, shift all bricks up


	public void setAsBottomBrick(){	isBottomOne = true; } //if bottom brick is hit, set that brick/break


	public boolean isHit(Ball ball){
		
		// check if it got hit on the left-hand side.
		if(ball.getX() >= x-ball.getRadius() &&
				ball.getX() < x + width/2 &&
				ball.getY() > y &&
				ball.getY() <= y + height ){
			

			ball.setX( x - ball.getRadius() );
			ball.setVX( -ball.getVX() );

			return true;
		}

		// check if it got hit on the right-hand side.
		else if(ball.getX() > x + width/2 &&
				ball.getX() <= x + width + ball.getRadius() &&
				ball.getY() > y &&
				ball.getY() <= y + height ){

			ball.setX( x + width + ball.getRadius() );
			ball.setVX( -ball.getVX() );
			return true;
		}

		// only if it is the bottom one, check if it got hit on the bottom side.
		if(isBottomOne &&
				ball.getX() >= x-ball.getRadius() &&
				ball.getX() <= x + width + ball.getRadius() &&
				ball.getY() >= y + height &&
				ball.getY() <= y + height + ball.getRadius() ){

			ball.setY( y + height + ball.getRadius() ); 
			ball.setVY( Math.abs(ball.getVY()) ); 

			return true;
		}

		return false;
	}


	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.fillRect(x, y, width, height); 
		g2.setColor(Color.black);
		g2.drawRect(x, y, width, height); 
	}
}
