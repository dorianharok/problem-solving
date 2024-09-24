class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var map = mutableMapOf<Int, Int>()

        for ((i, num) in nums.withIndex()) {
            if (map.containsKey(target - num)) {
                return intArrayOf(map[target - num] ?: 0, i)
            }

            map[num] = i
        }

        return intArrayOf(0, 0)
    }
}