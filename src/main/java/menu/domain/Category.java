package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.Constants;

import java.util.Arrays;
import java.util.List;

public enum Category {
    JAPAN("일식", 1, Constants.JAPAN),
    KOREA("한식", 2, Constants.KOREA),
    CHINA("중식", 3, Constants.CHINA),
    ASIAN("아시안", 4, Constants.ASIAN),
    WESTERN("양식", 5, Constants.WESTERN);

    private final String name;
    private final Integer number;
    private final List<String> foodList;

    Category(String name, Integer number, List<String> foodList) {
        this.name = name;
        this.number = number;
        this.foodList = foodList;
    }

    public static Category getCategory(Integer number) {
        return Arrays.stream(Category.values())
                .filter(category -> category.number.equals(number))
                .findAny()
                .orElseThrow();
    }

    public String choiceMenu() {
        return Randoms.shuffle(foodList).get(0);
    }

    @Override
    public String toString() {
        return name;
    }
}
