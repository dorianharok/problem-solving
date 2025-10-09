class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var count = 0
        var max = 0

        for(num in nums) {
            if(num == 0) {
                max = max(max, count)
                count = 0
            } else {
                count++
            }
        }

        return max(max, count)
    }
}