package cs2114.adventure;

// -------------------------------------------------------------------------
/**
 * This is the main Game method
 * 
 * @author Dagmawi Yeshiwas PID: dagmawi
 * @version Feb 6, 2013
 */
public class AdventureGame
    extends Game
{

    // ----------------------------------------------------------
    /**
     * Create a new AdventureGame object.
     */
    public AdventureGame()
    {
        super(new Student(50));
    }


    /**
     * This method creates the commands for the user in the game
     */
    @Override
    public void createCommands()
    {
        CommandWords commands = commandWords();
        commands.addCommand("go", new GoCommand());
        commands.addCommand("help", new HelpCommand(commands));
        commands.addCommand("quit", new QuitCommand());
        commands.addCommand("take", new TakeCommand());
        commands.addCommand("show", new InventoryCommand());
        commands.addCommand("drop", new DropCommand());
        commands.addCommand("receive", new ReceiveCommand());

    }


    /**
     * This method creates the rooms for the game.
     */
    @Override
    public void createRooms()
    {
        // Creations
        ClassRoom mathClass = new ClassRoom("Math Class");
        ClassRoom bioClass = new ClassRoom("Biology Class");
        ClassRoom hall = new ClassRoom("The Hallway");
        ClassRoom artClass = new ClassRoom("Art Class");
        ClassRoom examRoom = new ClassRoom("Exam Room");
        ClassRoom gym = new ClassRoom("gym");

        // Additions
        Item calc = new Item("Calculator", 1);
        mathClass.addItem(calc);
        Item scope = new Item("Microscope", 3);
        bioClass.addItem(scope);
        Item brush = new Item("Paintbrush", 1);
        artClass.addItem(brush);
        Item exam = new Item("Final", 1);
        examRoom.addItem(exam);
        Item award = new Item("Diploma", 1);
        gym.addItem(award);

        // Linkage
        hall.setExit("south", mathClass);
        mathClass.setExit("north", hall);
        hall.setExit("west", bioClass);
        bioClass.setExit("east", hall);
        hall.setExit("east", artClass);
        artClass.setExit("west", hall);
        hall.setExit("north", examRoom);
        examRoom.setExit("south", hall);
        examRoom.setExit("north", gym);
        gym.setExit("south", examRoom);

        player().setCurrentRoom(hall);

    }


    /**
     * This method creates a welcome message for the user at the begining of the
     * game
     * 
     * @return the welcome message
     */
    @Override
    public String welcomeMessage()
    {
        return "Welcome to Virginia Tech! \n"
            + "This is your first step in becoming a scholar.\n"
            + "Type help if you need assistance.";
    }

}
