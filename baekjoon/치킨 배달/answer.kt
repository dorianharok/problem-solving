import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N, M) = br.readLine().split(" ").map{ it.toInt() }
    val houses = mutableListOf<IntArray>()
    val chickens = mutableListOf<IntArray>()

    repeat(N) { r ->
        val row = br.readLine().split(" ").map{ it.toInt() }
        row.forEachIndexed { c, value ->
            when (value) {
                1 -> houses.add(intArrayOf(r, c))
                2 -> chickens.add(intArrayOf(r, c))
            }
        }
    }

    val visited = BooleanArray(chickens.size)
    var answer = Int.MAX_VALUE

    fun bt(count: Int, start: Int) {
        if(count == M) {
            var totalDistance = 0

            for(i in houses.indices) {

                var min = Int.MAX_VALUE
                for(j in chickens.indices) {
                    if(!visited[j]) continue
                    val distance = abs(houses[i][0] - chickens[j][0]) + abs(houses[i][1] - chickens[j][1])
                    min = min(min, distance)
                }
                totalDistance += min
            }

            answer = min(answer, totalDistance)
            return
        }

        for(i in start until chickens.size) {
            if(visited[i]) continue

            visited[i] = true
            bt(count + 1, i + 1)
            visited[i] = false
        }
    }

    bt(0, 0)

    println(answer)
}