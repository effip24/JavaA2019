// Comment -Good work1

/**
 * class Einstein plays Einstein game.
 *
 * @author (Ephraim Phil -)
 * @version (21/11/2018)
 */
import java.util.Scanner;
public class Einstein
{
    public static void main(String [] args)
    {
        //variables declaration
        Scanner scan = new Scanner(System.in);
        int userNumber, userNumberInHaundreds, userNumberInTens, userNumberInUnify, reversedUserNumber;
        int difference, differenceInHaundreds, differenceInTens, differenceInUnify, reversedDifference;
        final int RESULT_NUMBER = 1089;

        //takes user input
        System.out.println("Welcome to the Einstein magic game.");
        System.out.println("Please enter a 3 digit positive number whose first and last digits are different");
        userNumber = scan.nextInt();

        //reverses the user input number ;
        userNumberInHaundreds = userNumber % 1000 /100;
        userNumberInTens = userNumber % 100 / 10;
        userNumberInUnify = userNumber % 10;
        reversedUserNumber = (userNumberInUnify * 100) + (userNumberInTens * 10) + userNumberInHaundreds;
        //calculates the difference
        difference = Math.abs(userNumber-reversedUserNumber);

        //reverses the difference;
        differenceInHaundreds = difference % 1000 / 100;
        differenceInTens = difference % 100 / 10;
        differenceInUnify = difference % 10;
        reversedDifference = (differenceInUnify * 100) + (differenceInTens * 10) + differenceInHaundreds;

        /* 
         * checks if it's a 3 digits positive number  
         * and if userNumber first and last digits are different and not equals
         */
        if(userNumber >= 100 && userNumber < 1000 && userNumberInHaundreds != userNumberInUnify)
        {
            //output
            System.out.println("User number is: "+userNumber);
            System.out.println("Difference: "+difference);
            System.out.println("Reversed difference: "+reversedDifference);

            //checks if reversed Diffrence + difference equals 1089
            if(reversedDifference + difference == RESULT_NUMBER)
                System.out.println("SUCCEEDED");
            else
                System.out.println("FAILED");
        }
        /*
         * if userNumber first and last digits are equals 
         * or all 3 digits are equlas , the program ends
         */
        else if(userNumber >= 100 && userNumber < 1000  && userNumberInHaundreds == userNumberInUnify)
        {
            System.out.println("The first and last digits of your number should be different");
        }
        else 
        {
            System.out.println("The number you entered is not a 3 digit positive number" );
        }
    }
}