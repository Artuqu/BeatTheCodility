package otherAlgorithms.medium;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= amount) {
                int numCoins = coinChange(coins, amount - coin);
                if (numCoins != -1) {
                    minCoins = Math.min(minCoins, numCoins + 1);
                }
            }
        }
        return (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
    }

    public int coinChange2(int[] coins, int amount) {
        Arrays.sort(coins);
        int counter = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                counter++;
            }
        }
        return amount == 0 ? counter : -1;
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(new CoinChange().coinChange(coins, 11));
        System.out.println(new CoinChange().coinChange2(coins, 11));

    }

}
