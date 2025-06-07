class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1

        while(l <= r) {
            val mid = l + (r - l) / 2

            if(nums[mid] > target) {
                r = mid -1
            } else if(nums[mid] == target) {
                return mid
            } else {
                l = mid + 1
            }
        }

        return -1
    }
}