class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val modMap = mutableMapOf<Int, Int>()
        modMap[0] = -1

        var sum = 0

        for ((i, num) in nums.withIndex()) {
            sum += num
            val mod = sum % k

            val prevIndex = modMap[mod]
            if (prevIndex != null && i - prevIndex >= 2) {
                return true
            }

            modMap.putIfAbsent(mod, i)
        }

        return false
    }
}