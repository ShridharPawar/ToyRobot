package Services;

import classes.Direction;
import classes.Movement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputValidationService {

    public boolean validInput(Integer x, Integer y, String directionInput) {
        return validCoordinates(x, y) && validDirection(directionInput);
    }

    public boolean validCoordinates(Integer x, Integer y) {
        return x <= 5 && x >= 0 && y <= 5 && y >= 0;
    }

    public boolean validDirection(String directionInput) {
        List<String> stringDirectionEnums = Stream.of(Direction.values())
                .map(Enum::name)
                .map(String::toLowerCase).collect(Collectors.toList());

        return stringDirectionEnums.contains(directionInput.toLowerCase());
    }

    public boolean validMovement(String movement) {
        List<String> stringMovementEnums = Stream.of(Movement.values())
                .map(Enum::name)
                .map(String::toLowerCase).collect(Collectors.toList());

        return stringMovementEnums.contains(movement.toLowerCase());
    }
}
