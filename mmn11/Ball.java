// Comment - Good work!

/**
 * Class Ball calculates the surface area and the volume of a ball.
 *
 * @author (Ephraim Phil - )
 * @version (8/11/2018)
 */
import java.util.Scanner;
public class Ball
{
    public static void main(String [] args)
    {
        //variables declration
        Scanner scan = new Scanner(System.in);
        int radius;
        double surfaceArea, volume;
        final double FORMULA = 4 * Math.PI;

        //takes the radius from user input.
        System.out.println("Please enter the radius of the ball: ");
        radius = scan.nextInt();

        //calculates the ball surface are and volume.
        surfaceArea = FORMULA * Math.pow(radius,2);
        volume = (FORMULA * Math.pow(radius,3))/3;
        System.out.println("The surface area of your ball is: "
            +surfaceArea+" and the volume is: "+volume);
    }
}