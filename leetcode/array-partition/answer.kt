class Solution {
    fun arrayPairSum(nums: IntArray): Int {
        nums.sort()
        return nums.filterIndexed{ index, _ -> index % 2 == 0 }.sum()
    }
}