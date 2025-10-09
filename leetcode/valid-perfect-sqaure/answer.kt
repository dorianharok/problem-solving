class Solution {
    fun isPerfectSquare(num: Int): Boolean {
        var l = 1L
        var r = num.toLong()

        while(l <= r) {
            val mid = l + (r - l) / 2
            val pow = mid * mid
            if(pow == num.toLong()) {
                return true
            } else if (pow < num) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }

        return false
    }
}