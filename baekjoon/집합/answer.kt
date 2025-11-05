fun main() {
    val br = System.`in`.bufferedReader()
    val M = br.readLine().toInt()

    var set = 0
    val sb = StringBuilder()
    repeat(M) {
        val list = br.readLine().split(" ")
        val command = list[0]
        var num = 0
        if (list.size > 1) {
            num = list[1].toInt()
        }

        when (command) {
            "add" -> set = set or (1 shl num)
            "remove" -> set = set and ((1 shl num).inv())
            "check" -> if (set and (1 shl num) == 0) sb.append("0\n") else sb.append("1\n")
            "toggle" -> set = set xor (1 shl num)
            "all" -> set = -1
            "empty" -> set = 0
        }
    }
    println(sb)
}