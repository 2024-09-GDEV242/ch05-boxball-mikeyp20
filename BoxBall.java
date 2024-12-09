import java.awt. *;
import java.util.Random;
/**
 * Write a description of class BoxBall here.
 *
 * @author Michael Patterson
 * @version Oct 20
 */
public class BoxBall
{
    // instance variables - replace the example below with your own
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int leftWall;
    private final int rightWall;
    private final int bottomWall;
    private final int topWall;
    private Canvas canvas;
    private int ySpeed;
    private int xSpeed;
    private int const_Distance = 10;
    private final Random rand;
    
    /**
     * Constructor for objects of class BoxBall
     */
    public BoxBall(int left, int right, int top, int bottom, int xPos, int yPos, int ballDiameter, Color ballColor, int box_leftWall, int box_rightWall,int box_bottomWall,int box_topWall, Canvas drawingCanvas)
    {
        // initialise instance variables
        rand = new Random();
        diameter = rand.nextInt(20) + 10;
        xPosition = rand.nextInt(right - left - diameter) + left;
        yPosition = rand.nextInt(bottom - top - diameter) +top;
        
        xSpeed = rand.nextInt(7) + 1;
        ySpeed = rand.nextInt(7) + 1;
        
        color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        canvas = drawingCanvas;
        
        diameter = ballDiameter;
        leftWall = box_leftWall;
        rightWall = box_rightWall - diameter;
        bottomWall = box_bottomWall - diameter;
        topWall = box_topWall;
    }
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }
    
    
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    
    
    
     public void move()
    {
        // remove from canvas at the current position
        erase();
        
        int radius = diameter /2;

        // compute new position
        yPosition += ySpeed;
        xPosition +=xSpeed;

        // check if it has hit the ground
        if (yPosition >= (bottomWall - diameter)) {
            yPosition = (int)(bottomWall - diameter);
            ySpeed = -ySpeed;
        }
         if (xPosition >= (rightWall - diameter)) {
            xPosition = (int)(rightWall - diameter);
            xSpeed = -xSpeed;
        }
 /*if (xPos >= box_leftWall)
             xPosition = xPos - const_Distance;
         else
             xPosition = xPos;
             
        if (yPos >= box_rightWall)
            yPosition = yPos - const_Distance;
        else 
            yPosition = yPos;
        // draw again at new position */
        draw();
    }    
    
    
}
