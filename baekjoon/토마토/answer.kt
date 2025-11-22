fun main() {
    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n){ IntArray(m) }

    repeat(n) { i ->
        arr[i] = br.readLine().map { it.toInt()}.toIntArray()
    }

    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)

    val q = ArrayDeque<IntArray>()
    for(i in 0 until n) {
        for(j in 0 until m) {
            if(arr[i][j] == 1) {
                q.add(intArrayOf(i, j, 0))
            }
        }
    }

    if(q.size() == n * m) {
        println(0)
        return
    }

    var day = 0;
    while(q.isNotEmpty()) {
        val (x, y, d) = q.removeFirst()
        day = d
        for(i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue
            if(arr[nx][ny] == 0) {
                arr[nx][ny] = 1
                q.add(intArrayOf(nx, ny, d + 1))
            }
        }
    }

    println(d)
}