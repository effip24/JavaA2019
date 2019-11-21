// Comment - Good work!

/**
 * Class Resistors calculates the total resistance of three resistors.
 *
 * @author (Ephraim Phil-)
 * @version (8/11/2018)
 */
import java.util.Scanner;
public class Resistors
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);
        //variables declaration
        double totalR, totalResistance;

        //takes user input
        System.out.println ("Please enter 3 integers:");
        System.out.println ("Please enter r1:");
        int r1 = scan.nextInt();
        System.out.println ("Please enter r2:");
        int r2 = scan.nextInt();
        System.out.println ("Please enter r3:");
        int r3 = scan.nextInt();

        //calculates r1
        totalR = (1/(double)r1)+(1/(double)r2)+(1/(double)r3);
        totalResistance = 1/totalR;
        System.out.println("The total resistance of resistors "+r1+","
            +r2+" and "+r3+" connected in parallel is: "+totalResistance);
    } // end of method main
} //end of class Resistors 