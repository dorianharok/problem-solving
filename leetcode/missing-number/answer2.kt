class Solution {
    fun missingNumber(nums: IntArray): Int {
        var num = nums.size * (nums.size + 1) / 2
        for (i in nums.indices) {
            num -= nums[i]
        }

        return num
    }
}