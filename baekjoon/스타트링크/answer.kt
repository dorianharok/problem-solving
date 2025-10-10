fun main(){
    val br = System.`in`.bufferedReader()

    val (F, S, G, U, D) = br.readLine().split(" ").map { it.toInt() }
    val q = ArrayDeque<IntArray>()
    q.add(intArrayOf(S, 0))
    val visited = BooleanArray(F + 1)
    visited[S] = true

    while(q.isNotEmpty()) {
        val (current, count) = q.removeFirst()

        if(current == G) {
            println(count)
            return
        }

        for(next in listOf(current + U, current - D)) {
            if(next in 1..F && !visited[next]) {
                visited[next] = true
                q.add(intArrayOf(next, count + 1))
            }
        }
    }

    println("use the stairs")
}