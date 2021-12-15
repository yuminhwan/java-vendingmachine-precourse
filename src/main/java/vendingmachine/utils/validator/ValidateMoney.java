package vendingmachine.utils.validator;

import vendingmachine.domain.Coin;
import vendingmachine.view.OutputView;

public class ValidateMoney {
    public static final int NEGATIVE_ZERO = 0;
    public static final int REMAINDER_ZERO = 0;

    public static final String ERROR_MONEY_NOT_DIGIT = "[ERROR] 금액은 숫자여야 합니다. 다시 입력해주세요.";
    public static final String ERROR_MONEY_NEGATIVE = "[ERROR] 금액으로 음수를 입력할 수 없습니다. 다시 입력해주세요.";
    public static final String ERROR_MONEY_UNIT = "[ERROR] 금액을 10원 단위로 입력해야합니다. 다시 입력해주세요.";

    public static boolean isNotValidMoney(String money) {
        try {
            int moneyValue = validateDigit(money);
            validateNegative(moneyValue);
            validateMoneyUnit(moneyValue);
            return false;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
        return true;
    }

    private static int validateDigit(String money) {
        try {
            return Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MONEY_NOT_DIGIT);
        }
    }

    public static void validateNegative(int money) {
        if (money < NEGATIVE_ZERO) {
            throw new IllegalArgumentException(ERROR_MONEY_NEGATIVE);
        }
    }

    public static void validateMoneyUnit(int money) {
        if (money % Coin.COIN_10.getAmount() != REMAINDER_ZERO) {
            throw new IllegalArgumentException(ERROR_MONEY_UNIT);
        }
    }
}
