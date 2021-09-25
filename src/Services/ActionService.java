package Services;

import classes.Direction;
import classes.Movement;
import classes.ToyRobot;
import consts.Constants;

import static classes.Direction.*;
import static classes.Movement.LEFT;
import static classes.Movement.RIGHT;

public class ActionService {

    public void place(int x, int y, Direction direction, ToyRobot robot) {
        robot.setX(x);
        robot.setY(y);
        robot.setDirection(direction);
    }

    public void move(ToyRobot robot) {
        int newCoordinates = 0;
        switch (robot.getDirection()) {
            case NORTH:
                newCoordinates = robot.getY() + 1 <= Constants.MAX_Y ? robot.getY() + 1 : robot.getY();
                robot.setY(newCoordinates);
                break;
            case SOUTH:
                newCoordinates = robot.getY() - 1 >= Constants.MIN_Y ? robot.getY() - 1 : robot.getY();
                robot.setY(newCoordinates);
                break;
            case WEST:
                newCoordinates = robot.getX() - 1 >= Constants.MIN_X ? robot.getX() - 1 : robot.getX();
                robot.setX(newCoordinates);
                break;
            case EAST:
                newCoordinates = robot.getX() + 1 <= Constants.MAX_X ? robot.getX() + 1 : robot.getX();
                robot.setX(newCoordinates);
                break;
        }
    }

    public void place(int x, int y, ToyRobot robot) {
        robot.setX(x);
        robot.setY(y);
    }

    public void changeDirection(Movement movement, ToyRobot robot) {
        if (movement == LEFT) {
            switch (robot.getDirection()) {
                case NORTH:
                    robot.setDirection(WEST);
                    break;
                case SOUTH:
                    robot.setDirection(EAST);
                    break;
                case WEST:
                    robot.setDirection(SOUTH);
                    break;
                case EAST:
                    robot.setDirection(NORTH);
                    break;
            }
        }

        if (movement == RIGHT) {
            switch (robot.getDirection()) {
                case NORTH:
                    robot.setDirection(EAST);
                    break;
                case SOUTH:
                    robot.setDirection(WEST);
                    break;
                case WEST:
                    robot.setDirection(NORTH);
                    break;
                case EAST:
                    robot.setDirection(SOUTH);
                    break;
            }
        }

    }

    public String report(ToyRobot robot) {
        return robot.getX().toString() + "," + robot.getY().toString() + "," + robot.getDirection().toString();
    }


}
