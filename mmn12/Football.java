// Comment -Good work!

/**
 * Class Football calculates the score of the university football team which played in three different games against different teams.
 *
 * @author (Ephraim Phil -)
 * @version (21/11/2018)
 */
import java.util.Scanner;
public class Football{
    public static void main(String [] args)
    {
        //variables declaration
        Scanner scan = new Scanner(System.in);
        int score = 0, wins = 0, ties = 0; 

        int gameOneUniversityGoals;
        int gameOneOpponentGoals;

        int gameTwoUniversityGoals;
        int gameTwoOpponentGoals;

        int gameThreeUniversityGoals;
        int gameThreeOpponentGoals;

        //goal difference of game 1,2,3
        int gameOneGoalDifference = 0, gameTwoGoalDifference = 0, gameThreeGoalDifference = 0;

        //basic score points ;
        final int WIN_POINTS = 3;
        final int TIE_POINTS = 2;
        final int LOSS_POINTS = -4;
        //bonus points;
        final int BONUS_POINTS = 5;
        // goal difference of game 1, 2, 3 which needed for BONUS_POINTS 
        final int GAME_ONE_AND_TWO_DIFFERENCE = 2;
        final int GAME_THREE_DIFFERENCE = 3;
        //if university team wins game three, it gets 2 points per goal;
        final int TWO_POINTS_EACH_GOAL = 2;

        //takes user input results for three games
        System.out.println("Please enter results for 3 games in this format: \n"+
            "University Team goals than Opponet Team goals\n");
        //game 1
        System.out.println("Enter the result for game one(University Goals  Opponet Goals): ");
        gameOneUniversityGoals = scan.nextInt();
        gameOneOpponentGoals = scan.nextInt();
        //game 2
        System.out.println("Enter the result for game two(University Goals  Opponet Goals): ");
        gameTwoUniversityGoals = scan.nextInt();
        gameTwoOpponentGoals = scan.nextInt();
        //game 3
        System.out.println("Enter the result for game three(University Goals  Opponet Goals): ");
        gameThreeUniversityGoals = scan.nextInt();
        gameThreeOpponentGoals = scan.nextInt();

        //calculates the score if university team wins game 1;
        if(gameOneUniversityGoals > gameOneOpponentGoals)
        {
            score += WIN_POINTS;
            wins++;
            gameOneGoalDifference = (gameOneUniversityGoals - gameOneOpponentGoals);
        }
        //calculates the score if university team loses game1;
        else if(gameOneUniversityGoals < gameOneOpponentGoals)
        {
            score += LOSS_POINTS;
        }
        //calculates the score if university team ends in tie in game 1;
        else 
        {
            score +=TIE_POINTS;
            ties++;
        }

        //calculates the score if university team wins game 2
        if(gameTwoUniversityGoals > gameTwoOpponentGoals)
        {
            score += WIN_POINTS;
            wins++;
            gameTwoGoalDifference = (gameTwoUniversityGoals - gameTwoOpponentGoals);
            //if university team won game 1 and 2 and the goal difference is more than 2 it gets BONUS_POINTS
            if(gameOneGoalDifference > GAME_ONE_AND_TWO_DIFFERENCE && gameTwoGoalDifference > GAME_ONE_AND_TWO_DIFFERENCE)
            {
                score += BONUS_POINTS;
            }
        }
        //calculates the score if university team loses game 2;
        else if(gameTwoUniversityGoals < gameTwoOpponentGoals)
        {
            score += LOSS_POINTS;
        }
        //calculates the score if university team ends in tie in game 2;
        else 
        {
            score += TIE_POINTS;
            ties++;
        }

        //calculates the score if university team wins game 3;
        if(gameThreeUniversityGoals > gameThreeOpponentGoals)
        {
            score += WIN_POINTS + (gameThreeUniversityGoals * TWO_POINTS_EACH_GOAL);
            wins++;
            gameThreeGoalDifference = (gameThreeUniversityGoals - gameThreeOpponentGoals);
            //checks if the goal differnece is more than 3 in favor of university team
            if(gameThreeGoalDifference >  GAME_THREE_DIFFERENCE )
            {
                //checks if the goal difference in game 1 and 2 is less 2, it gives BONUS_POINTS for game 3
                if(gameOneGoalDifference <= GAME_ONE_AND_TWO_DIFFERENCE && gameTwoGoalDifference <= GAME_ONE_AND_TWO_DIFFERENCE)
                {
                    score += BONUS_POINTS;
                }
                //if the goal difference in game 1 and 2 is more than 2 it gives no BONUS_POINTS for game 3
                else
                {
                    score = score;
                }
            }
        }
        //calculates the score if university team loses game 3;
        else if(gameThreeUniversityGoals < gameThreeOpponentGoals)
        {
            score += LOSS_POINTS;
        }
        //calculates the score if university team ends in tie in game 3;
        else
        {
            score += TIE_POINTS;
            ties++;
            if(gameOneUniversityGoals == gameOneOpponentGoals && gameTwoUniversityGoals == gameTwoOpponentGoals)
            {
                score += BONUS_POINTS;
            }
        }
        //output
        System.out.println("\nNumber of games which the university team won: "+wins);
        System.out.println("Number of games with tie result: "+ties);
        System.out.println("Final score of the university team: "+score);
    }
}
