import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;

import java.util.Random;

/**
 * CS 121 Project 1: Traffic Animation
 *
 * Animates a crosswalk light, and a car
 *
 * @author BSU CS 121 Instructors
 * @author [put your name here]
 */
@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel
{
	// This is where you declare constants and variables that need to keep their
	// values between calls	to paintComponent(). Any other variables should be
	// declared locally, in the method where they are used.

  final ImageIcon FIGURE_ICON = new ImageIcon("figure.png");

	/**
	 * A constant to regulate the frequency of Timer events.
	 * Note: 100ms is 10 frames per second - you should not need
	 * a faster refresh rate than this
	 */
	private final int DELAY = 100; //milliseconds

	/**
	 * The anchor coordinate for drawing / animating. All of your vehicle's
	 * coordinates should be relative to this offset value.
	 */
	private int xOffset = 0;

	/**
	 * The number of pixels added to xOffset each time paintComponent() is called.
	 */
	private int stepSize = 10;

	private final Color BACKGROUND_COLOR =new Color(34,139,34);

	/* This method draws on the panel's Graphics context.
	 * This is where the majority of your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		// Get the current width and height of the window.
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height

		// Fill the graphics page with the background color.
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, width, height);

		// Calculate the new xOffset position of the moving object.
		xOffset  = (xOffset + stepSize) % width;

		// TODO: Use width, height, and xOffset to draw your scalable objects
		// at their new positions on the screen

    //ROAD RECT
    g.setColor(Color.black);
    g.fillRect(0, (int)((height * 3) / 10), width, (int)((height * 4) / 10));

    //SKY RECT
    g.setColor(new Color(69, 133, 255));
    g.fillRect(0, (int)((height * 0) / 10), width, (int)((height * 2) / 10));

    //SUN CIRC
    g.setColor(new Color(228, 232, 0));
    int sunRadius = (int)height/10;
    g.fillOval(0-sunRadius,0-sunRadius,sunRadius*2,sunRadius*2);

    //CROSS WALK RECTS
    g.setColor(new Color(255, 255, 255));
    g.fillRect((int)((width * 14) / 40), (int)((height * 27) / 40), (int)((width * 5) / 40), (int)((height * 1) / 40));

    g.fillRect((int)((width * 14) / 40), (int)((height * 25) / 40), (int)((width * 5) / 40), (int)((height * 1) / 40));

    g.fillRect((int)((width * 14) / 40), (int)((height * 23) / 40), (int)((width * 5) / 40), (int)((height * 1) / 40));

    g.fillRect((int)((width * 14) / 40), (int)((height * 21) / 40), (int)((width * 5) / 40), (int)((height * 1) / 40));

    g.fillRect((int)((width * 14) / 40), (int)((height * 19) / 40), (int)((width * 5) / 40), (int)((height * 1) / 40));

    g.fillRect((int)((width * 14) / 40), (int)((height * 17) / 40), (int)((width * 5) / 40), (int)((height * 1) / 40));

    g.fillRect((int)((width * 14) / 40), (int)((height * 15) / 40), (int)((width * 5) / 40), (int)((height * 1) / 40));

    g.fillRect((int)((width * 14) / 40), (int)((height * 13) / 40), (int)((width * 5) / 40), (int)((height * 1) / 40));

    g.fillRect((int)((width * 14) / 40), (int)((height * 11) / 40), (int)((width * 5) / 40), (int)((height * 1) / 40));


		// This draws a green square. Replace it with your own object.
		int squareSide = height / 5;
		int squareY = height / 2 - squareSide / 2;



    //TURTLE MOBILE!
		g.setColor(new Color(11, 107, 0));
    g.fillArc(xOffset, squareY, squareSide, squareSide, 0, 180);

    g.setColor(Color.green);
    g.fillOval((int)(xOffset + (squareY * 2) / 40), (int)((squareY * 50) / 40), (int)(squareSide / 6), (int)(squareSide / 6));

    g.fillOval((int)(xOffset + (squareY * 15) / 40), (int)((squareY * 50) / 40), (int)(squareSide / 6), (int)(squareSide / 6));

    g.setColor(new Color(110, 171, 103));
    g.fillOval((int)(xOffset + (squareY * 15) / 40), (int)((squareY * 43) / 40), (int)(squareSide / 3), (int)(squareSide / 3));

    g.setColor(Color.red);
    g.fillOval((int)(xOffset + (squareY * 18) / 40), (int)((squareY * 46) / 40), (int)(squareSide / 20), (int)(squareSide / 20));

    g.setColor(Color.white);
    g.fillOval((int)(xOffset + (squareY * 16) / 40), (int)((squareY * 45) / 40), (int)(squareSide / 10), (int)(squareSide / 10));

    g.fillOval((int)(xOffset + (squareY * 19) / 40), (int)((squareY * 45) / 40), (int)(squareSide / 10), (int)(squareSide / 10));

    g.drawArc((int)(xOffset + (squareY * 17) / 40), (int)((squareY * 47) / 40), (int)(squareSide / 10), (int)(squareSide / 10), 180, 180);


    //TURTLE MOBILE
    Random ranGen = new Random();
    int rColor = ranGen.nextInt(256);
    int bColor = ranGen.nextInt(256);
    int gColor = ranGen.nextInt(256);

    g.setColor(new Color(rColor, bColor, gColor));

    g.setFont(new Font("Serif", 10, (width * 3) / 40));

    g.drawString("IT'S THE TURTLE-MOBILE!!!", (int)((width * 3) / 40), (int)((height * 5) / 40));


    //DRAW TREE
    g.setColor(new Color(51, 42, 0));

    g.fillRect((int)((width * 33) / 40), (int)((height * 29) / 40), (int)((width * 2) / 40), (int)((height * 32) / 40));

    g.setColor(new Color(bColor, gColor, rColor));

    g.fillOval((int)((width * 33) / 40), (int)((height * 28) / 40), (int)((width * 4) / 40), (int)((width * 3) / 40));

    g.setColor(new Color(0, rColor, 0));

    g.fillOval((int)((width * 31) / 40), (int)((height * 28) / 40), (int)((width * 3) / 40), (int)((width * 3) / 40));

    g.setColor(new Color(0, bColor, 0));

    g.fillOval((int)((width * 32) / 40), (int)((height * 26) / 40), (int)((width * 3) / 40), (int)((width * 4) / 40));

    g.setColor(new Color(0, gColor, 0));

    g.fillOval((int)((width * 32) / 40), (int)((height * 29) / 40), (int)((width * 4) / 40), (int)((width * 3) / 40));


    //SECOND AVATAR

    int squareSide2 = width / 5;
    int squareX = width / 2 - squareSide2 / 2;

    g.setColor(Color.yellow);
    g.fillOval((int)(width - (squareY * 45) / 40), (int)((squareY * 73) / 40), (int)(squareSide / 3), (int)(squareSide / 3));

    g.setColor(Color.red);
    g.fillOval((int)(width - (squareY * 42) / 40), (int)((squareY * 76) / 40), (int)(squareSide / 20), (int)(squareSide / 20));

    g.setColor(Color.blue);
    g.fillOval((int)(width - (squareY * 44) / 40), (int)((squareY * 75) / 40), (int)(squareSide / 10), (int)(squareSide / 10));

    g.fillOval((int)(width - (squareY * 41) / 40), (int)((squareY * 75) / 40), (int)(squareSide / 10), (int)(squareSide / 10));

    g.drawArc((int)(width - (squareY * 43) / 40), (int)((squareY * 77) / 40), (int)(squareSide / 10), (int)(squareSide / 10), 180, 180);



    //CROSS WALK LIGHT
    int lightColorRadius = (int)((height * 3) / 40);

    g.setColor(Color.gray);
    g.fillRect((int)((width * 19) / 40), (int)((height * 27) / 40), lightColorRadius, (int)((height * 5) / 40));

    g.setColor(Color.green);

    if ((xOffset+squareSide >= (int)((width * 14) / 40)) && (xOffset+squareSide <= squareSide + (int)((width * 19) / 40))) {
      g.setColor(Color.red);
    }

    g.fillOval((int)(((width * 19) / 40)), (int)((height * 28) / 40), lightColorRadius, lightColorRadius);


    //FIGURE ICON
    g.drawImage(FIGURE_ICON.getImage(), (int)(((width * 14) / 40)), (int)((height * 28) / 40), (int)((squareSide * 3)/ 4), (int)((squareSide * 3)/ 4), null);


		// Put your code above this line. This makes the drawing smoother.
		Toolkit.getDefaultToolkit().sync();
	}


	//==============================================================
	// You don't need to modify anything beyond this point.
	//==============================================================


	/**
	 * Starting point for this program. Your code will not go in the
	 * main method for this program. It will go in the paintComponent
	 * method above.
	 *
	 * DO NOT MODIFY this method!
	 *
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		// DO NOT MODIFY THIS CODE.
		JFrame frame = new JFrame ("Traffic Animation");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TrafficAnimation());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Constructor for the display panel initializes necessary variables.
	 * Only called once, when the program first begins. This method also
	 * sets up a Timer that will call paint() with frequency specified by
	 * the DELAY constant.
	 */
	public TrafficAnimation()
	{
		// Do not initialize larger than 800x600. I won't be able to
		// grade your project if you do.
		int initWidth = 600;
		int initHeight = 400;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically.
	 * DO NOT MODIFY this method!
	 */
	private void startAnimation()
	{
		ActionListener timerListener = new TimerListener();
		Timer timer = new Timer(DELAY, timerListener);
		timer.start();
	}

	/**
	 * Repaints the graphics panel every time the timer fires.
	 * DO NOT MODIFY this class!
	 */
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
}
