class Solution {
    fun singleNumber(nums: IntArray): IntArray {
        var mask = 0

        for(num in nums) {
            mask = mask xor num
        }

        mask = mask and -mask

        val answer = IntArray(2)

        for(num in nums) {
            when(mask and num) {
                0 -> answer[0] = answer[0] xor num
                else -> answer[1] = answer[1] xor num
            }
        }

        return answer
    }
}