class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1

        while(l < r) {
            val mid = l + (r - l) / 2

            if(nums[mid] > nums[r]) {
                l = mid + 1
            } else {
                r = mid
            }
        }

        val pivot = l
        l = 0
        r = nums.size - 1

        while(l <= r) {
            val mid = l + (r - l) / 2
            val midPivot = (mid + pivot) % nums.size

            if(nums[midPivot] == target) {
                return midPivot
            } else if(nums[midPivot] > target) {
                r = mid -1
            } else {
                l = mid + 1
            }
        }

        return -1
    }
}