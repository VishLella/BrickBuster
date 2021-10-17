package brickBuster;

import java.awt.Graphics; 
import java.awt.Graphics2D;

public class BrickManager {

	private int x, y; // left, top
	private int brickWidth, brickHeight;
	
	private Brick[] bricks;
	private int numOfBricks;
	
	
	public BrickManager(int _x, int _y, int _brickWidth, int _brickHeight, int _numOfBricks){
		x = _x;
		y = _y;
		brickWidth = _brickWidth;
		brickHeight = _brickHeight;
		numOfBricks = _numOfBricks;
		
		bricks = new Brick[numOfBricks];
		for(int i=0; i<numOfBricks; i++){
			bricks[i] = new Brick(x, y+i*brickHeight, brickWidth, brickHeight, i==numOfBricks-1? true:false);
		}
	}
	public boolean checkCollision(Ball ball){ // checks if ball hits a brick, implements logic
		for(int i=0; i<numOfBricks; i++){
			if(bricks[i].isHit(ball)){   //if bottom is hit
				if(i==numOfBricks-1){
					bricks[i] = null;
					if(i-1>=0) bricks[i-1].setAsBottomBrick();
					numOfBricks--;
					return true;
				}
				else {
					for(int j=i+1; j<numOfBricks; j++){ // if anything else is hit
						bricks[j-1] = bricks[j];
						bricks[j].shiftUp();
					}
					bricks[numOfBricks-1] = null;
					numOfBricks--;
					
					return true;
				}}}
		return false;
	}
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		for(int i=0; i<numOfBricks; i++){
			bricks[i].paintComponent(g2);		
		}
	}	
}
