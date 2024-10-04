class Solution {
    fun maxSubArray(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        dp[0] = nums[0]

        var max = nums[0]
        for (i in 1..<nums.size) {
            dp[i] = maxOf(nums[i], dp[i-1] + nums[i])
            max = maxOf(dp[i], max)
        }

        return max
    }
}