import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    val arr = Array(30) { IntArray(30) }
    for(i in 1 .. 29) {
        arr[i][0] = 1
    }

    for(i in 1 until 30) {
        for(j in 1 until 30) {
            if(i == j) {
                arr[i][j] = 1
                continue
            }

            arr[i][j] = arr[i-1][j] + arr[i-1][j-1]
        }
    }

    repeat(T) {
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        println(arr[M][N])
    }
}