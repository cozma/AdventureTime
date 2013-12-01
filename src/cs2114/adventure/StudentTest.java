package cs2114.adventure;

// -------------------------------------------------------------------------
/**
 * This is the test class for the student methods
 * 
 * @author Dagmawi Yeshiwas PID: dagmawi
 * @version Feb 4, 2013
 */
public class StudentTest
    extends student.TestCase
{
    private ClassRoom mathClass;
    private Student   john;
    private Item      textBook;
    private Item      textBookFull;
    private Item      book;


    /**
     * Creates a new Student test object
     */
    public StudentTest()
    {
        //
    }


    /**
     * set up for testing
     */
    @Override
    public void setUp()
    {
        mathClass = new ClassRoom("Math Class");
        john = new Student(6);
        textBook = new Item("Textbook", 2);
        book = new Item("Book", 2);
        textBookFull = new Item("Physics", 50);
        john.setCurrentRoom(mathClass);
    }


    /**
     * Tests the pick up method for the student
     */
    public void testPickUP()
    {
        john.setCurrentRoom(mathClass);
        mathClass.addItem(textBook);
        john.pickUp(textBook);

        assertEquals(1, john.getBackPack().size());
    }


    /**
     * Tests the pick up method for the student
     */
    public void testPickUP2()
    {
        john.setCurrentRoom(mathClass);
        mathClass.addItem(textBookFull);
        john.pickUp(textBookFull);

        assertEquals(0, john.getBackPack().size());
    }


    /**
     * This tests the drop method for the student class
     */
    public void testDropItem()
    {

        john.setCurrentRoom(mathClass);
        john.pickUp(textBook);
        assertEquals(true, john.checkBag("Textbook"));
        john.dropItem("Textbook");
        assertEquals(false, john.checkBag("Textbook"));
        john.dropItem("Textbook");
        assertEquals(false, john.checkBag("science"));
        john.pickUp(book);
        john.pickUp(textBook);
        john.dropItem("Physics");

    }


    /**
     * This is the test method that tests for whether the bad has contents or
     * not
     */
    public void testCheckBag()
    {
        john.pickUp(textBook);
        assertTrue(john.checkBag("Textbook"));
// john.dropItem("Textbook");
// assertFalse(john.checkBag("Textbook"));
    }


    /**
     * This is the test method that tests for whether the bad has contents or
     * not
     */
    public void testCheckBag2()
    {
        john = new Student(6);
        john.pickUp(textBook);
        assertFalse(john.checkBag("Science"));
    }


    /**
     * test the total weight method
     */
    public void testTotalWeight()
    {
        Student josh = new Student(21);
        Item book1 = new Item("Book", 10);
        Item book2 = new Item("book2", 10);
        josh.pickUp(book1);
        josh.pickUp(book2);
        josh.getWeight();

        assertEquals(20, josh.getWeight(), 0.01);

    }

}
