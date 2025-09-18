import java.util.*

class Solution {
    fun solution(n: Long): Long {
        var nn = n
        val q = PriorityQueue<Long>(Collections.reverseOrder())

        while(nn > 0) {
            q.add(nn % 10)
            nn /= 10
        }

        val sb = StringBuilder()

        while(q.isNotEmpty()) {
            sb.append(q.poll())
        }

        return sb.toString().toLong()
    }
}