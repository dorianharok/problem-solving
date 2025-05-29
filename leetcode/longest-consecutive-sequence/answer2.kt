class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = HashSet<Int>()
        for(num in nums) {
            set.add(num)
        }

        var longest = 0

        for(num in set) {
            if(!set.contains(num - 1)) {
                var length = 1

                while (set.contains(num + length)) {
                    length++
                }

                longest = Math.max(longest, length)
            }
        }

        return longest
    }
}