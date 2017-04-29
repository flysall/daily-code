package AWT;

/*import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;

import AWT.SimpleDraw.MyCanvas;

public class PinBall {
	// the width of desk
	private final int TABLE_WIDTH = 300;
	//the height of desk
	private final int TABLE_HIGHT = 400;
	// vertical position of the racket
	private final int RACKET_Y = 340;
	// the height and width of racket
	private final int RACKET_HEIGHT = 20;
	private final int RACKET_WIDTH = 60;
	// the size of the ball
	private final int BALL_SIZE = 16;
	private Frame f = new Frame("PinBall");
	Random rand = new Random();
	// Small ball longitudinal movement speed
	private int ySpeed = 10;
	private double xyRate = rand.nextDouble() - 0.5;
	// small ball horizontal movement speed
	private int xSpeed = (int) (ySpeed * xyRate * 2);
	// ballX and ballY is location of small ball
	private int ballX = rand.nextInt(200) + 20;
	private int ballY = rand.nextInt(10) + 20;
	// racketX is the horizontal location
	private int racketX = rand.nextInt(200);
	private MyCanvas tableArea = new MyCanvas();
	//Timer timer;
	// the flag of gameover;
	private boolean isLose = false;

	public void init(){
		tableArea.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HIGHT));
		f.add(tableArea);
		//define keyboard listener
		KeyAdapter keyProcessor = new KeyAdapter(){
			public void KeyPressed(KeyEvent ke){
				if(ke.getKeyCode() == KeyEvent.VK_LEFT ){
					if(racketX > 0){
						racketX = -10;
					}
				}
				if(ke.getKeyCode() == KeyEvent.VK_RIGHT ){
					if(racketX < TABLE_WIDTH - RACKET_WIDTH){
						racketX += 10;
					}
				}
			}
		};
		//add window and tableArea with keyboard listener
		f.addKeyListener(keyProcessor);
		tableArea.addKeyListener(keyProcessor);
		//define a event listener that execute once 0.1s
		ActionListener taskPerformer = evt ->
		{
			//if the ball bump into the left frame
			if(ballX <= 0 || ballX >= TABLE_WIDTH - BALL_SIZE){
				xSpeed = -xSpeed;
			}
			//if the height of ball is over the location of racket, game over
			if(ballY >= RACKET_Y - BALL_SIZE && (ballX < racketX || ballX > racketX + RACKET_WIDTH)){
				timer.stop();
				isLose = true;
				tableArea.repaint();
			}
			//if the ball is inside the racket£¬ ebound
			else if(ballY <= 0 || (ballY >= RACKET_Y && ballX <= racketX + RACKET_WIDTH)){
				ySpeed = -ySpeed;
			}
			//small ball's coordinate increases
			ballY += ySpeed;
			ballX += xSpeed;
			tableArea.repaint();
		};			timer = new Timer(100, taskPerformer);
		timer.start();
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new PinBall().init();
	}

	class MyCanvas extends Canvas {
		public void paint(Graphics g) {
			// if the game has overed
			if (isLose) {
				g.setColor(new Color(255, 0, 0));
				g.setFont(new Font("Times", Font.BOLD, 30));
				g.drawString("TEH GAME IS OVER!", 50, 200);
			}
			// if the is not over
			else {
				// set the color and paint the ball
				g.setColor(new Color(240, 240, 80));
				g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
				// set the color and paint the racker
				g.setColor(new Color(80, 80, 200));
				g.fillRect(racketX, RACKET_Y, RACKET_WIDTH, RACKET_HEIGHT);
			}
		}
	}
}*/
