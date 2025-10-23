class Solution {
    fun minOperations(nums: IntArray): Int {
        return if(nums.all { it == nums[0] }) return 0 else 1
    }
}