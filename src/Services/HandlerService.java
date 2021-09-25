package Services;

import classes.Direction;
import classes.Movement;
import classes.ToyRobot;

import static consts.Constants.*;

public class HandlerService {
    public static ActionService actionService = new ActionService();
    public static InputValidationService inputValidationService = new InputValidationService();

    public String handlePlace(ToyRobot robot, String[] splitCommand) {

        Integer x = Integer.parseInt(splitCommand[1]);
        Integer y = Integer.parseInt(splitCommand[2]);

        if (inputValidationService.validInput(x, y, splitCommand[3])) {
            Direction direction = Direction.valueOf(splitCommand[3].toUpperCase());
            actionService.place(x, y, direction, robot);
            return VALID;
        }

        return INVALID;
    }

    public void move(ToyRobot robot) {
        actionService.move(robot);
    }

    public String place(ToyRobot robot, String[] splitCommand) {
        Integer x = Integer.parseInt(splitCommand[1]);
        Integer y = Integer.parseInt(splitCommand[2]);
        if (inputValidationService.validCoordinates(x, y)) {
            actionService.place(x, y, robot);
            return VALID;
        }

        return INVALID;
    }

    public String changeDirection(String movement, ToyRobot robot) {
        if (inputValidationService.validMovement(movement)) {
            Movement movementEnum = Movement.valueOf(movement.toUpperCase());
            actionService.changeDirection(movementEnum, robot);
            return VALID;
        }
        return INVALID;
    }

    public String report(ToyRobot robot) {
        return actionService.report(robot);
    }
}
