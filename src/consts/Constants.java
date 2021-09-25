package consts;

public class Constants {

    //Maximum and minimum coordinates for X and Y
    public static final int MAX_X = 5;
    public static final int MIN_X = 0;
    public static final int MAX_Y = 5;
    public static final int MIN_Y = 0;

    //Constants for the command
    public static final String PLACE = "place";
    public static final String MOVE = "move";
    public static final String LEFT = "left";
    public static final String RIGHT = "right";
    public static final String REPORT = "report";
    public static final String EXIT = "exit";

    //VALID and INVALID
    public static final String VALID = "VALID";
    public static final String INVALID = "INVALID";

    //OUTPUT
    public static final String INCORRECT_INPUT = "Oops, incorrect input. Enter a valid input";
    public static final String WELCOME_MESSAGE = "Enter your command (Type 'EXIT' to exit):";
    public static final String FIRST_COMMAND_MESSAGE = "First command should be Place with a valid direction";
}
