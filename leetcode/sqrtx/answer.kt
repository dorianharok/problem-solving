class Solution {
    fun mySqrt(x: Int): Int {
        if(x == 0) return 0
        if(x == 1) return 1

        var l = 0L
        var r = x.toLong()

        while(l < r) {
            val mid = l + (r - l) / 2
            val pow = mid * mid

            if(pow <= x) {
                l = mid + 1
            } else {
                r = mid
            }
        }

        return (l - 1).toInt()
    }
}