import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    val arr = Array(2) { IntArray(41) }
    arr[0][0] = 1
    arr[1][0] = 0
    arr[0][1] = 0
    arr[1][1] = 1

    for(i in 2..40) {
        arr[0][i] = arr[0][i-1] + arr[0][i-2]
        arr[1][i] = arr[1][i-1] + arr[1][i-2]
    }

    repeat(T) {
        val N = br.readLine().toInt()
        println("${arr[0][N]} ${arr[1][N]}")
    }
}