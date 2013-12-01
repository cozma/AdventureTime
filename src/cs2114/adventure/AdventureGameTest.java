package cs2114.adventure;

// import java.util.Scanner;
import junit.framework.TestCase;
import student.testingsupport.PrintWriterWithHistory;

// -------------------------------------------------------------------------
/**
 * This is the test class for the main adventure game methods
 * 
 * @author Dagmawi Yeshiwas PID: dagmawi
 * @version Feb 13, 2013
 */
public class AdventureGameTest
    extends TestCase
{
    // ----------------------------------------------------------
    /**
     * This is the test for the game subclass that launches the game
     */
    public void testGame()
    {
        AdventureGame game = new AdventureGame();
        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        game.useWriter(writer);

        assertTrue(game.interpret("quit"));
    }


    /**
     * This tests the welcome message
     */
    public void testMessage()
    {
        AdventureGame game = new AdventureGame();
        game.welcomeMessage();
        assertTrue(game.welcomeMessage().contains("Welcome"));
    }
}
