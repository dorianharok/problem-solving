class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var p = 0
        for((idx, num) in nums.withIndex()) {
            if(nums[idx] != 0) {
                swap(nums, idx, p)
                p++
            }
        }
    }

    fun swap(nums: IntArray, a: Int, b: Int) {
        val temp = nums[a]
        nums[a] = nums[b]
        nums[b] = temp
    }
}