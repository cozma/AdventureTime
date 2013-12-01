package cs2114.adventure;

import java.util.Scanner;
import junit.framework.TestCase;
import student.testingsupport.PrintWriterWithHistory;

// -------------------------------------------------------------------------
/**
 * This is the test class for the receive command the user will use to receive
 * the award for completing all the courses in school to graduate.
 * 
 * @author Dagmawi Yeshiwas PID: dagmawi
 * @version Feb 13, 2013
 */
public class ReceiveCommandTest
    extends TestCase
{
    /**
     * This is the test case for the Take command used by the userl.
     */
    public void testReceive()
    {
        Student player = new Student(50);
        // Now create a room, and put the player and items in the room...
        ClassRoom gym = new ClassRoom("gym");
        Item award = new Item("Diploma", 1);
        Item calc = new Item("Calculator", 1);
        Item scope = new Item("Microscope", 3);
        Item brush = new Item("Paintbrush", 1);
        Item exam = new Item("Final", 1);
        player.pickUp(scope);
        player.pickUp(calc);
        player.pickUp(brush);
        player.pickUp(exam);
        gym.addItem(award);

        player.setCurrentRoom(gym);
        // Create the command and give it some arguments:
        ReceiveCommand command = new ReceiveCommand();
        command.readArguments(new Scanner("Diploma"));

        // Execute the command:
        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.execute(player, writer);

        // Now you can either use the assertion below to check that the
        // expected output was generated, or you can write asserts based
        // on the contents of the item lists in the room and the player.
        // assertTrue(command.execute(player, writer));
        assertTrue(writer.getHistory().contains("You win"));
    }


    /**
     * This is the test case for the Take command used by the userl.
     */
    public void testReceiveFail4()
    {
        Student player = new Student(50);
        // Now create a room, and put the player and items in the room...
        ClassRoom gym = new ClassRoom("gym");
        Item award = new Item("Diploma", 1);
        Item calc = new Item("Calculator", 1);
        Item scope = new Item("Microscope", 3);
        Item brush = new Item("Paintbrush", 1);
        // Item exam = new Item("Final", 1);
        player.pickUp(scope);
        player.pickUp(calc);
        player.pickUp(brush);
        // player.pickUp(exam);
        gym.addItem(award);

        player.setCurrentRoom(gym);
        // Create the command and give it some arguments:
        ReceiveCommand command = new ReceiveCommand();
        command.readArguments(new Scanner("Diploma"));

        // Execute the command:
        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.execute(player, writer);

        // Now you can either use the assertion below to check that the
        // expected output was generated, or you can write asserts based
        // on the contents of the item lists in the room and the player.
        // assertTrue(command.execute(player, writer));
        assertTrue(writer.getHistory().contains(
            "You don't have all the items to graduate!"));
    }


    /**
     * this test tests the inventory command but in a different case
     */
    public void testReceiveFail1()
    {
        Student player = new Student(50);
        // Now create a room, and put the player and items in the room...
        ClassRoom gym = new ClassRoom("gym");
        Item award = new Item("Diploma", 1);
        Item calc = new Item("Calculator", 1);
        Item scope = new Item("Microscope", 3);
        Item brush = new Item("Paintbrush", 1);
        Item exam = new Item("Final", 1);
        player.pickUp(scope);
        player.pickUp(calc);
        player.pickUp(brush);
        player.pickUp(exam);
        gym.addItem(award);

        player.setCurrentRoom(gym);
        // Create the command and give it some arguments:
        ReceiveCommand command = new ReceiveCommand();

        command.readArguments(new Scanner(""));
        PrintWriterWithHistory writer2 = new PrintWriterWithHistory();
        command.execute(player, writer2);
        assertFalse(command.hasSecondWord());
        assertTrue(writer2.getHistory().contains("Receive what?"));
    }


    /**
     * this test tests the inventory command but in a different case
     */
    public void testReceiveFail2()
    {
        Student player = new Student(50);
        // Now create a room, and put the player and items in the room...
        ClassRoom gym = new ClassRoom("gym");
        Item award = new Item("Diploma", 1);
        Item calc = new Item("Calculator", 1);
        Item scope = new Item("Microscope", 3);
        Item brush = new Item("Paintbrush", 1);
        Item exam = new Item("Final", 1);
        player.pickUp(scope);
        player.pickUp(calc);
        player.pickUp(brush);
        player.pickUp(exam);
        gym.addItem(award);

        player.setCurrentRoom(gym);
        // Create the command and give it some arguments:
        ReceiveCommand command = new ReceiveCommand();

        command.readArguments(new Scanner("fregerg"));
        PrintWriterWithHistory writer3 = new PrintWriterWithHistory();
        command.execute(player, writer3);
        assertTrue(writer3.getHistory().contains("What is that....?"));
    }
}
