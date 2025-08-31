import kotlin.math.sqrt

class Solution {
    fun isThree(n: Int): Boolean {
        if(n == 1 || n == 2) {
            return false
        }

        val ss = sqrt(n * 1.0).toInt()

        for(i in 2 until ss) {
            if(n % i == 0) {
                return false
            }
        }

        if(ss * ss != n) {
            return false
        }

        return true
    }
}