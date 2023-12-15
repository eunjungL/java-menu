package menu.view;

import menu.Constants;

public class OutputView {
    public void printRecommendations(String result) {
        System.out.println(Constants.PRINT_RECOMMENDATION_COMMENT);
        System.out.println(result);
        System.out.println(Constants.END_COMMENT);
    }
}
