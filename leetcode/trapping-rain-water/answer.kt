class Solution {
    fun trap(height: IntArray): Int {
        var answer = 0
        var left = 0
        var right = height.size - 1
        var leftMax = height[left]
        var rightMax = height[right]

        while (left < right) {
            leftMax = maxOf(leftMax, height[left])
            rightMax = maxOf(rightMax, height[right])

            if (leftMax <= rightMax) {
                answer += leftMax - height[left]
                left++
            } else {
                answer += rightMax - height[right]
                right--
            }
        }

        return answer
    }
}