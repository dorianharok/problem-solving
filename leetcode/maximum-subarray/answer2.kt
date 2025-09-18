class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        var prefixSum = 0

        for(num in nums) {
            prefixSum = if(prefixSum < 0) num else prefixSum + num
            max = max(max, prefixSum)
        }

        return max
    }
}