class Solution {
    fun maxProfit(prices: IntArray): Int {
        val stack = Stack<Int>()

        var profit = 0
        for (i in prices.indices) {
            if(!stack.isEmpty() && prices[stack.peek()] < prices[i]) {
                profit += prices[i] - prices[stack.pop()]
            }

            stack.push(i)
        }

        return profit
    }
}