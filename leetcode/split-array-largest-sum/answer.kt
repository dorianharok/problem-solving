class Solution {
    fun splitArray(nums: IntArray, k: Int): Int {
        var l = 1
        var r = nums.sum()
        var ans = 0

        while (l <= r) {
            val mid = l + (r - l) / 2

            if(isPossible(mid, k, nums)) {
                ans = mid
                r = mid - 1
            } else {
                l = mid + 1
            }
        }

        return ans
    }

    fun isPossible(n: Int, k: Int, nums: IntArray): Boolean {
        if(nums.any { it > n }) return false

        var cnt = 1
        var cur = 0

        for(num in nums) {
            if(cur + num <= n) {
                cur += num
            } else {
                cnt++
                cur = num
            }
        }

        return cnt <= k
    }
}