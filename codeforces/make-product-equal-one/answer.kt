import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }

    var cost = 0L
    var negative = 0
    var zero = 0

    for (num in a) {
        if(num == 0) {
            cost += 1
            zero++
        } else {
            if(num < 0) {
                negative++
            }

            cost += abs(num) - 1
        }
    }

    if (negative % 2 == 1 && zero == 0) {
        cost += 2
    }

    println(cost)
}