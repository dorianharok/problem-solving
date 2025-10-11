import java.util.*

lateinit var temp: IntArray
val set = HashSet<String>()
val sb = StringBuilder()
lateinit var list: List<Int>

fun main() {
    val br = System.`in`.bufferedReader()

    val (N, M) = br.readLine().split(" ").map{ it.toInt() }

    temp = IntArray(M)

    list = br.readLine().split(" ").map { it.toInt() }.sorted()

    bt(0, 0)

    println(sb)
}

fun bt(start: Int, depth: Int) {
    if(depth == temp.size) {
        val str = temp.joinToString(" ")
        if(set.add(str)) sb.append(str).append("\n")

        return
    }

    for(i in start until list.size) {
        temp[depth] = list[i]
        bt(i, depth + 1)
        temp[depth] = 0
    }
}