package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static List<Integer> getCoinAmountList() {
        return Arrays.stream(Coin.values())
            .map(Coin::getAmount)
            .collect(Collectors.toList());
    }

    public int getAmount() {
        return amount;
    }
}
