class Solution {
    lateinit var dungeon: Array<IntArray>
    lateinit var visited: BooleanArray
    var n = 0
    var m = 0
    var answer = 0

    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        n = dungeons.size
        dungeon = dungeons
        visited = BooleanArray(n)

        bt(k, 0)

        return answer
    }

    fun bt(k: Int, depth: Int) {
        for(i in 0 until n) {
            if(visited[i]) continue
            if(k < dungeon[i][0]) continue

            visited[i] = true
            answer = maxOf(answer, depth + 1)
            bt(k - dungeon[i][1], depth + 1)
            visited[i] = false
        }
    }
}