package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.Constants;
import menu.ErrorMessage;

import java.util.List;

public class InputView {
    public List<String> getCoachNames() {
        System.out.println(Constants.GET_COACH_NAME_COMMENT);
        String input = Console.readLine();

        validateCoachNamesCount(input);
        return List.of(input.split(","));
    }

    private void validateCoachNamesCount(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.DELIMITER_ERROR);
        }

        List<String> coachNames = List.of(input.split(","));

        if (coachNames.size() < Constants.MIN_COACH_COUNT || coachNames.size() > Constants.MAX_COACH_COUNT) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.COACH_NAME_COUNT_ERROR, Constants.MIN_COACH_COUNT, Constants.MAX_COACH_COUNT)
            );
        }
    }

    public List<String> getNoEatFood(String name) {
        System.out.printf(Constants.GET_NO_EAT_FOOD_BY_COACH, name);
        System.out.println();

        String input = Console.readLine();
        return List.of(input.split(","));
    }
}
