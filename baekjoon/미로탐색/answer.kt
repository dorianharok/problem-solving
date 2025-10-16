fun main() {
    val br = System.`in`.bufferedReader()

    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(N) { IntArray(M) }

    for (i in 0 until N) {
        val s = br.readLine()
        for (j in 0 until M) {
            map[i][j] = s[j] - '0'
        }
    }

    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)
    val visited = Array(N) { BooleanArray(M) }
    val q = ArrayDeque<IntArray>()
    q.add(intArrayOf(0, 0))
    visited[0][0] = true

    fun bfs() {
        while (q.isNotEmpty()) {
            val (x, y) = q.removeFirst()

            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue
                if (visited[nx][ny]) continue
                if (map[nx][ny] == 0) continue

                visited[nx][ny] = true
                map[nx][ny] = map[x][y] + 1
                q.add(intArrayOf(nx, ny))
            }
        }
    }

    bfs()
    println(map[N - 1][M - 1])
}