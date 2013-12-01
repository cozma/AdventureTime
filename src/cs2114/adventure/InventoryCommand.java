package cs2114.adventure;

import java.io.PrintWriter;

// -------------------------------------------------------------------------
/**
 * This is the command that lets the user check the inventory
 * 
 * @author Dagmawi Yeshiwas PID: dagmawi
 * @version Feb 12, 2013
 */
public class InventoryCommand
    extends Command
{
    /**
     * The method executes the command for the player to see thier current
     * inventory
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
        if (hasSecondWord())
        {
            Student student = (Student)player;

            String itemChoice = getSecondWord();

            if (itemChoice.equals("inventory"))
            {
                for (Item item : student.getBackPack())
                {
                    writer.println(item.getName() + "\n");
                }
            }
            else
            {
                writer.println("What is that....?");
            }
        }
        else
        {
            writer.println("Show what?");
        }

        return false;
    }
}
