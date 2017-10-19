package amazonQuestion;

/**
 * Created by JiahengYu on 01/10/17.
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null)
            return 0;
        if (prices.length == 1)
            return 0;
        int min = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(prices[i], min);
        }

        return maxProfit;
    }

    public static void main(String args[]) {
        int a[] = {7, 6, 4, 3, 1};
        System.out.print(new BestTimetoBuyandSellStock().maxProfit(a));
    }
}
