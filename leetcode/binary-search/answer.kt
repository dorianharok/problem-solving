class Solution {
    fun search(nums: IntArray, target: Int): Int {
        return binarySearch(nums, target)
    }

    fun binarySearch(arr: IntArray, target: Int): Int {
        var left = 0
        var right = arr.size - 1

        while (left <= right) {
            val mid = (left + right) / 2
            if (arr[mid] > target) {
                right = mid -1
            } else if (arr[mid] < target) {
                left = mid +1
            } else {
                return mid
            }
        }

        return -1
    }
}