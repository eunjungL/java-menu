package menu.domain;

import menu.Constants;
import menu.ErrorMessage;

public class Coach {
    private final String name;

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < Constants.MIN_COACH_NAME_LEN || name.length() > Constants.MAX_COACH_NAME_LEN) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_LENGTH_ERROR);
        }
    }
}
