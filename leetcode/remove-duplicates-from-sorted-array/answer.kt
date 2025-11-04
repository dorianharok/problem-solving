class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var p = 1
        for(i in 1 until nums.size) {
            if(nums[i] != nums[i-1]) {
                nums[p++] = nums[i]
            }
        }

        return p
    }
}