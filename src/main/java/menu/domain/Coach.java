package menu.domain;

import menu.Constants;
import menu.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> noEatFood;
    private final List<String> recommendMenus;

    public Coach(String name, List<String> noEatFood) {
        validateName(name);
        this.name = name;

        validateNoEatFood(noEatFood);
        this.noEatFood = noEatFood;

        this.recommendMenus = new ArrayList<>();
    }

    private void validateName(String name) {
        if (name.length() < Constants.MIN_COACH_NAME_LEN || name.length() > Constants.MAX_COACH_NAME_LEN) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_LENGTH_ERROR);
        }
    }

    private void validateNoEatFood(List<String> noEatFood) {
        if (noEatFood.size() > Constants.MAX_NO_EAT_FOOD_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NO_EAT_FOOD_COUNT_ERROR);
        }
    }

    public void addRecommendMenus(String menu) {
        validateRecommendMenuDuplicate(menu);
        validateNotEatFood(menu);

        recommendMenus.add(menu);
    }

    private void validateRecommendMenuDuplicate(String menu) {
        if (recommendMenus.contains(menu)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNotEatFood(String menu) {
        if (noEatFood.contains(menu)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        List<String> result = new ArrayList<>();

        result.add(name);
        result.addAll(recommendMenus);

        return "[ " + String.join(" | ", result) + " ]";
    }
}
