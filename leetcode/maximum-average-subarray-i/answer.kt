class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        if(nums.size == 1) {
            return nums[0] / 1.0
        }

        val sum = DoubleArray(nums.size + 1)

        for(i in 1..nums.size) {
            sum[i] = sum[i-1] + nums[i-1]
        }

        var max = -Double.MAX_VALUE
        for(i in k..nums.size) {
            max = maxOf(max, (sum[i] - sum[i-k]) / k)
        }

        return max
    }
}