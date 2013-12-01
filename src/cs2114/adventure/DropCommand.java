package cs2114.adventure;

import java.io.PrintWriter;
import java.util.List;

// -------------------------------------------------------------------------
/**
 * This is the command for the user to drop the item from his inventory
 * 
 * @author Dagmawi Yeshiwas PID: dagmawi
 * @version Feb 12, 2013
 */
public class DropCommand
    extends Command
{
    /**
     * This method executes the command for the player to drop an item
     * 
     * @param player
     *            the player in the game
     * @param writer
     *            the script in response to the player
     * @return whether the player has won the game
     */
    @Override
    public boolean execute(Player player, PrintWriter writer)
    {
        Student student = (Student)player;

        if (hasSecondWord())
        {
            String itemChoice = getSecondWord();

            ClassRoom inClass = (ClassRoom)student.getCurrentRoom();

            List<Item> pack = null;
            pack = student.getBackPack();

            for (Item item : pack)
            {
                if (item.getName().equals(itemChoice))
                {
                    student.dropItem(itemChoice);
                    inClass.addItem(item);
                    writer.println("You have lost " + item.getName()
                        + " from your backpack!");
                    break;
                }
                else
                {
                    writer.println("What is that....?");
                }
            }
        }
        else
        {
            writer.println("Drop what?");
        }

        return false;
    }
}
