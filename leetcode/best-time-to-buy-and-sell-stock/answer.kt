class Solution {
    fun maxProfit(prices: IntArray): Int {
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE

        for (price in prices) {
            min = minOf(min, price)
            max = maxOf(max, price - min)
        }

        return max
    }
}