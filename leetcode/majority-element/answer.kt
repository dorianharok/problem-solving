class Solution {
    fun majorityElement(nums: IntArray): Int {
        val n = nums.size / 2
        val map = hashMapOf<Int, Int>()

        for(num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
            if(map[num]!! > n) {
                return num
            }
        }

        return -1
    }
}