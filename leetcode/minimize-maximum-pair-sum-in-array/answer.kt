class Solution {
    fun minPairSum(nums: IntArray): Int {
        nums.sort()
        var l = 0
        var r = nums.size - 1
        var max = 0

        while(l < r) {
            val sum = nums[l++] + nums[r--]
            max = maxOf(max, sum)
        }

        return max
    }
}