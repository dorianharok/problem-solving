class Solution {
    fun majorityElement(nums: IntArray): List<Int> {
        val map = HashMap<Int, Int>()

        for(num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        val list = mutableListOf<Int>()
        val p = nums.size / 3
        for((k, v) in map) {
            if(v > p) list.add(k)
        }

        return list
    }
}