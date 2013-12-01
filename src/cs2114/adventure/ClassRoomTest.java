package cs2114.adventure;

// import student.testingsupport.PrintWriterWithHistory;

// -------------------------------------------------------------------------
/**
 * This is the test class for the classroom methods
 * 
 * @author Dagmawi Yeshiwas PID: dagmawi
 * @version Feb 4, 2013
 */
public class ClassRoomTest
    extends student.TestCase
{
    private ClassRoom mathClass;
    private Item      textBook;


    /**
     * Creates a new Classroom test object
     */
    public ClassRoomTest()
    {
        //
    }


    /**
     * Sets up the test fixture
     */
    @Override
    public void setUp()
    {
        mathClass = new ClassRoom("Math Class");
        textBook = new Item("Math", 2);
    }


    /**
     * Tests the add item method for the classroom
     */
    public void testAddItem()
    {
        mathClass.addItem(textBook);

        assertEquals(1, mathClass.getSchoolSupplies().size(), 1);
    }


    /**
     * Tests the remove item method for the classroom
     */
    public void testRemoveItem()
    {
        mathClass.addItem(textBook);
        mathClass.removeItem("Math");

        assertEquals(0, mathClass.getSchoolSupplies().size());
    }


    /**
     * Tests the remove item method for the classroom
     */
    public void testRemoveItem2()
    {
        mathClass.addItem(textBook);
        mathClass.removeItem("Science");

        assertEquals(1, mathClass.getSchoolSupplies().size());
    }


    /**
     * Tests if the room has an item
     */
    public void testCheckRoom()
    {
        mathClass.addItem(textBook);

        assertTrue(mathClass.checkRoom("Math"));
    }


    /**
     * Tests if the room has an item
     */
    public void testCheckRoom2()
    {
        mathClass.addItem(textBook);
        assertFalse(mathClass.checkRoom("textBook"));
    }


    /**
     * This tests the changed long description method
     */
    public void testGetLongDescription()
    {
        mathClass.addItem(textBook);
        mathClass.getLongDescription();
        // PrintWriterWithHistory writer = new PrintWriterWithHistory();
        assertEquals(1, mathClass.getSchoolSupplies().size());
    }

}
