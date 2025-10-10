class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if(amount == 0) {
            return 0
        }

        val dp = IntArray(amount + 1){ 1000000 }

        for(coin in coins) {
            if(coin > amount) continue
            dp[coin] = 1
        }

        for(i in 1 .. amount) {
            for(coin in coins) {
                if(i - coin <= 0) continue
                dp[i] = min(dp[i], dp[i - coin] + 1)
            }
        }

        return if(dp[amount] == 1000000) return -1 else return dp[amount]
    }
}