import Services.HandlerService;
import classes.ToyRobot;

import java.util.*;

import static consts.Constants.*;

public class Application {

    public static HandlerService handlerService = new HandlerService();
    public static ToyRobot robot = new ToyRobot();
    public static String ifValid = "";
    public static boolean isInitial = true;

    public static void main(String[] args) {

        String command = "";
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        while (true) {
            System.out.println(WELCOME_MESSAGE);
            command = scanner.nextLine();  // Read user input
            String[] splitCommand = command.split("[\\s,]+");

            if (command.equalsIgnoreCase(EXIT)) {
                break;
            }

            if (isInitial && !command.equals(PLACE) && !(splitCommand.length > 3)) {
                System.out.println(FIRST_COMMAND_MESSAGE);
                continue;
            }
            processInput(splitCommand);
        }

    }

    public static void processInput(String[] splitCommand) {
        if (splitCommand[0].equalsIgnoreCase(PLACE) && splitCommand.length > 3) {
            handlePlaceWithDirection(robot, splitCommand);
        } else if (splitCommand[0].equalsIgnoreCase(PLACE) && splitCommand.length > 2) {
            handlePlace(robot, splitCommand);
        } else if (splitCommand[0].equalsIgnoreCase(MOVE)) {
            move(robot);
        } else if (splitCommand[0].equalsIgnoreCase(LEFT) || splitCommand[0].equalsIgnoreCase(RIGHT)) {
            changeDirection(splitCommand[0], robot);
        } else if (splitCommand[0].equalsIgnoreCase(REPORT)) {
            report(robot);
        } else {
            System.out.println(INCORRECT_INPUT);
        }
    }

    public static void handlePlaceWithDirection(ToyRobot robot, String[] splitCommand) {
        ifValid = handlerService.handlePlace(robot, splitCommand);
        if (ifValid.equals(INVALID)) {
            System.out.println(INCORRECT_INPUT);
        }else{
            isInitial = false;
        }
    }

    public static void handlePlace(ToyRobot robot, String[] splitCommand) {
        ifValid = handlerService.place(robot, splitCommand);
        if (ifValid.equals(INVALID)) {
            System.out.println(INCORRECT_INPUT);
        }
    }

    public static void changeDirection(String movement, ToyRobot robot) {
        ifValid = handlerService.changeDirection(movement, robot);
        if (ifValid.equals(INVALID)) {
            System.out.println(INCORRECT_INPUT);
        }
    }

    public static void move(ToyRobot robot) {
        handlerService.move(robot);
    }

    public static void report(ToyRobot robot) {
        String report = handlerService.report(robot);
        System.out.println(report);
    }

}
