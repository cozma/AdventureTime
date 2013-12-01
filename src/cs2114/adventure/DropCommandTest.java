package cs2114.adventure;

import java.util.Scanner;
import junit.framework.TestCase;
import student.testingsupport.PrintWriterWithHistory;

// -------------------------------------------------------------------------
/**
 * This class tests the drop command
 * 
 * @author Dagmawi Yeshiwas PID: dagmawi
 * @version Feb 13, 2013
 */
public class DropCommandTest
    extends TestCase
{
    /**
     * This is the test case for the Take command used by the user.
     */
    public void testDrop()
    {
        Student player = new Student(50);
        // Now create a room, and put the player and items in the room...
        ClassRoom art = new ClassRoom("Art Class");
        player.setCurrentRoom(art);
        Item brush = new Item("Paintbrush", 1);
        art.addItem(brush);
        player.pickUp(brush);
        // Create the command and give it some arguments:
        DropCommand command = new DropCommand();
        command.readArguments(new Scanner("Paintbrush"));

        // Execute the command:
        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.execute(player, writer);

        // Now you can either use the assertion below to check that the
        // expected output was generated, or you can write asserts based
        // on the contents of the item lists in the room and the player.
        assertTrue(writer.getHistory().contains(
            "You have lost Paintbrush from your backpack!"));

    }


    /**
     * This tests the drop method, but in a different case
     */
    public void testDropFail1()
    {
        Student player = new Student(50);
        // Now create a room, and put the player and items in the room...
        ClassRoom art = new ClassRoom("Art Class");
        player.setCurrentRoom(art);
        Item brush = new Item("Paintbrush", 1);
        art.addItem(brush);
        player.pickUp(brush);
        // Create the command and give it some arguments:
        DropCommand command = new DropCommand();
        command.readArguments(new Scanner("Paintbrush"));

        // Execute the command:
        command.readArguments(new Scanner(""));
        PrintWriterWithHistory writer2 = new PrintWriterWithHistory();
        command.execute(player, writer2);
        assertFalse(command.hasSecondWord());
        assertTrue(writer2.getHistory().contains("Drop what?"));
    }


    /**
     * This tests the drop method, but in a different case
     */
    public void testDropFail2()
    {
        Student player = new Student(50);
        // Now create a room, and put the player and items in the room...
        ClassRoom art = new ClassRoom("Art Class");
        player.setCurrentRoom(art);
        Item brush = new Item("Paintbrush", 1);
        art.addItem(brush);
        player.pickUp(brush);
        // Create the command and give it some arguments:
        DropCommand command = new DropCommand();
        command.readArguments(new Scanner("Paintbrush"));

        // Execute the command:
        command.readArguments(new Scanner("fregerg"));
        PrintWriterWithHistory writer3 = new PrintWriterWithHistory();
        command.execute(player, writer3);
        assertTrue(writer3.getHistory().contains("What is that....?"));
    }
}
