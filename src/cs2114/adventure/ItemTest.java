package cs2114.adventure;

// -------------------------------------------------------------------------
/**
 * This is the test class for item class
 * 
 * @author Dagmawi Yeshiwas PID: dagmawi
 * @version Feb 4, 2013
 */
public class ItemTest
    extends student.TestCase
{
    private Item item;


    // ----------------------------------------------------------
    /**
     * This is the setup method
     */
    @Override
    public void setUp()
    {
        item = new Item("Book", 2);

    }


    /**
     * tests the getName method for item
     */
    public void testGetName()
    {
        assertEquals("Book", item.getName());
    }


    /**
     * tests the getWeight method for item
     */
    public void testGetWeight()
    {
        assertEquals(2, item.getWeight(), 0.01);
    }
}
