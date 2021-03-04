import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

/**
 * Lesson 4: Activity - Using Classes and Objects
 * 
 * Uses the MiniFig class to draw a custom avatar.
 * 
 * @author CS121 instructors
 * @author <you>
 */
@SuppressWarnings("serial")
public class MyAvatar extends JPanel
{
	public final int INITIAL_WIDTH = 800;
	public final int INITIAL_HEIGHT = 600;
	
	/**
	 * Draws the picture in the panel. This is where all of your
	 * code will go.
	 * @param canvas The drawing area of the window.
	 */
	public void paintComponent (Graphics g)
	{
		/* Store the height and width of the panel at the time
		 * the paintComponent() method is called.
		 */
		int currentHeight = getHeight();
		int currentWidth = getWidth();
		
		/* This is the anchor point for the MiniFig (x,y) -> (mid,top) */
		int mid = currentWidth / 2;
		int top = 50;
		
		/* This is the scaler that is used to calculate the dimensions (height / width) 
		 * of each of the MiniFig components. It uses the Math.min() function to select
		 * the smaller of currentWidth/INITIAL_WIDTH and currentHeight/INITIAL_HEIGHT.
		 * This way all the components are scaled to fit within the smaller of the two 
		 * panel dimensions.
		 */
		double scaleFactor = Math.min(currentWidth/(double)INITIAL_WIDTH,currentHeight/(double)INITIAL_HEIGHT );

		// TODO: 1. Instantiate a new Point object called "anchor". Use "mid" as your x value and
		//       "top" as your y value.
		
		Point anchor = new Point(mid, top);
		
		// TODO: 2. Instantiate a new MiniFig object and give the reference variable a name of a person, 
		//       such as "bob". Use the MiniFig constructor with the following
		//       parameters: MiniFig(g, scaleFactor, anchor)
		
		MiniFig gage = new MiniFig(g, scaleFactor, anchor);
		
		// TODO: 3. Create a new custom Color object. An example is shown below.
		
		Color myPurple = new Color( 138,  43,  226); //Purple rbg(138,43,226)
		
		// TODO: 4. Invoke the setTorsoColor(Color color) method on your MiniFig instance.
		//       Use your color object as a parameter to change the shirt color.
		//       This lets you change the color of "bob's" shirt. :)
		
		gage.setTorsoColor(myPurple);
		gage.setFootColor(myPurple);
		gage.setLegColor(Color.white);
		
		
		

		
		
		// TODO: 5. Invoke the draw() method on your MiniFig instance. This is where "bob" is displayed on the screen.
		
//		gage.draw();
		
		// TODO: 6. Adjust the size of your Avatar's window. Notice how the avatar does not stay grounded
		//       on the grass. To fix this, use the getBaseMidPoint() method to find the the base mid point of your
		//       MiniFig. This method returns a Point object that represents the x,y coordinates at the
		//       base of the MiniFig, right between its feet. 
		//       Replace the hard-coded value of grassYOffset with the y value 
		//       of the returned point.
		
		anchor = gage.getBaseMidPoint();
		int grassYOffset = (int) anchor.getY();
		
		Color grassGreen = new Color (60,80,38);
		g.setColor(grassGreen);
		g.fillRect(0, grassYOffset, currentWidth, currentHeight - grassYOffset);
		gage.draw();
		//TOMB STONE THING
		g.setColor(Color.gray);
		g.fillRect(((int)((double)currentWidth-(currentWidth*.3))), currentHeight-(int)(currentHeight*.6), currentWidth,  175);		
		g.fillOval(((int)((double)currentWidth-(currentWidth*.3))), currentHeight-(int)(currentHeight*.745), 250, 175);

		g.setColor(myPurple);
		g.drawString("~Welcome to the Scary Green Planes!~", ((int)((double)currentWidth-(currentWidth*.27))), currentHeight-(int)(currentHeight*.6));
		
		
		//SUN WITH FACE
		g.setColor(Color.orange);
		g.fillOval(-50, -50, 200, 200);
		
		g.setColor(Color.BLUE);
		g.draw3DRect(55, 15, 25, 50, true);
		g.draw3DRect(15, 15, 25, 50, false);
		
		g.drawArc(15, 75, 75, 50, 0, -180);
		
		//TOP HAT
		g.setColor(Color.black);
		g.fillRect((int)gage.getCapPoint().getX()-50, (int)gage.getCapPoint().getY(), 100, -25);
		g.fillRect((int)gage.getCapPoint().getX()-25, (int)gage.getCapPoint().getY(), 50, -75);
		g.setColor(Color.yellow);
		g.fillRect((int)gage.getCapPoint().getX()-25, (int)gage.getCapPoint().getY()-25, 50, -5);
		
		//THING IN HAND
		g.setColor(Color.blue);
		g.fillRect((int)gage.getRightHandCenterPoint().getX()-25, (int)gage.getRightHandCenterPoint().getY(), 50, 75);

		
		// TODO: 7. Create an Alias of for your MiniFig object and change the torso color of the alias.
		//       If in step 2 you used the variable name "bob", you can create an alias named "robert"
		//       using the following:
		//       MiniFig robert = bob;
		//       robert.setTorsoColor(Color.RED);

//		MiniFig solo = gage;

		
	    // TODO: 8. Comment out the draw statement under TODO item 5 and then draw the original MiniFig 
		//       below. If you used the variable name "bob" is would simply be the following:
		//       bob.draw();
		//       What color is Bob's Shirt?  Why?
		

	
		
	}


	/**
	 * Constructor (panel initialization)
	 * @return 
	 */
	
//	public void MakeOrange(int x, int y) {
//		
//	}
//	
	public MyAvatar()
	{
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(INITIAL_WIDTH, INITIAL_HEIGHT));
	}

	/**
	 * Sets up a JFrame and the MiniFigDriver panel.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("MyAvatar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new MyAvatar());
		frame.pack();
		frame.setVisible(true);
	}
}