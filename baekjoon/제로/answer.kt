import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import javax.swing.text.html.HTML.Attribute.N

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val K = br.readLine().toInt()
    val stack = Stack<Int>()

    repeat(K) {
        val n = br.readLine().toInt()

        if(n == 0) {
            stack.pop()
        } else {
            stack.push(n)
        }
    }

    var answer = 0L
    while(stack.isNotEmpty()) {
        answer += stack.pop()
    }

    println(answer)
}