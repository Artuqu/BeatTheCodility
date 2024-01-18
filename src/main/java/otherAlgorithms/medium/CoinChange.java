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

//    Memoization
    public int coinChange3(int[] coins, int amount) {
        return coinChange3(coins, amount, new int[amount]);
    }

    private int coinChange3(int[] coins, int rem, int[] count) {
        if (rem == 0) return 0;
        if (rem < 0) return -1;
        if (count[rem - 1] != 0) return count[rem - 1];
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int numCoins = coinChange3(coins, rem - coin, count);
            if (numCoins != -1) {
                minCoins = Math.min(minCoins, numCoins + 1);
            }
        }
        count[rem - 1] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
        return count[rem - 1];
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(new CoinChange().coinChange(coins, 11));
        System.out.println(new CoinChange().coinChange2(coins, 11));
        System.out.println(new CoinChange().coinChange3(coins, 11));

    }

}
