class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        var p = 0

        for(num in nums) {
            val cnt = map.getOrDefault(num, 0)
            if(cnt < 2) {
                nums[p++] = num
            }

            map[num] = map.getOrDefault(num, 0) + 1
        }

        return p
    }
}