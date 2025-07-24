class Solution {
    fun maxArea(height: IntArray): Int {
        var max = 0
        var l = 0
        var r = height.size - 1

        while(l < r) {
            val currentArea = getArea(height, l, r)
            max = maxOf(max, currentArea)

            if(height[l] < height[r]) {
                l++
            } else {
                r--
            }
        }

        return max
    }

    fun getArea(height: IntArray, l: Int, r: Int): Int {
        return minOf(height[l], height[r]) * (r - l)
    }
}