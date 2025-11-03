class Solution {
    fun tribonacci(n: Int): Int {
        val dp = IntArray(38)

        dp[1] = 1
        dp[2] = 1

        for(i in 3..37) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1]
        }

        return dp[n]
    }
}