package menu.controller;

import menu.Constants;
import menu.domain.Coach;
import menu.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private final InputView inputView;

    public MenuController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        System.out.println(Constants.START_COMMENT);

        List<Coach> coaches = getCoaches();
    }

    private List<Coach> getCoaches() {
        while (true) {
            try {
                List<String> coachNames = inputView.getCoachNames();
                return makeCoachesByName(coachNames);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private List<Coach> makeCoachesByName(List<String> coachNames) {
        List<Coach> coaches = new ArrayList<>();

        for (String name : coachNames) {
            coaches.add(new Coach(name));
        }

        return coaches;
    }
}
