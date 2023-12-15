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
}
