class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        val map = HashMap<Int, Int>()

        for(num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        var answer = 0
        for((num, count) in map) {
            val target = k - num

            if(target == num) {
                answer += count / 2
            } else if(num < target && map.containsKey(target)) {
                answer += minOf(count, map[target]!!)
            }
        }

        return answer
    }
}