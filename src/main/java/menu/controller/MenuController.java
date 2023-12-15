package menu.controller;

import menu.Constants;
import menu.domain.Coach;
import menu.view.InputView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MenuController {
    private final InputView inputView;

    public MenuController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        System.out.println(Constants.START_COMMENT);

        List<String> coachNames = getCoachNames();
        List<Coach> coaches = makeCoaches(coachNames);
    }

    private List<String> getCoachNames() {
        while (true) {
            try {
                return inputView.getCoachNames();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private List<Coach> makeCoaches(List<String> coachNames) {
        List<Coach> coaches = new ArrayList<>();

        for (String name : coachNames) {
            coaches.add(makeCoach(name));
        }

        return coaches;
    }

    private Coach makeCoach(String name) {
        while (true) {
            try {
                List<String> noEatFood = inputView.getNoEatFood(name);
                return new Coach(name, noEatFood);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
