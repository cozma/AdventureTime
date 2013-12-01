package cs2114.adventure;

import java.util.ArrayList;
import java.util.List;

/**
 * // -------------------------------------------------------------------------
 * /** This is the role player class that is an extension of the Player class
 * 
 * @author Dagmawi Yeshiwas PID: dagmawi
 * @version Jan 30, 2013
 */
public class Student
    extends Player
    implements Weighable
{
    /**
     * the students backPack
     */
    public List<Item> backPack;
    // private ClassRoom mathClass = new ClassRoom("Math Class");
    private double    maxweight;   // the max possible weight of the player
    private double    playerWeight; // the weight of the player


    /**
     * Creates a list of items for the student to carry
     * 
     * @param w
     *            the weight of the item
     */
    public Student(double w)
    {
        maxweight = w;
        backPack = new ArrayList<Item>();

    }


    /**
     * gets the max weight
     * 
     * @return the max weight
     */
    public double getMax()
    {
        return maxweight;
    }


    /**
     * This method lets the student take an item
     * 
     * @param item
     *            the object to be obtained by the student
     */
    public void pickUp(Item item)
    {

        if (this.getWeight() + item.getWeight() < maxweight)
        {
            backPack.add(item);
            playerWeight = playerWeight + item.getWeight();
        }

    }


    /**
     * total weight of the backpack
     * 
     * @return the sum of the total weight
     */
    @Override
    public double getWeight()
    {
        return playerWeight;
    }


    /**
     * this drops an item
     * 
     * @param name
     *            the name of the item being dropped
     */
    public void dropItem(String name)
    {
        for (int x = 0; x < backPack.size(); x++)
        {
            if (backPack.get(x).getName() == name)
            {
                backPack.remove(x);
                break;
            }
        }

    }


// /**
// * This method lets the student drop an item from the backpack
// *
// * @param name
// * the iteam being dropped from the backpack
// */
// public void dropItem(String name)
// {
// for (Item item : backPack)
// {
// if (item.getName().equals(name))
// {
// backPack.remove(item);
// playerWeight = playerWeight - item.getWeight();
// }
// }
// }
//
//
// /**
// * Check to see if the student has any supplies
// *
// * @param name
// * the name of the item
// * @return whether the back pack has anything in it
// */
// public boolean checkBag(String name)
// {
// for (Item item : backPack)
// {
// if (item.getName().equals(name))
// {
// return true;
// }
// }
// return false;
// }

    /**
     * this checks the bag
     * 
     * @param name
     *            the name of the item
     * @return whehter the bag has items
     */
    public boolean checkBag(String name)
    {
        for (int x = 0; x < backPack.size(); x++)
        {
            if (backPack.get(x).getName() == name)
            {
                return true;
            }
        }

        return false;
    }


    /**
     * Count amount in the back pack
     * 
     * @return the back pack list
     */
    public List<Item> getBackPack()
    {
        return backPack;
    }

}
