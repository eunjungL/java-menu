package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RecommendationTest {
    @DisplayName("중복된 카테고리 예외 처리 테스트")
    @Test
    void addCategoryDuplicate() {
        Recommendation recommendation = new Recommendation(
                List.of(
                        new Coach("포비", List.of("김밥")),
                        new Coach("왼손", List.of("규동"))
                )
        );

        recommendation.addCategory(Category.ASIAN);
        recommendation.addCategory(Category.ASIAN);

        assertThatThrownBy(() -> recommendation.addCategory(Category.ASIAN))
                .isInstanceOf(IllegalArgumentException.class);
    }
}