val dx = intArrayOf(-1, 0, 1, 0)
val dy = intArrayOf(0, -1, 0, 1)
val dz = intArrayOf(-1, 1)

fun main() {
    val br = System.`in`.bufferedReader()

    val (M, N, H) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(H) { Array(N) { IntArray(M) } }

    val q = ArrayDeque<IntArray>()

    repeat(H) {i ->
        repeat(N) { j ->
            arr[i][j] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        }
    }

    var zero = 0
    for(i in 0 until H) {
        for(j in 0 until N) {
            for(k in 0 until M) {
                if(arr[i][j][k] == 1) {
                    q.add(intArrayOf(i, j, k, 0))
                }

                if(arr[i][j][k] == 0) {
                    zero++
                }
            }
        }
    }

    if(zero == 0) {
        println(0)
        return
    }

    var count = 0
    while(q.isNotEmpty()) {
        val (z, x, y, day) = q.removeFirst()
        count = day

        for(i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[z][nx][ny] != 0) continue
            arr[z][nx][ny] = 1
            q.add(intArrayOf(z, nx, ny, day + 1))
        }

        for(i in 0 until 2) {
            val nz = z + dz[i]
            if(nz < 0 || nz >= H || arr[nz][x][y] != 0) continue
            arr[nz][x][y] = 1
            q.add(intArrayOf(nz, x, y, day + 1))
        }
    }

    for(i in 0 until H) {
        for(j in 0 until N) {
            for(k in 0 until M) {
                if(arr[i][j][k] == 0) {
                    println(-1)
                    return
                }
            }
        }
    }

    println(count)
}