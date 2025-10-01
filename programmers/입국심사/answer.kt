import java.util.*
import kotlin.math.*

class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = 0

        var l = 1L
        var r = Arrays.stream(times).max().asInt.toLong() * n
        var mid = r

        while(l <= r) {
            var sum = 0L
            val mid = l + (r - l) / 2

            for(time in times) {
                sum += mid / time
            }

            if(sum >= n) {
                answer = mid
                r = mid - 1
            } else {
                l = mid + 1
            }
        }

        return answer
    }
}