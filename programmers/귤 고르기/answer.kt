import java.util.*

class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        val map = HashMap<Int, Int>()
        for(t in tangerine) {
            map[t] = map.getOrDefault(t, 0) + 1
        }

        val pq = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.second })
        pq.addAll(map.map { Pair(it.key, it.value) })

        var sum = 0
        var cnt = 0
        while(pq.isNotEmpty()) {
            sum += pq.poll().second
            cnt++
            if(sum >= k) {
                return cnt
            }
        }

        return 0
    }
}