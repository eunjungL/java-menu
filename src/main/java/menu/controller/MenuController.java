package menu.controller;

import menu.Constants;
import menu.domain.Coach;
import menu.domain.Recommendation;
import menu.service.CoachService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CoachService coachService;

    public MenuController(InputView inputView, OutputView outputView, CoachService coachService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.coachService = coachService;
    }

    public void run() {
        System.out.println(Constants.START_COMMENT);

        List<String> coachNames = getCoachNames();
        List<Coach> coaches = makeCoaches(coachNames);

        getRecommendations(coaches);
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

    private void getRecommendations(List<Coach> coaches) {
        Recommendation recommendations = coachService.getRecommendations(coaches);

        outputView.printRecommendations(recommendations.toString());
    }
}
