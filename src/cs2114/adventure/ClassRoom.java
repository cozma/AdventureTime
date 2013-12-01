package cs2114.adventure;

import java.util.ArrayList;
import java.util.List;

/**
 * // -------------------------------------------------------------------------
 * /** This is the class room class that is an extension of the Room class
 * 
 * @author Dagmawi Yeshiwas PID: dagmawi
 * @version Jan 30, 2013
 */
public class ClassRoom
    extends Room
{
    /**
     * This is the list of items in the classroom
     */
    public ArrayList<Item> schoolSupplies = new ArrayList<Item>();


    /**
     * Text to welcome player to the Game Room
     * 
     * @param description
     *            the description of the room
     */
    public ClassRoom(String description)
    {
        super(description);
    }


    /**
     * This method adds an item to the room
     * 
     * @param item
     *            the item being added to the room
     */
    public void addItem(Item item)
    {

        schoolSupplies.add(item);

    }


    /**
     * Removes an item from the School Supplies list
     * 
     * @param name
     *            the item that will be removed
     */
    public void removeItem(String name)
    {
        for (Item item : schoolSupplies)
        {
            if (item.getName().equals(name))
            {
                schoolSupplies.remove(item);
                break;
            }
        }
    }


    /**
     * This method checks if the item is in the room
     * 
     * @param name
     *            the item being looked for
     * @return whether the list has the item
     */
    public boolean checkRoom(String name)
    {

        for (Item item : schoolSupplies)
        {
            if (item.getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }


    /**
     * Count amount in the class room
     * 
     * @return the school supplies list
     */
    public List<Item> getSchoolSupplies()
    {
        return schoolSupplies;
    }


    /**
     * Override of getLongDescription made to also supply the names of all the
     * items in the room
     * 
     * @return the items in the room with the players movement
     */
    @Override
    public String getLongDescription()
    {
        String des = new String();
        des = super.getLongDescription();
        // add items to original string

        for (int i = 0; i < schoolSupplies.size(); i++)
        {
            des += schoolSupplies.get(i).getName();

        }
        return des;
    }

//
// /**
// * This method takes an item from a room and adds it to the student
// *
// * @param name
// * the item that is being moved
// * @param student
// * the student with the backpack
// */
// public void take(Item name, Student student)
// {
//
// // the item that is taken
// student.pickUp(name);
// schoolSupplies.remove(name);
//
// }
//
//
// /**
// * This method removes an item from the students backpack and adds it to the
// * current room that the player is in.
// *
// * @param name
// * the name of the item being dropped
// * @param student
// * the student
// */
// public void drop(Item name, Student student)
// {
// // the item being dropped from the student
// student.dropItem(name.toString());
// schoolSupplies.add(name);
//
// }
}
