package cs2114.adventure;

import java.io.PrintWriter;
import java.util.List;

// -------------------------------------------------------------------------
/**
 * This is the command that the user will use to get the award after they have
 * taken each couse
 * 
 * @author Dagmawi Yeshiwas PID: dagmawi
 * @version Feb 12, 2013
 */
public class ReceiveCommand
    extends Command
{
    /**
     * This method executes the receive command
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

            List<Item> pack2 = null;
            pack2 = student.getBackPack();
            ClassRoom inClass = (ClassRoom)student.getCurrentRoom();

            List<Item> pack = null;
            pack = inClass.getSchoolSupplies();

            for (Item item : pack)
            {
                if ((item.getName().equals(itemChoice))
                    && (student.checkBag("Calculator"))
                    && (student.checkBag("Paintbrush"))
                    && (student.checkBag("Microscope"))
                    && (student.checkBag("Final")))
                {
                    student.pickUp(item);
                    pack.remove(item);
                    writer.println("You win! You have graduated College!");
                    return true;
                }
                else if (pack2.size() != 4)
                {
                    writer.println("You don't have all the items to graduate!");
                }
                else
                {
                    writer.println("What is that....?");
                }
            }
        }

        else
        {
            writer.println("Receive what?");
        }

        return false;
    }
}
