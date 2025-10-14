class Solution {
    fun findLengthOfLCIS(nums: IntArray): Int {
        var longest = 1
        var prev = nums[0]
        var len = 1

        for(i in 1 until nums.size) {
            if(nums[i] > prev) {
                len++
                longest = max(longest, len)
            } else {
                len = 1
            }

            prev = nums[i]
        }

        return longest
    }
}