package vendingmachine.validator;

import vendingmachine.domain.Coin;

public class ValidateBeverage {
    public static final String REGEX = "\\[[a-zA-Z0-9가-힣]+,\\d{3,},\\d+]";
    public static final String COMMA_DETERMINE = ",";
    public static final int SUBSTRING_IDX = 1;
    public static final int ZERO = 0;
    public static final int MIN_PRICE = 100;
    public static final int PRICE_IDX = 1;
    public static final int AMOUNT_IDX = 2;

    public static final String ERROR_BEVERAGE_INPUT = "[ERROR] 올바르지 않는 상품 입력입니다. 다시 입력해주세요.";
    public static final String ERROR_PRICE_UNIT = "[ERROR] 상품 금액을 10원 단위로 입력해야합니다. 다시 입력해주세요.";
    public static final String ERROR_PRICE_RANGE = "[ERROR] 상품 금액은 100원 이상으로 입력해야합니다. 다시 입력해주세요.";
    public static final String ERROR_AMOUNT_RANGE = "[ERROR] 상품 수는 1개 이상으로 입력해야합니다. 다시 입력해주세요.";

    public static boolean isNotValidInputBeverages(String[] beverages) {
        try {
            for (String beverage : beverages) {
                validateRegex(beverage);
                String[] beverageInfos = splitInfo(beverage);
                validatePriceUnit(beverageInfos[PRICE_IDX]);
                validatePriceRange(beverageInfos[PRICE_IDX]);
                validateAmount(beverageInfos[AMOUNT_IDX]);
            }
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    private static String[] splitInfo(String beverage) {
        String beverageInfo = beverage.substring(SUBSTRING_IDX, beverage.length() - SUBSTRING_IDX);
        return beverageInfo.split(COMMA_DETERMINE);
    }

    private static void validateRegex(String beverage) {
        if (!beverage.matches(REGEX)) {
            throw new IllegalArgumentException(ERROR_BEVERAGE_INPUT);
        }
    }

    private static void validatePriceUnit(String price) {
        if (Integer.parseInt(price) % Coin.COIN_10.getAmount() != ZERO) {
            throw new IllegalArgumentException(ERROR_PRICE_UNIT);
        }
    }

    private static void validatePriceRange(String price) {
        if (Integer.parseInt(price) < MIN_PRICE) {
            throw new IllegalArgumentException(ERROR_PRICE_RANGE);
        }
    }

    private static void validateAmount(String amount) {
        if (Integer.parseInt(amount) <= ZERO) {
            throw new IllegalArgumentException(ERROR_AMOUNT_RANGE);
        }
    }

}