class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var p = 0

        for(i in nums.indices) {
            if(nums[i] != `val` && nums[i] != -1) {
                val temp = nums[i]
                nums[i] = -1
                nums[p++] = temp
            }
        }

        return p
    }
}