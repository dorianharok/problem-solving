class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        val sum = brown + yellow

        for(width in sum downTo 1) {
            val height = sum / width
            val y = (width - 2) * (height - 2)
            val b = sum - y

            if(y == yellow && b == brown) {
                return intArrayOf(width, height)
            }
        }

        return intArrayOf(0, 0)
    }
}