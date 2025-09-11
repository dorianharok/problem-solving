import java.util.*

class Solution {
    companion object  {
        val dx = intArrayOf(-1, 0, 1, 0)
        val dy = intArrayOf(0, -1, 0, 1)
    }

    lateinit var map: Array<CharArray>
    var n = 0
    var m = 0


    fun solution(maps: Array<String>): Int {
        n = maps.size
        m = maps[0].length

        map = Array(n) { i -> maps[i].toCharArray() }

        lateinit var start: IntArray
        lateinit var lever: IntArray

        for(i in 0 until n) {
            for(j in 0 until m) {
                when(map[i][j]) {
                    'S' -> start = intArrayOf(i, j)
                    'L' -> lever = intArrayOf(i, j)
                }
            }
        }

        val startToLever = bfs(start[0], start[1], 'L')
        if(startToLever == -1) return -1
        val leverToExit = bfs(lever[0], lever[1], 'E')
        if(leverToExit == -1) return -1

        return startToLever + leverToExit
    }

    fun bfs(startX: Int, startY: Int, target: Char): Int {
        val visited = Array(n) { BooleanArray(m) }
        val q: Queue<IntArray> = ArrayDeque()

        visited[startX][startY] = true
        q.offer(intArrayOf(startX, startY, 0))

        while(q.isNotEmpty()) {
            val (x, y, time) = q.poll();

            for(i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if(map[x][y] == target) {
                    return time
                }

                if(!isValid(nx, ny, visited)) continue

                visited[nx][ny] = true
                q.offer(intArrayOf(nx, ny, time + 1))
            }
        }

        return -1
    }

    fun isValid(x: Int, y: Int, visited: Array<BooleanArray>): Boolean {
        if(x < 0 || y < 0 || x >= n || y >= m) {
            return false
        }

        if(visited[x][y]) {
            return false
        }

        if(map[x][y] == 'X') {
            return false
        }

        return true
    }
}