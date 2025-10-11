import java.util.*

lateinit var temp: IntArray
val set = HashSet<String>()
val sb = StringBuilder()
lateinit var list: List<Int>
lateinit var visited: BooleanArray

fun main() {
    val br = System.`in`.bufferedReader()

    val (N, M) = br.readLine().split(" ").map{ it.toInt() }

    temp = IntArray(M)
    visited = BooleanArray(N)

    list = br.readLine().split(" ").map { it.toInt() }.sorted()

    bt(0)

    println(sb)
}

fun bt(depth: Int) {
    if(depth == temp.size) {
        val str = temp.joinToString(" ")
        if(set.add(str)) sb.append(str).append("\n")

        return
    }

    for(i in 0 until list.size) {
        if(visited[i]) continue

        temp[depth] = list[i]
        visited[i] = true
        bt(depth + 1)
        temp[depth] = 0
        visited[i] = false
    }
}