import java.io.BufferedReader
import java.io.InputStreamReader

val dx = arrayOf(-1, 0, 1, 0)
val dy = arrayOf(0, 1, 0, -1)
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()

    repeat(T) {
        var answer = 0
        val (M, N, K) = br.readLine().split(" ").map { it.toInt() }
        val map = Array(M){IntArray(N)}

        repeat(K) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            map[x][y] = 1
        }

        for (i in 0 until M) {
            for (j in 0 until N) {
                if(map[i][j] == 1) {
                    bfs(map, i, j)
                    answer++
                }
            }
        }

        println(answer)
    }
}

fun bfs(map:Array<IntArray>, x: Int, y: Int) {
    val q = ArrayDeque<IntArray>()
    q.add(intArrayOf(x, y))
    map[x][y] = 0

    while(q.isNotEmpty()) {
        val (row, col) = q.removeFirst()

        for(i in 0 until 4) {
            val nx = row + dx[i]
            val ny = col + dy[i]

            if(nx < 0 || ny < 0 || nx >= map.size || ny >= map[0].size || map[nx][ny] != 1) {
                continue
            }

            map[nx][ny] = 0
            q.add(intArrayOf(nx, ny))
        }
    }
}