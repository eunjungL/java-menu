package menu;

public class ErrorMessage {
    private final static String ERROR_PREFIX = "[ERROR] ";

    public final static String DELIMITER_ERROR = ERROR_PREFIX + "구분자는 , 로 입력해야 합니다.";
    public final static String COACH_NAME_COUNT_ERROR = ERROR_PREFIX + "코치의 수는 %d ~ %d명이어야 합니다.";
    public final static String COACH_NAME_LENGTH_ERROR = ERROR_PREFIX +
            String.format(
                    "코치의 이름은 %d ~ %d 사이의 길이여야 합니다.",
                    Constants.MIN_COACH_NAME_LEN,
                    Constants.MAX_COACH_NAME_LEN
            );
    public final static String NO_EAT_FOOD_COUNT_ERROR = ERROR_PREFIX + String.format(
            "먹지 못하는 음식의 개수는 %d개 이하여야 합니다.", Constants.MAX_NO_EAT_FOOD_COUNT
    );
}
