package cs2114.adventure;

import java.io.PrintWriter;
import java.util.List;

// -------------------------------------------------------------------------
/**
 * This is an over encompassing command that will let the player take item
 * whether it is from a classroom or the gym to end the game
 * 
 * @author Dagmawi Yeshiwas PID: dagmawi
 * @version Feb 12, 2013
 */
public class TakeCommand
    extends Command
{
    /**
     * This method executes the take command
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
            pack = inClass.getSchoolSupplies();

            for (Item item : pack)
            {
                if (item.getName().equals(itemChoice))
                {
                    student.pickUp(item);
                    pack.remove(item);
                    writer.println("You now have " + item.getName()
                        + " in your backpack!");
                    return false;
                }
                else
                {
                    writer.println("What is that....?");
                }
            }
        }
        else
        {
            writer.println("Take what?");
        }

        return false;
    }
}
