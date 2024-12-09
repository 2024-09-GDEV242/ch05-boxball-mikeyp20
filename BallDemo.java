import java.awt.Color;
import java.util.HashSet;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Patterson
 * @version Oct 20 
 */

public class BallDemo    
{
    // canvas to draw the balls and the box
    private Canvas myCanvas;
        // box dimensions
        private  int boxHeight = 600;
        private int boxWidth = 550;
        // Canvas dimensions
        private int canvasWidth = 700;
        private int canvasHeight = 700;
        // Top-left corner of the box
        private  int xPos = 10;
        private int yPos = 10;
    
        // collection of balls
        private HashSet<BoxBall> balls = new HashSet<>();
        // random number generator 
        private Random randomGenerator;
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", canvasWidth,canvasHeight);
        randomGenerator = new Random();
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numberOfBalls)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);
        boxBounce(numberOfBalls);
        

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            for(BoxBall boxBall : balls)
            {
                boxBall.move();
            }
            // stop once ball has travelled a certain distance on x axis
    
    
        }
    }
    private void boxBounce (int numberOfBalls)
    {
        myCanvas.drawRectangle(xPos, yPos, boxWidth,boxHeight);
        for (int i = 0; i < numberOfBalls; i++)
        {
            int x = randomPosition(boxWidth) + xPos;
            int y = randomPosition(boxHeight) + yPos;    
        }
        BoxBall boxBall = new BoxBall(x,y,20,Color.BLUE,xPos,xPos + boxWidth,yPos + boxHeight,yPos,myCanvas);
        balls.add(boxBall);
        boxBall.draw();
    }
        private int randomPosition(int maxValue)
    {
        return randomGenerator.nextInt(maxValue);
    }
    }  
    
    

