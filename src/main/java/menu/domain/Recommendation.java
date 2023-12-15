package menu.domain;

import menu.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recommendation {
    private final List<Category> categories;
    private final List<Coach> coaches;

    public Recommendation(List<Coach> coaches) {
        this.categories = new ArrayList<>();
        this.coaches = coaches;
    }

    public void addCategory(Category category) {
        validateCategoryDuplicate(category);
        categories.add(category);
    }

    private void validateCategoryDuplicate(Category category) {
        if (Collections.frequency(categories, category) > Constants.MAX_DUPLICATE_CATEGORY) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        List<String> result = new ArrayList<>();
        result.add("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");

        List<String> category = new ArrayList<>();
        for (Category c : categories) {
            category.add(c.toString());
        }
        String categories = "[ 카테고리 | " + String.join(" | ", category) + " ]";
        result.add(categories);

        for (Coach c : coaches) {
            result.add(c.toString());
        }

        return String.join("\n", result);
    }
}
