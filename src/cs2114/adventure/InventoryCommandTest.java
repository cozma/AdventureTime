package cs2114.adventure;

import java.util.Scanner;
import junit.framework.TestCase;
import student.testingsupport.PrintWriterWithHistory;

// -------------------------------------------------------------------------
/**
 * This is the test class for the inventory command the user uses to display the
 * items they are carrying
 * 
 * @author Dagmawi Yeshiwas PID: dagmawi
 * @version Feb 13, 2013
 */
public class InventoryCommandTest
    extends TestCase
{
    /**
     * This is the test case for the Take command used by the user.
     */
    public void testInventory()
    {
        Student player = new Student(50);
        // Now create a room, and put the player and items in the room...
        ClassRoom art = new ClassRoom("Art Class");
        Item brush = new Item("Paintbrush", 1);
        art.addItem(brush);
        player.setCurrentRoom(art);
        player.pickUp(brush);
        // Create the command and give it some arguments:
        InventoryCommand command = new InventoryCommand();
        command.readArguments(new Scanner("inventory"));

        // Execute the command:
        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.execute(player, writer);

        // Now you can either use the assertion below to check that the
        // expected output was generated, or you can write asserts based
        // on the contents of the item lists in the room and the player.
        assertTrue(writer.getHistory().contains("Paintbrush"));

    }


    /**
     * this test tests the inventory command but in a different case
     */
    public void testInventoryFail1()
    {
        Student player = new Student(50);
        // Now create a room, and put the player and items in the room...
        ClassRoom art = new ClassRoom("Art Class");
        Item brush = new Item("Paintbrush", 1);
        art.addItem(brush);
        player.setCurrentRoom(art);
        player.pickUp(brush);
        // Create the command and give it some arguments:
        InventoryCommand command = new InventoryCommand();

        command.readArguments(new Scanner(""));
        PrintWriterWithHistory writer2 = new PrintWriterWithHistory();
        command.execute(player, writer2);
        assertFalse(command.hasSecondWord());
        assertTrue(writer2.getHistory().contains("Show what?"));
    }


    /**
     * this test tests the inventory command but in a different case
     */
    public void testInventoryFail2()
    {
        Student player = new Student(50);
        // Now create a room, and put the player and items in the room...
        ClassRoom art = new ClassRoom("Art Class");
        Item brush = new Item("Paintbrush", 1);
        art.addItem(brush);
        player.setCurrentRoom(art);
        player.pickUp(brush);
        // Create the command and give it some arguments:
        InventoryCommand command = new InventoryCommand();

        command.readArguments(new Scanner("fregerg"));
        PrintWriterWithHistory writer3 = new PrintWriterWithHistory();
        command.execute(player, writer3);
        assertTrue(writer3.getHistory().contains("What is that....?"));
    }
}
