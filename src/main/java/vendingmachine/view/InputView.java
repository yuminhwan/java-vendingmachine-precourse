package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.validator.ValidateBeverage;
import vendingmachine.utils.validator.ValidateMoney;

public class InputView {
    public static final String INPUT_VENDING_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    public static final String INPUT_BEVERAGES = "\n상품명과 가격, 수량을 입력해 주세요.";
    public static final String INPUT_INSERT_MONEY = "\n투입 금액을 입력해 주세요.";
    public static final String INPUT_BUY_BEVERAGE = "구매할 상품명을 입력해 주세요.";
    public static final String SEMICOLON_DETERMINE = ";";

    private InputView() {
    }

    public static int inputVendingMachineMoney() {
        System.out.println(INPUT_VENDING_MACHINE_MONEY);
        String machineMoney = Console.readLine();
        while (ValidateMoney.isNotValidMoney(machineMoney)) {
            machineMoney = Console.readLine();
        }
        return Integer.parseInt(machineMoney);
    }

    public static String[] inputBeverages() {
        System.out.println(INPUT_BEVERAGES);
        String[] beverages = Console.readLine().split(SEMICOLON_DETERMINE);
        while (ValidateBeverage.isNotValidInputBeverages(beverages)) {
            beverages = Console.readLine().split(SEMICOLON_DETERMINE);
        }
        return beverages;
    }

    public static int inputInsertMoney() {
        System.out.println(INPUT_INSERT_MONEY);
        String insertMoney = Console.readLine();
        while (ValidateMoney.isNotValidMoney(insertMoney)) {
            insertMoney = Console.readLine();
        }
        return Integer.parseInt(insertMoney);
    }

    public static String inputBuyBeverage() {
        System.out.println(INPUT_BUY_BEVERAGE);
        return Console.readLine();
    }
}
