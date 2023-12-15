package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CoachTest {
    @DisplayName("이름 글자 수 초과 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"포", "포비포비포비"})
    void nameLengthTest(String name) {
        assertThatThrownBy(() -> new Coach(name, List.of("규동", "떡볶이")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("못 먹는 음식 개수 초과 테스트")
    @Test
    void notEatFoodLength() {
        assertThatThrownBy(() -> new Coach("포비", List.of("규동", "떡볶이", "김밥")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이미 있는 메뉴 추천 시 예외 발생 테스트")
    @Test
    void addRecommendMenusDuplicateMenu() {
        Coach coach = new Coach("포비", List.of("규동", "떡볶이"));

        coach.addRecommendMenus("김밥");
        assertThatThrownBy(
                () -> coach.addRecommendMenus("김밥")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("못 먹는 메뉴 추천 시 예외 발생 테스트")
    @Test
    void addRecommendMenusNotEatMenu() {
        Coach coach = new Coach("포비", List.of("규동", "떡볶이"));

        assertThatThrownBy(
                () -> coach.addRecommendMenus("규동")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}