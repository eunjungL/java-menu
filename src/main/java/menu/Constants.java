package menu;

import java.util.List;

public class Constants {
    /** 메뉴 추천 프로그램에 사용되는 문구 */
    public final static String START_COMMENT = "점심 메뉴 추천을 시작합니다.";
    public final static String GET_COACH_NAME_COMMENT = "코치의 이름을 입력해 주세요. (, 로 구분)";
    public final static String GET_NO_EAT_FOOD_BY_COACH = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    public final static String PRINT_RECOMMENDATION_COMMENT = "메뉴 추천 결과입니다.";
    public final static String END_COMMENT = "추천을 완료했습니다.";

    /** 메뉴 추천 프로그램에 사용되는 숫자 */
    public final static Integer MIN_COACH_COUNT = 2;
    public final static Integer MAX_COACH_COUNT = 5;
    public final static Integer MIN_COACH_NAME_LEN = 2;
    public final static Integer MAX_COACH_NAME_LEN = 4;
    public final static Integer MAX_NO_EAT_FOOD_COUNT = 2;
    public final static Integer MAX_DUPLICATE_CATEGORY = 2;
    public final static Integer MIN_CATEGORY_NUM = 1;
    public final static Integer MAX_CATEGORY_NUM = 5;

    /** 카테고리별 메뉴 */
    public final static List<String> JAPAN = List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼");
    public final static List<String> KOREA = List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
    public final static List<String> CHINA = List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채");
    public final static List<String> ASIAN = List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜");
    public final static List<String> WESTERN = List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니");
}
