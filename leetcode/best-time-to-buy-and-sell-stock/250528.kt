class Solution {
    fun maxProfit(prices: IntArray): Int {
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE

        for(price in prices) {
            min = Math.min(min, price)
            max = Math.max(max, price - min)
        }

        return max
    }
}