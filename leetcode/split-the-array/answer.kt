class Solution {
    fun isPossibleToSplit(nums: IntArray): Boolean {
        val map = HashMap<Int, Int>()

        for(num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
            if(map[num]!! > 2) {
                return false
            }
        }

        return true
    }
}