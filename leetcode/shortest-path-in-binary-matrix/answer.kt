class Solution {
    val dx = intArrayOf(0, -1, 0, 1, -1, -1, 1, 1)
    val dy = intArrayOf(-1, 0, 1, 0, -1, 1, -1, 1)
    lateinit var visited: Array<BooleanArray>
    lateinit var map: Array<IntArray>
    var n = 0

    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        n = grid.size
        map = grid
        visited = Array(n){ BooleanArray(n) }

        if(map[0][0] == 1 || map[n-1][n-1] == 1) {
            return -1
        }

        return bfs()
    }

    fun bfs(): Int {
        val q = ArrayDeque<IntArray>()
        q.add(intArrayOf(0, 0, 1))
        visited[0][0] = true

        while(q.isNotEmpty()) {
            val (x, y, dis) = q.removeFirst()
            if(x == n-1 && y == n-1) {
                return dis
            }

            for(i in 0 until 8) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if(!validate(nx, ny)) continue

                visited[nx][ny] = true
                q.add(intArrayOf(nx, ny, dis + 1))
            }
        }

        return -1
    }

    fun validate(x: Int, y: Int): Boolean {
        if(x < 0 || y < 0 || x >= n || y >= n) return false
        if(visited[x][y]) return false
        if(map[x][y] == 1) return false

        return true
    }
}