import java.util.*

class Solution {
    lateinit var wire: MutableList<MutableList<Int>>
    lateinit var visited: BooleanArray
    var answer = 101
    var N = 0
    fun solution(n: Int, wires: Array<IntArray>): Int {
        N = n
        wire = MutableList(n + 1) { ArrayList<Int>() }

        for(w in wires) {
            wire[w[0]].add(w[1])
            wire[w[1]].add(w[0])
        }

        visited = BooleanArray(n + 1)

        dfs(1)

        return answer
    }

    fun dfs(n: Int): Int {
        visited[n] = true
        var sum = 0

        for(w in wire[n]) {
            if(visited[w]) continue

            val cnt = dfs(w)
            sum += cnt
            answer = minOf(answer, Math.abs(N - cnt * 2))
        }

        return 1 + sum
    }
}