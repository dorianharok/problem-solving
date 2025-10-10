class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val arr = IntArray(nums.size){ Int.MAX_VALUE }

        var p = 1
        arr[0] = nums[0]
        for(num in nums) {
            if(arr[p-1] < num) {
                arr[p++] = num
            } else {
                val index = lowerBound(arr, num)
                arr[index] = num
            }
        }

        return p
    }

    fun lowerBound(arr: IntArray, target: Int): Int {
        var l = 0
        var r = arr.size

        while(l < r) {
            val mid = l + (r - l) / 2

            if(arr[mid] >= target) {
                r = mid
            } else {
                l = mid + 1
            }
        }

        return l
    }
}