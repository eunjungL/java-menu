package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.Constants;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Recommendation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoachService {
    public Recommendation getRecommendations(List<Coach> coaches) {
        Recommendation recommendation = new Recommendation(coaches);

        for (int i = 0; i < 5; i++) {
            Category category = choiceCategory();
            recommendation.addCategory(category);

            choiceMenu(coaches, category);
        }

        return recommendation;
    }

    private Category choiceCategory() {
        int categoryNumber = Randoms.pickNumberInRange(Constants.MIN_CATEGORY_NUM, Constants.MAX_CATEGORY_NUM);
        return Category.getCategory(categoryNumber);
    }

    private void choiceMenu(List<Coach> coaches, Category category) {
        for (Coach coach : coaches) {
            choiceMenuByCoach(coach, category);
        }
    }

    private void choiceMenuByCoach(Coach coach, Category category) {
        boolean isContinue = true;

        while (isContinue) {
            try {
                coach.addRecommendMenus(category.choiceMenu());
                isContinue = false;
            } catch (IllegalArgumentException ignored) {}
        }
    }
}
