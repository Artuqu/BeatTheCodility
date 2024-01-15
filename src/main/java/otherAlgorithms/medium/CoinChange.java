package otherAlgorithms.medium;

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


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(new CoinChange().coinChange(coins, 11));
    }
}
