class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val n = matrix.size
        val m = matrix[0].size

        var l = 0
        var r = n * m - 1
        while(l <= r) {
            val mid = l + (r - l) / 2

            val row = mid / m
            val col = mid % m

            if(matrix[row][col] == target) {
                return true
            } else if(matrix[row][col] > target) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }

        return false
    }
}