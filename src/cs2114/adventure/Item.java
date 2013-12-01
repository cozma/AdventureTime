package cs2114.adventure;

// import java.util.Scanner;
/**
 * // -------------------------------------------------------------------------
 * /** This class represents items that can be found in the game
 * 
 * @author Dagmawi Yeshiwas PID: dagmawi
 * @version Jan 30, 2013
 */
public class Item
    implements Weighable
{
    private String name;
    private double weight;


    // ----------------------------------------------------------
    /**
     * Create a new Item object.
     * 
     * @param a
     *            the name of the object
     * @param b
     *            the weight of the object
     */
    public Item(String a, double b)
    {
        name = a;
        weight = b;
    }


    /**
     * Gets the name of the item
     * 
     * @return the name of the item
     */
    public String getName()
    {
        return name;
    }


    /**
     * Gets the weight of the item
     * 
     * @return the weight of the item
     */
    @Override
    public double getWeight()
    {
        return weight;
    }
}
